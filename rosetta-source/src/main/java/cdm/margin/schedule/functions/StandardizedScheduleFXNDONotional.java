package cdm.margin.schedule.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.OptionPayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(StandardizedScheduleFXNDONotional.StandardizedScheduleFXNDONotionalDefault.class)
public abstract class StandardizedScheduleFXNDONotional implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param optionPayout 
	* @return quantity 
	*/
	public NonNegativeQuantitySchedule evaluate(OptionPayout optionPayout) {
		NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder quantityBuilder = doEvaluate(optionPayout);
		
		final NonNegativeQuantitySchedule quantity;
		if (quantityBuilder == null) {
			quantity = null;
		} else {
			quantity = quantityBuilder.build();
			objectValidator.validate(NonNegativeQuantitySchedule.class, quantity);
		}
		
		return quantity;
	}

	protected abstract NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(OptionPayout optionPayout);

	public static class StandardizedScheduleFXNDONotionalDefault extends StandardizedScheduleFXNDONotional {
		@Override
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(OptionPayout optionPayout) {
			NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder quantity = NonNegativeQuantitySchedule.builder();
			return assignOutput(quantity, optionPayout);
		}
		
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder assignOutput(NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder quantity, OptionPayout optionPayout) {
			quantity = toBuilder(MapperS.of(optionPayout).<ResolvablePriceQuantity>map("getPriceQuantity", _optionPayout -> _optionPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("getValue", _f->_f.getValue()).get());
			
			return Optional.ofNullable(quantity)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
