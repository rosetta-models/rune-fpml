package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BusinessCenterTime;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.FxForwardVolatilityAgreement;
import fpml.confirmation.FxStraddle;
import fpml.confirmation.ProductModel;
import fpml.confirmation.QuotedCurrencyPair;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FxForwardVolatilityAgreementValidator implements Validator<FxForwardVolatilityAgreement> {

	private List<ComparisonResult> getComparisonResults(FxForwardVolatilityAgreement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerSellerModel", (BuyerSellerModel) o.getBuyerSellerModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("quotedCurrencyPair", (QuotedCurrencyPair) o.getQuotedCurrencyPair() != null ? 1 : 0, 1, 1), 
				checkCardinality("fixingDate", (Date) o.getFixingDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("fixingTime", (BusinessCenterTime) o.getFixingTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("forwardVolatilityStrikePrice", (BigDecimal) o.getForwardVolatilityStrikePrice() != null ? 1 : 0, 1, 1), 
				checkCardinality("straddle", (FxStraddle) o.getStraddle() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<FxForwardVolatilityAgreement> validate(RosettaPath path, FxForwardVolatilityAgreement o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxForwardVolatilityAgreement", ValidationType.CARDINALITY, "FxForwardVolatilityAgreement", path, "", error);
		}
		return success("FxForwardVolatilityAgreement", ValidationType.CARDINALITY, "FxForwardVolatilityAgreement", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxForwardVolatilityAgreement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxForwardVolatilityAgreement", ValidationType.CARDINALITY, "FxForwardVolatilityAgreement", path, "", res.getError());
				}
				return success("FxForwardVolatilityAgreement", ValidationType.CARDINALITY, "FxForwardVolatilityAgreement", path, "");
			})
			.collect(toList());
	}

}
