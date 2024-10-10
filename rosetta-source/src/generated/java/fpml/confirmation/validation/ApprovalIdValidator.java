package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ApprovalId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ApprovalIdValidator implements Validator<ApprovalId> {

	private List<ComparisonResult> getComparisonResults(ApprovalId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("approvalIdScheme", (String) o.getApprovalIdScheme() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ApprovalId> validate(RosettaPath path, ApprovalId o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ApprovalId", ValidationType.CARDINALITY, "ApprovalId", path, "", error);
		}
		return success("ApprovalId", ValidationType.CARDINALITY, "ApprovalId", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ApprovalId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ApprovalId", ValidationType.CARDINALITY, "ApprovalId", path, "", res.getError());
				}
				return success("ApprovalId", ValidationType.CARDINALITY, "ApprovalId", path, "");
			})
			.collect(toList());
	}

}
