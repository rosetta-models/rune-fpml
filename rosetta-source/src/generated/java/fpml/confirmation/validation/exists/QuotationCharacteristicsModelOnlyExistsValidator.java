package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AssetMeasureType;
import fpml.confirmation.CashflowType;
import fpml.confirmation.Currency;
import fpml.confirmation.InformationSource;
import fpml.confirmation.PriceQuoteUnits;
import fpml.confirmation.PricingModel;
import fpml.confirmation.QuotationCharacteristicsModel;
import fpml.confirmation.QuotationSideEnum;
import fpml.confirmation.QuoteLocationModel;
import fpml.confirmation.QuoteTiming;
import fpml.confirmation.ReportingCurrencyType;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class QuotationCharacteristicsModelOnlyExistsValidator implements ValidatorWithArg<QuotationCharacteristicsModel, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends QuotationCharacteristicsModel> ValidationResult<QuotationCharacteristicsModel> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("measureType", ExistenceChecker.isSet((AssetMeasureType) o.getMeasureType()))
				.put("quoteUnits", ExistenceChecker.isSet((PriceQuoteUnits) o.getQuoteUnits()))
				.put("side", ExistenceChecker.isSet((QuotationSideEnum) o.getSide()))
				.put("currency", ExistenceChecker.isSet((Currency) o.getCurrency()))
				.put("currencyType", ExistenceChecker.isSet((ReportingCurrencyType) o.getCurrencyType()))
				.put("timing", ExistenceChecker.isSet((QuoteTiming) o.getTiming()))
				.put("quoteLocationModel", ExistenceChecker.isSet((QuoteLocationModel) o.getQuoteLocationModel()))
				.put("informationSource", ExistenceChecker.isSet((List<? extends InformationSource>) o.getInformationSource()))
				.put("pricingModel", ExistenceChecker.isSet((PricingModel) o.getPricingModel()))
				.put("time", ExistenceChecker.isSet((ZonedDateTime) o.getTime()))
				.put("valuationDate", ExistenceChecker.isSet((Date) o.getValuationDate()))
				.put("expiryTime", ExistenceChecker.isSet((ZonedDateTime) o.getExpiryTime()))
				.put("cashflowType", ExistenceChecker.isSet((CashflowType) o.getCashflowType()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("QuotationCharacteristicsModel", ValidationType.ONLY_EXISTS, "QuotationCharacteristicsModel", path, "");
		}
		return failure("QuotationCharacteristicsModel", ValidationType.ONLY_EXISTS, "QuotationCharacteristicsModel", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
