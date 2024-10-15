package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Asset;
import fpml.confirmation.AverageDailyTradingVolumeLimit;
import fpml.confirmation.DividendPayout;
import fpml.confirmation.PendingPayment;
import fpml.confirmation.SingleUnderlyer;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class SingleUnderlyerValidator implements Validator<SingleUnderlyer> {

	private List<ComparisonResult> getComparisonResults(SingleUnderlyer o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("underlyingAsset", (Asset) o.getUnderlyingAsset() != null ? 1 : 0, 1, 1), 
				checkCardinality("openUnits", (BigDecimal) o.getOpenUnits() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividendPayout", (DividendPayout) o.getDividendPayout() != null ? 1 : 0, 0, 1), 
				checkCardinality("couponPayment", (PendingPayment) o.getCouponPayment() != null ? 1 : 0, 0, 1), 
				checkCardinality("averageDailyTradingVolume", (AverageDailyTradingVolumeLimit) o.getAverageDailyTradingVolume() != null ? 1 : 0, 0, 1), 
				checkCardinality("depositoryReceipt", (Boolean) o.getDepositoryReceipt() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<SingleUnderlyer> validate(RosettaPath path, SingleUnderlyer o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("SingleUnderlyer", ValidationType.CARDINALITY, "SingleUnderlyer", path, "", error);
		}
		return success("SingleUnderlyer", ValidationType.CARDINALITY, "SingleUnderlyer", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SingleUnderlyer o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SingleUnderlyer", ValidationType.CARDINALITY, "SingleUnderlyer", path, "", res.getError());
				}
				return success("SingleUnderlyer", ValidationType.CARDINALITY, "SingleUnderlyer", path, "");
			})
			.collect(toList());
	}

}
