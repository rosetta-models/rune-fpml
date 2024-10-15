package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ProblemLocation;
import fpml.confirmation.Reason;
import fpml.confirmation.ReasonCode;
import fpml.confirmation.Validation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReasonValidator implements Validator<Reason> {

	private List<ComparisonResult> getComparisonResults(Reason o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("reasonCode", (ReasonCode) o.getReasonCode() != null ? 1 : 0, 1, 1), 
				checkCardinality("location", (ProblemLocation) o.getLocation() != null ? 1 : 0, 0, 1), 
				checkCardinality("description", (String) o.getDescription() != null ? 1 : 0, 0, 1), 
				checkCardinality("validationRuleId", (Validation) o.getValidationRuleId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<Reason> validate(RosettaPath path, Reason o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Reason", ValidationType.CARDINALITY, "Reason", path, "", error);
		}
		return success("Reason", ValidationType.CARDINALITY, "Reason", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Reason o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Reason", ValidationType.CARDINALITY, "Reason", path, "", res.getError());
				}
				return success("Reason", ValidationType.CARDINALITY, "Reason", path, "");
			})
			.collect(toList());
	}

}
