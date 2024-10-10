package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AccrualPeriod;
import fpml.confirmation.LoanTradingCostOfCarryAccrual;
import fpml.confirmation.UtilizationPeriod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class LoanTradingCostOfCarryAccrualValidator implements Validator<LoanTradingCostOfCarryAccrual> {

	private List<ComparisonResult> getComparisonResults(LoanTradingCostOfCarryAccrual o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("utilizationPeriod", (List<? extends UtilizationPeriod>) o.getUtilizationPeriod() == null ? 0 : ((List<? extends UtilizationPeriod>) o.getUtilizationPeriod()).size(), 1, 0), 
				checkCardinality("commencementAccrual", (AccrualPeriod) o.getCommencementAccrual() != null ? 1 : 0, 0, 1)
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
			return failure("LoanTradingCostOfCarryAccrual", ValidationType.CARDINALITY, "LoanTradingCostOfCarryAccrual", path, "", error);
		}
		return success("LoanTradingCostOfCarryAccrual", ValidationType.CARDINALITY, "LoanTradingCostOfCarryAccrual", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanTradingCostOfCarryAccrual o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanTradingCostOfCarryAccrual", ValidationType.CARDINALITY, "LoanTradingCostOfCarryAccrual", path, "", res.getError());
				}
				return success("LoanTradingCostOfCarryAccrual", ValidationType.CARDINALITY, "LoanTradingCostOfCarryAccrual", path, "");
			})
			.collect(toList());
	}

}
