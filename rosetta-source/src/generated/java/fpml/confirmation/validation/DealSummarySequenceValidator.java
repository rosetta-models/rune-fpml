package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DealSummarySequence;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.NonNegativeMoney;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DealSummarySequenceValidator implements Validator<DealSummarySequence> {

	private List<ComparisonResult> getComparisonResults(DealSummarySequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("issuedAmount", (NonNegativeMoney) o.getIssuedAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("currentDealAmount", (MoneyWithParticipantShare) o.getCurrentDealAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<DealSummarySequence> validate(RosettaPath path, DealSummarySequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DealSummarySequence", ValidationType.CARDINALITY, "DealSummarySequence", path, "", error);
		}
		return success("DealSummarySequence", ValidationType.CARDINALITY, "DealSummarySequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DealSummarySequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DealSummarySequence", ValidationType.CARDINALITY, "DealSummarySequence", path, "", res.getError());
				}
				return success("DealSummarySequence", ValidationType.CARDINALITY, "DealSummarySequence", path, "");
			})
			.collect(toList());
	}

}
