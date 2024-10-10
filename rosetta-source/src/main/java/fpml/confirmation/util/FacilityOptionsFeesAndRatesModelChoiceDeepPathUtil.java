package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.AccrualTypeId;
import fpml.confirmation.DayCountFraction;
import fpml.confirmation.FacilityOptionsFeesAndRatesModelChoice;
import fpml.confirmation.FixedRateOption;
import fpml.confirmation.FloatingRateOption;
import fpml.confirmation.LcOption;
import fpml.confirmation.Period;
import fpml.confirmation.PeriodModel;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class FacilityOptionsFeesAndRatesModelChoiceDeepPathUtil {
	public AccrualTypeId chooseAccrualOptionId(FacilityOptionsFeesAndRatesModelChoice facilityOptionsFeesAndRatesModelChoice) {
		final MapperS<FixedRateOption> fixedRateOption = MapperS.of(facilityOptionsFeesAndRatesModelChoice).<FixedRateOption>map("getFixedRateOption", _facilityOptionsFeesAndRatesModelChoice -> _facilityOptionsFeesAndRatesModelChoice.getFixedRateOption());
		if (exists(fixedRateOption).getOrDefault(false)) {
			return fixedRateOption.<AccrualTypeId>map("getAccrualOptionId", _fixedRateOption -> _fixedRateOption.getAccrualOptionId()).get();
		}
		final MapperS<FloatingRateOption> floatingRateOption = MapperS.of(facilityOptionsFeesAndRatesModelChoice).<FloatingRateOption>map("getFloatingRateOption", _facilityOptionsFeesAndRatesModelChoice -> _facilityOptionsFeesAndRatesModelChoice.getFloatingRateOption());
		if (exists(floatingRateOption).getOrDefault(false)) {
			return floatingRateOption.<AccrualTypeId>map("getAccrualOptionId", _floatingRateOption -> _floatingRateOption.getAccrualOptionId()).get();
		}
		final MapperS<LcOption> lcOption = MapperS.of(facilityOptionsFeesAndRatesModelChoice).<LcOption>map("getLcOption", _facilityOptionsFeesAndRatesModelChoice -> _facilityOptionsFeesAndRatesModelChoice.getLcOption());
		if (exists(lcOption).getOrDefault(false)) {
			return lcOption.<AccrualTypeId>map("getAccrualOptionId", _lcOption -> _lcOption.getAccrualOptionId()).get();
		}
		return null;
	}
	
	public DayCountFraction chooseDayCountFraction(FacilityOptionsFeesAndRatesModelChoice facilityOptionsFeesAndRatesModelChoice) {
		final MapperS<FixedRateOption> fixedRateOption = MapperS.of(facilityOptionsFeesAndRatesModelChoice).<FixedRateOption>map("getFixedRateOption", _facilityOptionsFeesAndRatesModelChoice -> _facilityOptionsFeesAndRatesModelChoice.getFixedRateOption());
		if (exists(fixedRateOption).getOrDefault(false)) {
			return fixedRateOption.<DayCountFraction>map("getDayCountFraction", _fixedRateOption -> _fixedRateOption.getDayCountFraction()).get();
		}
		final MapperS<FloatingRateOption> floatingRateOption = MapperS.of(facilityOptionsFeesAndRatesModelChoice).<FloatingRateOption>map("getFloatingRateOption", _facilityOptionsFeesAndRatesModelChoice -> _facilityOptionsFeesAndRatesModelChoice.getFloatingRateOption());
		if (exists(floatingRateOption).getOrDefault(false)) {
			return floatingRateOption.<DayCountFraction>map("getDayCountFraction", _floatingRateOption -> _floatingRateOption.getDayCountFraction()).get();
		}
		final MapperS<LcOption> lcOption = MapperS.of(facilityOptionsFeesAndRatesModelChoice).<LcOption>map("getLcOption", _facilityOptionsFeesAndRatesModelChoice -> _facilityOptionsFeesAndRatesModelChoice.getLcOption());
		if (exists(lcOption).getOrDefault(false)) {
			return lcOption.<DayCountFraction>map("getDayCountFraction", _lcOption -> _lcOption.getDayCountFraction()).get();
		}
		return null;
	}
	
	public Period choosePaymentFrequency(FacilityOptionsFeesAndRatesModelChoice facilityOptionsFeesAndRatesModelChoice) {
		final MapperS<FixedRateOption> fixedRateOption = MapperS.of(facilityOptionsFeesAndRatesModelChoice).<FixedRateOption>map("getFixedRateOption", _facilityOptionsFeesAndRatesModelChoice -> _facilityOptionsFeesAndRatesModelChoice.getFixedRateOption());
		if (exists(fixedRateOption).getOrDefault(false)) {
			return fixedRateOption.<Period>map("getPaymentFrequency", _fixedRateOption -> _fixedRateOption.getPaymentFrequency()).get();
		}
		final MapperS<FloatingRateOption> floatingRateOption = MapperS.of(facilityOptionsFeesAndRatesModelChoice).<FloatingRateOption>map("getFloatingRateOption", _facilityOptionsFeesAndRatesModelChoice -> _facilityOptionsFeesAndRatesModelChoice.getFloatingRateOption());
		if (exists(floatingRateOption).getOrDefault(false)) {
			return floatingRateOption.<Period>map("getPaymentFrequency", _floatingRateOption -> _floatingRateOption.getPaymentFrequency()).get();
		}
		final MapperS<LcOption> lcOption = MapperS.of(facilityOptionsFeesAndRatesModelChoice).<LcOption>map("getLcOption", _facilityOptionsFeesAndRatesModelChoice -> _facilityOptionsFeesAndRatesModelChoice.getLcOption());
		if (exists(lcOption).getOrDefault(false)) {
			return lcOption.<Period>map("getPaymentFrequency", _lcOption -> _lcOption.getPaymentFrequency()).get();
		}
		return null;
	}
	
	public PeriodModel choosePeriodModel(FacilityOptionsFeesAndRatesModelChoice facilityOptionsFeesAndRatesModelChoice) {
		final MapperS<FixedRateOption> fixedRateOption = MapperS.of(facilityOptionsFeesAndRatesModelChoice).<FixedRateOption>map("getFixedRateOption", _facilityOptionsFeesAndRatesModelChoice -> _facilityOptionsFeesAndRatesModelChoice.getFixedRateOption());
		if (exists(fixedRateOption).getOrDefault(false)) {
			return fixedRateOption.<PeriodModel>map("getPeriodModel", _fixedRateOption -> _fixedRateOption.getPeriodModel()).get();
		}
		final MapperS<FloatingRateOption> floatingRateOption = MapperS.of(facilityOptionsFeesAndRatesModelChoice).<FloatingRateOption>map("getFloatingRateOption", _facilityOptionsFeesAndRatesModelChoice -> _facilityOptionsFeesAndRatesModelChoice.getFloatingRateOption());
		if (exists(floatingRateOption).getOrDefault(false)) {
			return floatingRateOption.<PeriodModel>map("getPeriodModel", _floatingRateOption -> _floatingRateOption.getPeriodModel()).get();
		}
		final MapperS<LcOption> lcOption = MapperS.of(facilityOptionsFeesAndRatesModelChoice).<LcOption>map("getLcOption", _facilityOptionsFeesAndRatesModelChoice -> _facilityOptionsFeesAndRatesModelChoice.getLcOption());
		if (exists(lcOption).getOrDefault(false)) {
			return lcOption.<PeriodModel>map("getPeriodModel", _lcOption -> _lcOption.getPeriodModel()).get();
		}
		return null;
	}
	
}
