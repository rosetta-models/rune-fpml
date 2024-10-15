package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanTradingCostOfCarry;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanTradingCostOfCarryTypeFormatValidator implements Validator<LoanTradingCostOfCarry> {

	private List<ComparisonResult> getComparisonResults(LoanTradingCostOfCarry o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<LoanTradingCostOfCarry> validate(RosettaPath path, LoanTradingCostOfCarry o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanTradingCostOfCarry", ValidationType.TYPE_FORMAT, "LoanTradingCostOfCarry", path, "", error);
		}
		return success("LoanTradingCostOfCarry", ValidationType.TYPE_FORMAT, "LoanTradingCostOfCarry", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradingCostOfCarry o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradingCostOfCarry", ValidationType.TYPE_FORMAT, "LoanTradingCostOfCarry", path, "", res.getError());
				}
				return success("LoanTradingCostOfCarry", ValidationType.TYPE_FORMAT, "LoanTradingCostOfCarry", path, "");
			})
			.collect(toList());
	}

}
