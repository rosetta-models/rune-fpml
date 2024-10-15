package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AssetMeasureType;
import fpml.confirmation.CashflowType;
import fpml.confirmation.Currency;
import fpml.confirmation.PriceQuoteUnits;
import fpml.confirmation.PricingModel;
import fpml.confirmation.QuotationCharacteristicsModel;
import fpml.confirmation.QuotationSideEnum;
import fpml.confirmation.QuoteLocationModel;
import fpml.confirmation.QuoteTiming;
import fpml.confirmation.ReportingCurrencyType;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class QuotationCharacteristicsModelValidator implements Validator<QuotationCharacteristicsModel> {

	private List<ComparisonResult> getComparisonResults(QuotationCharacteristicsModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("measureType", (AssetMeasureType) o.getMeasureType() != null ? 1 : 0, 0, 1), 
				checkCardinality("quoteUnits", (PriceQuoteUnits) o.getQuoteUnits() != null ? 1 : 0, 0, 1), 
				checkCardinality("side", (QuotationSideEnum) o.getSide() != null ? 1 : 0, 0, 1), 
				checkCardinality("currency", (Currency) o.getCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("currencyType", (ReportingCurrencyType) o.getCurrencyType() != null ? 1 : 0, 0, 1), 
				checkCardinality("timing", (QuoteTiming) o.getTiming() != null ? 1 : 0, 0, 1), 
				checkCardinality("quoteLocationModel", (QuoteLocationModel) o.getQuoteLocationModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("pricingModel", (PricingModel) o.getPricingModel() != null ? 1 : 0, 0, 1), 
				checkCardinality("time", (ZonedDateTime) o.getTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationDate", (Date) o.getValuationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("expiryTime", (ZonedDateTime) o.getExpiryTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashflowType", (CashflowType) o.getCashflowType() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<QuotationCharacteristicsModel> validate(RosettaPath path, QuotationCharacteristicsModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("QuotationCharacteristicsModel", ValidationType.CARDINALITY, "QuotationCharacteristicsModel", path, "", error);
		}
		return success("QuotationCharacteristicsModel", ValidationType.CARDINALITY, "QuotationCharacteristicsModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, QuotationCharacteristicsModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("QuotationCharacteristicsModel", ValidationType.CARDINALITY, "QuotationCharacteristicsModel", path, "", res.getError());
				}
				return success("QuotationCharacteristicsModel", ValidationType.CARDINALITY, "QuotationCharacteristicsModel", path, "");
			})
			.collect(toList());
	}

}
