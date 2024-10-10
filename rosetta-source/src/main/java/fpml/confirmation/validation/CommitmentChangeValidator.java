package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustmentType;
import fpml.confirmation.CommitmentChange;
import fpml.confirmation.MoneyWithParticipantShare;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommitmentChangeValidator implements Validator<CommitmentChange> {

	private List<ComparisonResult> getComparisonResults(CommitmentChange o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("date", (Date) o.getDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("adjustment", (AdjustmentType) o.getAdjustment() != null ? 1 : 0, 1, 1), 
				checkCardinality("remaining", (MoneyWithParticipantShare) o.getRemaining() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CommitmentChange> validate(RosettaPath path, CommitmentChange o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommitmentChange", ValidationType.CARDINALITY, "CommitmentChange", path, "", error);
		}
		return success("CommitmentChange", ValidationType.CARDINALITY, "CommitmentChange", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommitmentChange o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommitmentChange", ValidationType.CARDINALITY, "CommitmentChange", path, "", res.getError());
				}
				return success("CommitmentChange", ValidationType.CARDINALITY, "CommitmentChange", path, "");
			})
			.collect(toList());
	}

}
