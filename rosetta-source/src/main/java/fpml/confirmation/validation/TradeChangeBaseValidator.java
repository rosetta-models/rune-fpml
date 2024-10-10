package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AgreementAndEffectiveDatesModel;
import fpml.confirmation.Trade;
import fpml.confirmation.TradeAlterationPaymentModel;
import fpml.confirmation.TradeChangeBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeChangeBaseValidator implements Validator<TradeChangeBase> {

	private List<ComparisonResult> getComparisonResults(TradeChangeBase o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("originalTrade", (Trade) o.getOriginalTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("resultingTrade", (Trade) o.getResultingTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("agreementAndEffectiveDatesModel", (AgreementAndEffectiveDatesModel) o.getAgreementAndEffectiveDatesModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("tradeAlterationPaymentModel", (TradeAlterationPaymentModel) o.getTradeAlterationPaymentModel() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<TradeChangeBase> validate(RosettaPath path, TradeChangeBase o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeChangeBase", ValidationType.CARDINALITY, "TradeChangeBase", path, "", error);
		}
		return success("TradeChangeBase", ValidationType.CARDINALITY, "TradeChangeBase", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeChangeBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeChangeBase", ValidationType.CARDINALITY, "TradeChangeBase", path, "", res.getError());
				}
				return success("TradeChangeBase", ValidationType.CARDINALITY, "TradeChangeBase", path, "");
			})
			.collect(toList());
	}

}
