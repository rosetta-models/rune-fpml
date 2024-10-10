package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.FxFlexibleForward;
import fpml.confirmation.FxFlexibleForwardExecutionPeriod;
import fpml.confirmation.FxFlexibleForwardRate;
import fpml.confirmation.FxFlexibleForwardSequence;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.Payment;
import fpml.confirmation.PositiveMoney;
import fpml.confirmation.ProductModel;
import fpml.confirmation.PutCallCurrencyModel;
import fpml.confirmation.RelativeDateOffset;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxFlexibleForwardValidator implements Validator<FxFlexibleForward> {

	private List<ComparisonResult> getComparisonResults(FxFlexibleForward o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerSellerModel", (BuyerSellerModel) o.getBuyerSellerModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("putCallCurrencyModel", (PutCallCurrencyModel) o.getPutCallCurrencyModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("notionalAmount", (PositiveMoney) o.getNotionalAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("minimumExecutionAmount", (PositiveMoney) o.getMinimumExecutionAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementAmount", (NonNegativeMoney) o.getSettlementAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("executionPeriodDates", (FxFlexibleForwardExecutionPeriod) o.getExecutionPeriodDates() != null ? 1 : 0, 1, 1), 
				checkCardinality("fxFlexibleForwardSequence", (FxFlexibleForwardSequence) o.getFxFlexibleForwardSequence() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementDateOffset", (RelativeDateOffset) o.getSettlementDateOffset() != null ? 1 : 0, 0, 1), 
				checkCardinality("finalSettlementDate", (Date) o.getFinalSettlementDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("forwardRate", (FxFlexibleForwardRate) o.getForwardRate() != null ? 1 : 0, 1, 1), 
				checkCardinality("additionalPayment", (Payment) o.getAdditionalPayment() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxFlexibleForward> validate(RosettaPath path, FxFlexibleForward o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxFlexibleForward", ValidationType.CARDINALITY, "FxFlexibleForward", path, "", error);
		}
		return success("FxFlexibleForward", ValidationType.CARDINALITY, "FxFlexibleForward", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxFlexibleForward o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxFlexibleForward", ValidationType.CARDINALITY, "FxFlexibleForward", path, "", res.getError());
				}
				return success("FxFlexibleForward", ValidationType.CARDINALITY, "FxFlexibleForward", path, "");
			})
			.collect(toList());
	}

}
