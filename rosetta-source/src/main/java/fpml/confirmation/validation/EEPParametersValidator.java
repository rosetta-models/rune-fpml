package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EEPParameters;
import fpml.confirmation.EEPRiskPeriod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EEPParametersValidator implements Validator<EEPParameters> {

	private List<ComparisonResult> getComparisonResults(EEPParameters o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("eEPApplicable", (Boolean) o.getEEPApplicable() != null ? 1 : 0, 1, 1), 
				checkCardinality("riskPeriod", (EEPRiskPeriod) o.getRiskPeriod() != null ? 1 : 0, 1, 1), 
				checkCardinality("equivalentApplicable", (Boolean) o.getEquivalentApplicable() != null ? 1 : 0, 1, 1), 
				checkCardinality("penaltyApplicable", (Boolean) o.getPenaltyApplicable() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<EEPParameters> validate(RosettaPath path, EEPParameters o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EEPParameters", ValidationType.CARDINALITY, "EEPParameters", path, "", error);
		}
		return success("EEPParameters", ValidationType.CARDINALITY, "EEPParameters", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EEPParameters o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EEPParameters", ValidationType.CARDINALITY, "EEPParameters", path, "", res.getError());
				}
				return success("EEPParameters", ValidationType.CARDINALITY, "EEPParameters", path, "");
			})
			.collect(toList());
	}

}
