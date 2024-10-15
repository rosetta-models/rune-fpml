package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableOrAdjustedDate;
import fpml.confirmation.FxCashSettlementSimple;
import fpml.confirmation.FxFixingScheduleSimple;
import fpml.confirmation.FxPerformanceFixedLeg;
import fpml.confirmation.FxPerformanceFloatingLeg;
import fpml.confirmation.FxSpotRateSource;
import fpml.confirmation.FxValuationDateOffset;
import fpml.confirmation.FxVolatilitySwap;
import fpml.confirmation.NonNegativeMoney;
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

public class FxVolatilitySwapValidator implements Validator<FxVolatilitySwap> {

	private List<ComparisonResult> getComparisonResults(FxVolatilitySwap o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("productModel", (ProductModel) o.getProductModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("quotedCurrencyPair", (QuotedCurrencyPair) o.getQuotedCurrencyPair() != null ? 1 : 0, 1, 1), 
				checkCardinality("vegaNotional", (NonNegativeMoney) o.getVegaNotional() != null ? 1 : 0, 1, 1), 
				checkCardinality("notional", (NonNegativeMoney) o.getNotional() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedLeg", (FxPerformanceFixedLeg) o.getFixedLeg() != null ? 1 : 0, 1, 1), 
				checkCardinality("floatingLeg", (FxPerformanceFloatingLeg) o.getFloatingLeg() != null ? 1 : 0, 1, 1), 
				checkCardinality("fixingInformationSource", (FxSpotRateSource) o.getFixingInformationSource() != null ? 1 : 0, 1, 1), 
				checkCardinality("fixingSchedule", (FxFixingScheduleSimple) o.getFixingSchedule() != null ? 1 : 0, 1, 1), 
				checkCardinality("valuationDate", (Date) o.getValuationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationDateOffset", (FxValuationDateOffset) o.getValuationDateOffset() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementDate", (AdjustableOrAdjustedDate) o.getSettlementDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("annualizationFactor", (BigDecimal) o.getAnnualizationFactor() != null ? 1 : 0, 1, 1), 
				checkCardinality("meanAdjustment", (Boolean) o.getMeanAdjustment() != null ? 1 : 0, 1, 1), 
				checkCardinality("numberOfReturns", (Integer) o.getNumberOfReturns() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashSettlement", (FxCashSettlementSimple) o.getCashSettlement() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FxVolatilitySwap> validate(RosettaPath path, FxVolatilitySwap o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FxVolatilitySwap", ValidationType.CARDINALITY, "FxVolatilitySwap", path, "", error);
		}
		return success("FxVolatilitySwap", ValidationType.CARDINALITY, "FxVolatilitySwap", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxVolatilitySwap o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxVolatilitySwap", ValidationType.CARDINALITY, "FxVolatilitySwap", path, "", res.getError());
				}
				return success("FxVolatilitySwap", ValidationType.CARDINALITY, "FxVolatilitySwap", path, "");
			})
			.collect(toList());
	}

}
