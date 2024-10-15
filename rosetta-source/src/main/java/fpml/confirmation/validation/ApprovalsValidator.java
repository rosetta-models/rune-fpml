package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Approval;
import fpml.confirmation.Approvals;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ApprovalsValidator implements Validator<Approvals> {

	private List<ComparisonResult> getComparisonResults(Approvals o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("approval", (List<? extends Approval>) o.getApproval() == null ? 0 : ((List<? extends Approval>) o.getApproval()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<Approvals> validate(RosettaPath path, Approvals o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Approvals", ValidationType.CARDINALITY, "Approvals", path, "", error);
		}
		return success("Approvals", ValidationType.CARDINALITY, "Approvals", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Approvals o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Approvals", ValidationType.CARDINALITY, "Approvals", path, "", res.getError());
				}
				return success("Approvals", ValidationType.CARDINALITY, "Approvals", path, "");
			})
			.collect(toList());
	}

}
