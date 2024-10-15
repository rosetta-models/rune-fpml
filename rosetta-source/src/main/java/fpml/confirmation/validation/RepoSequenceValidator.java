package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOffset;
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.CallingPartyEnum;
import fpml.confirmation.PartyNoticePeriod;
import fpml.confirmation.RepoSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RepoSequenceValidator implements Validator<RepoSequence> {

	private List<ComparisonResult> getComparisonResults(RepoSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("callingParty", (CallingPartyEnum) o.getCallingParty() != null ? 1 : 0, 1, 1), 
				checkCardinality("callDate", (AdjustableOrRelativeDate) o.getCallDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("noticePeriod", (AdjustableOffset) o.getNoticePeriod() != null ? 1 : 0, 0, 1), 
				checkCardinality("partyNoticePeriod", (List<? extends PartyNoticePeriod>) o.getPartyNoticePeriod() == null ? 0 : ((List<? extends PartyNoticePeriod>) o.getPartyNoticePeriod()).size(), 0, 2)
			);
	}

	@Override
	public ValidationResult<RepoSequence> validate(RosettaPath path, RepoSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RepoSequence", ValidationType.CARDINALITY, "RepoSequence", path, "", error);
		}
		return success("RepoSequence", ValidationType.CARDINALITY, "RepoSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RepoSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RepoSequence", ValidationType.CARDINALITY, "RepoSequence", path, "", res.getError());
				}
				return success("RepoSequence", ValidationType.CARDINALITY, "RepoSequence", path, "");
			})
			.collect(toList());
	}

}
