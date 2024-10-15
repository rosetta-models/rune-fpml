package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ObservationFrequency;
import fpml.confirmation.PeriodEnum;
import fpml.confirmation.RollConventionEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ObservationFrequencyValidator implements Validator<ObservationFrequency> {

	private List<ComparisonResult> getComparisonResults(ObservationFrequency o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("periodMultiplier", (Integer) o.getPeriodMultiplier() != null ? 1 : 0, 1, 1), 
				checkCardinality("period", (PeriodEnum) o.getPeriod() != null ? 1 : 0, 1, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("periodConvention", (RollConventionEnum) o.getPeriodConvention() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ObservationFrequency> validate(RosettaPath path, ObservationFrequency o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ObservationFrequency", ValidationType.CARDINALITY, "ObservationFrequency", path, "", error);
		}
		return success("ObservationFrequency", ValidationType.CARDINALITY, "ObservationFrequency", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ObservationFrequency o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ObservationFrequency", ValidationType.CARDINALITY, "ObservationFrequency", path, "", res.getError());
				}
				return success("ObservationFrequency", ValidationType.CARDINALITY, "ObservationFrequency", path, "");
			})
			.collect(toList());
	}

}
