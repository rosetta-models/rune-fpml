package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanTradingCounterpartySettlementFundingFactorsSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanTradingCounterpartySettlementFundingFactorsSequenceTypeFormatValidator implements Validator<LoanTradingCounterpartySettlementFundingFactorsSequence> {

	private List<ComparisonResult> getComparisonResults(LoanTradingCounterpartySettlementFundingFactorsSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<LoanTradingCounterpartySettlementFundingFactorsSequence> validate(RosettaPath path, LoanTradingCounterpartySettlementFundingFactorsSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanTradingCounterpartySettlementFundingFactorsSequence", ValidationType.TYPE_FORMAT, "LoanTradingCounterpartySettlementFundingFactorsSequence", path, "", error);
		}
		return success("LoanTradingCounterpartySettlementFundingFactorsSequence", ValidationType.TYPE_FORMAT, "LoanTradingCounterpartySettlementFundingFactorsSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradingCounterpartySettlementFundingFactorsSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradingCounterpartySettlementFundingFactorsSequence", ValidationType.TYPE_FORMAT, "LoanTradingCounterpartySettlementFundingFactorsSequence", path, "", res.getError());
				}
				return success("LoanTradingCounterpartySettlementFundingFactorsSequence", ValidationType.TYPE_FORMAT, "LoanTradingCounterpartySettlementFundingFactorsSequence", path, "");
			})
			.collect(toList());
	}

}
