package cdm.margin.schedule.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.SettlementPayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(StandardizedScheduleFXNDFNotional.StandardizedScheduleFXNDFNotionalDefault.class)
public abstract class StandardizedScheduleFXNDFNotional implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param settlementPayout 
	* @return quantity 
	*/
	public NonNegativeQuantitySchedule evaluate(SettlementPayout settlementPayout) {
		NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder quantityBuilder = doEvaluate(settlementPayout);
		
		final NonNegativeQuantitySchedule quantity;
		if (quantityBuilder == null) {
			quantity = null;
		} else {
			quantity = quantityBuilder.build();
			objectValidator.validate(NonNegativeQuantitySchedule.class, quantity);
		}
		
		return quantity;
	}

	protected abstract NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(SettlementPayout settlementPayout);

	public static class StandardizedScheduleFXNDFNotionalDefault extends StandardizedScheduleFXNDFNotional {
		@Override
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(SettlementPayout settlementPayout) {
			NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder quantity = NonNegativeQuantitySchedule.builder();
			return assignOutput(quantity, settlementPayout);
		}
		
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder assignOutput(NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder quantity, SettlementPayout settlementPayout) {
			quantity = toBuilder(MapperS.of(settlementPayout).<ResolvablePriceQuantity>map("getPriceQuantity", _settlementPayout -> _settlementPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("getValue", _f->_f.getValue()).get());
			
			return Optional.ofNullable(quantity)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
