package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CommitmentChange;
import fpml.confirmation.CommitmentSchedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CommitmentScheduleValidator implements Validator<CommitmentSchedule> {

	private List<ComparisonResult> getComparisonResults(CommitmentSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("commitmentChange", (List<? extends CommitmentChange>) o.getCommitmentChange() == null ? 0 : ((List<? extends CommitmentChange>) o.getCommitmentChange()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<CommitmentSchedule> validate(RosettaPath path, CommitmentSchedule o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CommitmentSchedule", ValidationType.CARDINALITY, "CommitmentSchedule", path, "", error);
		}
		return success("CommitmentSchedule", ValidationType.CARDINALITY, "CommitmentSchedule", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CommitmentSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CommitmentSchedule", ValidationType.CARDINALITY, "CommitmentSchedule", path, "", res.getError());
				}
				return success("CommitmentSchedule", ValidationType.CARDINALITY, "CommitmentSchedule", path, "");
			})
			.collect(toList());
	}

}
