package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.GenericFrequency;
import fpml.confirmation.PartyReference;
import fpml.confirmation.PeriodExtendedEnum;
import fpml.confirmation.UnderlyerReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class GenericFrequencyValidator implements Validator<GenericFrequency> {

	private List<ComparisonResult> getComparisonResults(GenericFrequency o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("periodMultiplier", (Integer) o.getPeriodMultiplier() != null ? 1 : 0, 1, 1), 
				checkCardinality("period", (PeriodExtendedEnum) o.getPeriod() != null ? 1 : 0, 1, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerPartyReference", (PartyReference) o.getPayerPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyerReference", (UnderlyerReference) o.getUnderlyerReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<GenericFrequency> validate(RosettaPath path, GenericFrequency o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("GenericFrequency", ValidationType.CARDINALITY, "GenericFrequency", path, "", error);
		}
		return success("GenericFrequency", ValidationType.CARDINALITY, "GenericFrequency", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericFrequency o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericFrequency", ValidationType.CARDINALITY, "GenericFrequency", path, "", res.getError());
				}
				return success("GenericFrequency", ValidationType.CARDINALITY, "GenericFrequency", path, "");
			})
			.collect(toList());
	}

}
