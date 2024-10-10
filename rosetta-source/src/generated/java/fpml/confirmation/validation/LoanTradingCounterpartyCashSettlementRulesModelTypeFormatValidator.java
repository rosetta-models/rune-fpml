package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanTradingCounterpartyCashSettlementRulesModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanTradingCounterpartyCashSettlementRulesModelTypeFormatValidator implements Validator<LoanTradingCounterpartyCashSettlementRulesModel> {

	private List<ComparisonResult> getComparisonResults(LoanTradingCounterpartyCashSettlementRulesModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<LoanTradingCounterpartyCashSettlementRulesModel> validate(RosettaPath path, LoanTradingCounterpartyCashSettlementRulesModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanTradingCounterpartyCashSettlementRulesModel", ValidationType.TYPE_FORMAT, "LoanTradingCounterpartyCashSettlementRulesModel", path, "", error);
		}
		return success("LoanTradingCounterpartyCashSettlementRulesModel", ValidationType.TYPE_FORMAT, "LoanTradingCounterpartyCashSettlementRulesModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradingCounterpartyCashSettlementRulesModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradingCounterpartyCashSettlementRulesModel", ValidationType.TYPE_FORMAT, "LoanTradingCounterpartyCashSettlementRulesModel", path, "", res.getError());
				}
				return success("LoanTradingCounterpartyCashSettlementRulesModel", ValidationType.TYPE_FORMAT, "LoanTradingCounterpartyCashSettlementRulesModel", path, "");
			})
			.collect(toList());
	}

}
