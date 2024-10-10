package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.CalculationPeriodsDatesReference;
import fpml.confirmation.CalculationPeriodsReference;
import fpml.confirmation.CalculationPeriodsScheduleReference;
import fpml.confirmation.CommodityCalculationPeriodsPointerModel;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class CommodityCalculationPeriodsPointerModelDeepPathUtil {
	public String chooseHref(CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel) {
		final MapperS<CalculationPeriodsReference> calculationPeriodsReference = MapperS.of(commodityCalculationPeriodsPointerModel).<CalculationPeriodsReference>map("getCalculationPeriodsReference", _commodityCalculationPeriodsPointerModel -> _commodityCalculationPeriodsPointerModel.getCalculationPeriodsReference());
		if (exists(calculationPeriodsReference).getOrDefault(false)) {
			return calculationPeriodsReference.<String>map("getHref", _calculationPeriodsReference -> _calculationPeriodsReference.getHref()).get();
		}
		final MapperS<CalculationPeriodsScheduleReference> calculationPeriodsScheduleReference = MapperS.of(commodityCalculationPeriodsPointerModel).<CalculationPeriodsScheduleReference>map("getCalculationPeriodsScheduleReference", _commodityCalculationPeriodsPointerModel -> _commodityCalculationPeriodsPointerModel.getCalculationPeriodsScheduleReference());
		if (exists(calculationPeriodsScheduleReference).getOrDefault(false)) {
			return calculationPeriodsScheduleReference.<String>map("getHref", _calculationPeriodsScheduleReference -> _calculationPeriodsScheduleReference.getHref()).get();
		}
		final MapperS<CalculationPeriodsDatesReference> calculationPeriodsDatesReference = MapperS.of(commodityCalculationPeriodsPointerModel).<CalculationPeriodsDatesReference>map("getCalculationPeriodsDatesReference", _commodityCalculationPeriodsPointerModel -> _commodityCalculationPeriodsPointerModel.getCalculationPeriodsDatesReference());
		if (exists(calculationPeriodsDatesReference).getOrDefault(false)) {
			return calculationPeriodsDatesReference.<String>map("getHref", _calculationPeriodsDatesReference -> _calculationPeriodsDatesReference.getHref()).get();
		}
		return null;
	}
	
}
