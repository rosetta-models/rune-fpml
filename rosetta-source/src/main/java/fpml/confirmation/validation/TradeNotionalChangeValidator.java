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
import fpml.confirmation.TradeNotionalChange;
import fpml.confirmation.TradeNotionalChangeModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TradeNotionalChangeValidator implements Validator<TradeNotionalChange> {

	private List<ComparisonResult> getComparisonResults(TradeNotionalChange o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("originalTrade", (Trade) o.getOriginalTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("resultingTrade", (Trade) o.getResultingTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("agreementAndEffectiveDatesModel", (AgreementAndEffectiveDatesModel) o.getAgreementAndEffectiveDatesModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("tradeAlterationPaymentModel", (TradeAlterationPaymentModel) o.getTradeAlterationPaymentModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("tradeNotionalChangeModel", (TradeNotionalChangeModel) o.getTradeNotionalChangeModel() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<TradeNotionalChange> validate(RosettaPath path, TradeNotionalChange o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TradeNotionalChange", ValidationType.CARDINALITY, "TradeNotionalChange", path, "", error);
		}
		return success("TradeNotionalChange", ValidationType.CARDINALITY, "TradeNotionalChange", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeNotionalChange o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeNotionalChange", ValidationType.CARDINALITY, "TradeNotionalChange", path, "", res.getError());
				}
				return success("TradeNotionalChange", ValidationType.CARDINALITY, "TradeNotionalChange", path, "");
			})
			.collect(toList());
	}

}
