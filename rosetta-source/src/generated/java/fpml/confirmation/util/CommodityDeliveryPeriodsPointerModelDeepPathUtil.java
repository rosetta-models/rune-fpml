package fpml.confirmation.util;

import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.CalculationPeriodsReference;
import fpml.confirmation.CalculationPeriodsScheduleReference;
import fpml.confirmation.CommodityDeliveryPeriodsPointerModel;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

public class CommodityDeliveryPeriodsPointerModelDeepPathUtil {
	public String chooseHref(CommodityDeliveryPeriodsPointerModel commodityDeliveryPeriodsPointerModel) {
		final MapperS<CalculationPeriodsReference> deliveryPeriodsReference = MapperS.of(commodityDeliveryPeriodsPointerModel).<CalculationPeriodsReference>map("getDeliveryPeriodsReference", _commodityDeliveryPeriodsPointerModel -> _commodityDeliveryPeriodsPointerModel.getDeliveryPeriodsReference());
		if (exists(deliveryPeriodsReference).getOrDefault(false)) {
			return deliveryPeriodsReference.<String>map("getHref", calculationPeriodsReference -> calculationPeriodsReference.getHref()).get();
		}
		final MapperS<CalculationPeriodsScheduleReference> deliveryPeriodsScheduleReference = MapperS.of(commodityDeliveryPeriodsPointerModel).<CalculationPeriodsScheduleReference>map("getDeliveryPeriodsScheduleReference", _commodityDeliveryPeriodsPointerModel -> _commodityDeliveryPeriodsPointerModel.getDeliveryPeriodsScheduleReference());
		if (exists(deliveryPeriodsScheduleReference).getOrDefault(false)) {
			return deliveryPeriodsScheduleReference.<String>map("getHref", calculationPeriodsScheduleReference -> calculationPeriodsScheduleReference.getHref()).get();
		}
		return null;
	}
	
}
