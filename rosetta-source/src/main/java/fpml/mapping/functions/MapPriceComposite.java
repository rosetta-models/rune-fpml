package fpml.mapping.functions;

import cdm.observable.asset.PriceComposite;
import cdm.observable.asset.PriceComposite.PriceCompositeBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPriceComposite.MapPriceCompositeDefault.class)
public abstract class MapPriceComposite implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return priceComposite 
	*/
	public PriceComposite evaluate(DataDocument fpmlDataDocument) {
		PriceComposite.PriceCompositeBuilder priceCompositeBuilder = doEvaluate(fpmlDataDocument);
		
		final PriceComposite priceComposite;
		if (priceCompositeBuilder == null) {
			priceComposite = null;
		} else {
			priceComposite = priceCompositeBuilder.build();
			objectValidator.validate(PriceComposite.class, priceComposite);
		}
		
		return priceComposite;
	}

	protected abstract PriceComposite.PriceCompositeBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPriceCompositeDefault extends MapPriceComposite {
		@Override
		protected PriceComposite.PriceCompositeBuilder doEvaluate(DataDocument fpmlDataDocument) {
			PriceComposite.PriceCompositeBuilder priceComposite = PriceComposite.builder();
			return assignOutput(priceComposite, fpmlDataDocument);
		}
		
		protected PriceComposite.PriceCompositeBuilder assignOutput(PriceComposite.PriceCompositeBuilder priceComposite, DataDocument fpmlDataDocument) {
			priceComposite = toBuilder(PriceComposite.builder()
				.setBaseValue(null)
				.setOperand(null)
				.setArithmeticOperator(null)
				.setOperandType(null)
				.build());
			
			return Optional.ofNullable(priceComposite)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
