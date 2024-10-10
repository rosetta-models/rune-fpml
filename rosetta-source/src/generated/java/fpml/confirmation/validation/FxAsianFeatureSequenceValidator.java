package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FxAsianFeatureSequence;
import fpml.confirmation.FxAverageRateObservationSchedule;
import fpml.confirmation.FxRateObservationModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxAsianFeatureSequenceValidator implements Validator<FxAsianFeatureSequence> {

	private List<ComparisonResult> getComparisonResults(FxAsianFeatureSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("observationSchedule", (FxAverageRateObservationSchedule) o.getObservationSchedule() != null ? 1 : 0, 1, 1), 
				checkCardinality("fxRateObservationModel", (FxRateObservationModel) o.getFxRateObservationModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxAsianFeatureSequence> validate(RosettaPath path, FxAsianFeatureSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxAsianFeatureSequence", ValidationType.CARDINALITY, "FxAsianFeatureSequence", path, "", error);
		}
		return success("FxAsianFeatureSequence", ValidationType.CARDINALITY, "FxAsianFeatureSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAsianFeatureSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAsianFeatureSequence", ValidationType.CARDINALITY, "FxAsianFeatureSequence", path, "", res.getError());
				}
				return success("FxAsianFeatureSequence", ValidationType.CARDINALITY, "FxAsianFeatureSequence", path, "");
			})
			.collect(toList());
	}

}
