package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Approval;
import fpml.confirmation.ApprovalId;
import fpml.confirmation.ApprovalType;
import fpml.confirmation.PartyReference;
import fpml.confirmation.PersonId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ApprovalValidator implements Validator<Approval> {

	private List<ComparisonResult> getComparisonResults(Approval o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("_type", (ApprovalType) o.get_type() != null ? 1 : 0, 1, 1), 
				checkCardinality("status", (String) o.getStatus() != null ? 1 : 0, 1, 1), 
				checkCardinality("approver", (PersonId) o.getApprover() != null ? 1 : 0, 0, 1), 
				checkCardinality("approvingPartyReference", (PartyReference) o.getApprovingPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("approvedPartyReference", (PartyReference) o.getApprovedPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("approvalId", (ApprovalId) o.getApprovalId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<Approval> validate(RosettaPath path, Approval o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Approval", ValidationType.CARDINALITY, "Approval", path, "", error);
		}
		return success("Approval", ValidationType.CARDINALITY, "Approval", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Approval o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Approval", ValidationType.CARDINALITY, "Approval", path, "", res.getError());
				}
				return success("Approval", ValidationType.CARDINALITY, "Approval", path, "");
			})
			.collect(toList());
	}

}
