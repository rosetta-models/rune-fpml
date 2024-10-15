package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanAllocationIdentifier;
import fpml.confirmation.LoanTradeReference;
import fpml.confirmation.OverrideIdentifier;
import fpml.confirmation.SettlementDetails;
import fpml.confirmation.TradingInstructionOverride;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradingInstructionOverrideValidator implements Validator<TradingInstructionOverride> {

	private List<ComparisonResult> getComparisonResults(TradingInstructionOverride o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("overrideIdentifier", (OverrideIdentifier) o.getOverrideIdentifier() != null ? 1 : 0, 1, 1), 
				checkCardinality("allocationIdentifier", (LoanAllocationIdentifier) o.getAllocationIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("loanTradeReference", (LoanTradeReference) o.getLoanTradeReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementDetails", (List<? extends SettlementDetails>) o.getSettlementDetails() == null ? 0 : ((List<? extends SettlementDetails>) o.getSettlementDetails()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<TradingInstructionOverride> validate(RosettaPath path, TradingInstructionOverride o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradingInstructionOverride", ValidationType.CARDINALITY, "TradingInstructionOverride", path, "", error);
		}
		return success("TradingInstructionOverride", ValidationType.CARDINALITY, "TradingInstructionOverride", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradingInstructionOverride o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradingInstructionOverride", ValidationType.CARDINALITY, "TradingInstructionOverride", path, "", res.getError());
				}
				return success("TradingInstructionOverride", ValidationType.CARDINALITY, "TradingInstructionOverride", path, "");
			})
			.collect(toList());
	}

}
