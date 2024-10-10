package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.LoanTradingCostOfCarryAccrual;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanTradingCostOfCarryAccrualTypeFormatValidator implements Validator<LoanTradingCostOfCarryAccrual> {

	private List<ComparisonResult> getComparisonResults(LoanTradingCostOfCarryAccrual o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<LoanTradingCostOfCarryAccrual> validate(RosettaPath path, LoanTradingCostOfCarryAccrual o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("LoanTradingCostOfCarryAccrual", ValidationType.TYPE_FORMAT, "LoanTradingCostOfCarryAccrual", path, "", error);
		}
		return success("LoanTradingCostOfCarryAccrual", ValidationType.TYPE_FORMAT, "LoanTradingCostOfCarryAccrual", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradingCostOfCarryAccrual o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradingCostOfCarryAccrual", ValidationType.TYPE_FORMAT, "LoanTradingCostOfCarryAccrual", path, "", res.getError());
				}
				return success("LoanTradingCostOfCarryAccrual", ValidationType.TYPE_FORMAT, "LoanTradingCostOfCarryAccrual", path, "");
			})
			.collect(toList());
	}

}
