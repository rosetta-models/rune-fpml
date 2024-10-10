package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Asset;
import fpml.confirmation.BasketConstituent;
import fpml.confirmation.Collateral;
import fpml.confirmation.ConstituentWeight;
import fpml.confirmation.DividendPayout;
import fpml.confirmation.Money;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PendingPayment;
import fpml.confirmation.Price;
import fpml.confirmation.SpreadScheduleReference;
import fpml.confirmation.UnderlyerInterestLeg;
import fpml.confirmation.UnderlyerLoanRate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class BasketConstituentValidator implements Validator<BasketConstituent> {

	private List<ComparisonResult> getComparisonResults(BasketConstituent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("payerReceiverModel", (PayerReceiverModel) o.getPayerReceiverModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyingAsset", (Asset) o.getUnderlyingAsset() != null ? 1 : 0, 1, 1), 
				checkCardinality("constituentWeight", (ConstituentWeight) o.getConstituentWeight() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividendPayout", (DividendPayout) o.getDividendPayout() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyerPrice", (Price) o.getUnderlyerPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyerNotional", (Money) o.getUnderlyerNotional() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyerSpread", (SpreadScheduleReference) o.getUnderlyerSpread() != null ? 1 : 0, 0, 1), 
				checkCardinality("couponPayment", (PendingPayment) o.getCouponPayment() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyerFinancing", (UnderlyerInterestLeg) o.getUnderlyerFinancing() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyerLoanRate", (UnderlyerLoanRate) o.getUnderlyerLoanRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("underlyerCollateral", (Collateral) o.getUnderlyerCollateral() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<BasketConstituent> validate(RosettaPath path, BasketConstituent o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("BasketConstituent", ValidationType.CARDINALITY, "BasketConstituent", path, "", error);
		}
		return success("BasketConstituent", ValidationType.CARDINALITY, "BasketConstituent", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BasketConstituent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BasketConstituent", ValidationType.CARDINALITY, "BasketConstituent", path, "", res.getError());
				}
				return success("BasketConstituent", ValidationType.CARDINALITY, "BasketConstituent", path, "");
			})
			.collect(toList());
	}

}
