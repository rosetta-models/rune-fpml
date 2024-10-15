package fpml.confirmation.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableOrAdjustedDate;
import fpml.confirmation.FxCashSettlementSimple;
import fpml.confirmation.FxFixingScheduleSimple;
import fpml.confirmation.FxPerformanceFixedLeg;
import fpml.confirmation.FxPerformanceFloatingLeg;
import fpml.confirmation.FxSpotRateSource;
import fpml.confirmation.FxValuationDateOffset;
import fpml.confirmation.FxVarianceSwap;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.Payment;
import fpml.confirmation.ProductModel;
import fpml.confirmation.QuotedCurrencyPair;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class FxVarianceSwapOnlyExistsValidator implements ValidatorWithArg<FxVarianceSwap, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends FxVarianceSwap> ValidationResult<FxVarianceSwap> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("productModel", ExistenceChecker.isSet((ProductModel) o.getProductModel()))
				.put("id", ExistenceChecker.isSet((String) o.getId()))
				.put("quotedCurrencyPair", ExistenceChecker.isSet((QuotedCurrencyPair) o.getQuotedCurrencyPair()))
				.put("vegaNotional", ExistenceChecker.isSet((NonNegativeMoney) o.getVegaNotional()))
				.put("notional", ExistenceChecker.isSet((NonNegativeMoney) o.getNotional()))
				.put("fixedLeg", ExistenceChecker.isSet((FxPerformanceFixedLeg) o.getFixedLeg()))
				.put("floatingLeg", ExistenceChecker.isSet((FxPerformanceFloatingLeg) o.getFloatingLeg()))
				.put("fixingInformationSource", ExistenceChecker.isSet((FxSpotRateSource) o.getFixingInformationSource()))
				.put("fixingSchedule", ExistenceChecker.isSet((FxFixingScheduleSimple) o.getFixingSchedule()))
				.put("valuationDate", ExistenceChecker.isSet((Date) o.getValuationDate()))
				.put("valuationDateOffset", ExistenceChecker.isSet((FxValuationDateOffset) o.getValuationDateOffset()))
				.put("settlementDate", ExistenceChecker.isSet((AdjustableOrAdjustedDate) o.getSettlementDate()))
				.put("annualizationFactor", ExistenceChecker.isSet((BigDecimal) o.getAnnualizationFactor()))
				.put("meanAdjustment", ExistenceChecker.isSet((Boolean) o.getMeanAdjustment()))
				.put("numberOfReturns", ExistenceChecker.isSet((Integer) o.getNumberOfReturns()))
				.put("additionalPayment", ExistenceChecker.isSet((List<? extends Payment>) o.getAdditionalPayment()))
				.put("cashSettlement", ExistenceChecker.isSet((FxCashSettlementSimple) o.getCashSettlement()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FxVarianceSwap", ValidationType.ONLY_EXISTS, "FxVarianceSwap", path, "");
		}
		return failure("FxVarianceSwap", ValidationType.ONLY_EXISTS, "FxVarianceSwap", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
