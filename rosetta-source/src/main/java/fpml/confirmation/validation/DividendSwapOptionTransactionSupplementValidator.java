package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.BuyerSellerModel;
import fpml.confirmation.DividendSwapOptionTransactionSupplement;
import fpml.confirmation.DividendSwapTransactionSupplement;
import fpml.confirmation.EquityExerciseValuationSettlement;
import fpml.confirmation.EquityPremium;
import fpml.confirmation.MethodOfAdjustmentEnum;
import fpml.confirmation.OptionTypeEnum;
import fpml.confirmation.ProductModel;
import fpml.confirmation.SwaptionPhysicalSettlement;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DividendSwapOptionTransactionSupplementValidator implements Validator<DividendSwapOptionTransactionSupplement> {

	private List<ComparisonResult> getComparisonResults(DividendSwapOptionTransactionSupplement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("buyerSellerModel", (BuyerSellerModel) o.getBuyerSellerModel() != null ? 1 : 0, 1, 1), 
				checkCardinality("optionType", (OptionTypeEnum) o.getOptionType() != null ? 1 : 0, 1, 1), 
				checkCardinality("equityPremium", (EquityPremium) o.getEquityPremium() != null ? 1 : 0, 1, 1), 
				checkCardinality("equityExercise", (EquityExerciseValuationSettlement) o.getEquityExercise() != null ? 1 : 0, 1, 1), 
				checkCardinality("exchangeLookAlike", (Boolean) o.getExchangeLookAlike() != null ? 1 : 0, 0, 1), 
				checkCardinality("methodOfAdjustment", (MethodOfAdjustmentEnum) o.getMethodOfAdjustment() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionEntitlement", (BigDecimal) o.getOptionEntitlement() != null ? 1 : 0, 0, 1), 
				checkCardinality("multiplier", (BigDecimal) o.getMultiplier() != null ? 1 : 0, 0, 1), 
				checkCardinality("clearingInstructions", (SwaptionPhysicalSettlement) o.getClearingInstructions() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividendSwapTransactionSupplement", (DividendSwapTransactionSupplement) o.getDividendSwapTransactionSupplement() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<DividendSwapOptionTransactionSupplement> validate(RosettaPath path, DividendSwapOptionTransactionSupplement o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DividendSwapOptionTransactionSupplement", ValidationType.CARDINALITY, "DividendSwapOptionTransactionSupplement", path, "", error);
		}
		return success("DividendSwapOptionTransactionSupplement", ValidationType.CARDINALITY, "DividendSwapOptionTransactionSupplement", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendSwapOptionTransactionSupplement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DividendSwapOptionTransactionSupplement", ValidationType.CARDINALITY, "DividendSwapOptionTransactionSupplement", path, "", res.getError());
				}
				return success("DividendSwapOptionTransactionSupplement", ValidationType.CARDINALITY, "DividendSwapOptionTransactionSupplement", path, "");
			})
			.collect(toList());
	}

}
