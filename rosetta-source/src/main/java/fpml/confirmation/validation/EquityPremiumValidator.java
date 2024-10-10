package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableDate;
import fpml.confirmation.EquityPremium;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.PremiumTypeEnum;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EquityPremiumValidator implements Validator<EquityPremium> {

	private List<ComparisonResult> getComparisonResults(EquityPremium o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("payerReceiverModel", (PayerReceiverModel) o.getPayerReceiverModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("premiumType", (PremiumTypeEnum) o.getPremiumType() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentAmount", (NonNegativeMoney) o.getPaymentAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("paymentDate", (AdjustableDate) o.getPaymentDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("swapPremium", (Boolean) o.getSwapPremium() != null ? 1 : 0, 0, 1), 
				checkCardinality("pricePerOption", (NonNegativeMoney) o.getPricePerOption() != null ? 1 : 0, 0, 1), 
				checkCardinality("percentageOfNotional", (BigDecimal) o.getPercentageOfNotional() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<EquityPremium> validate(RosettaPath path, EquityPremium o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EquityPremium", ValidationType.CARDINALITY, "EquityPremium", path, "", error);
		}
		return success("EquityPremium", ValidationType.CARDINALITY, "EquityPremium", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityPremium o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EquityPremium", ValidationType.CARDINALITY, "EquityPremium", path, "", res.getError());
				}
				return success("EquityPremium", ValidationType.CARDINALITY, "EquityPremium", path, "");
			})
			.collect(toList());
	}

}
