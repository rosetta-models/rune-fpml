package fpml.mapping.functions;

import cdm.observable.asset.TransactedPrice;
import cdm.observable.asset.TransactedPrice.TransactedPriceBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapTransactedPrice.MapTransactedPriceDefault.class)
public abstract class MapTransactedPrice implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return transactedPrice 
	*/
	public TransactedPrice evaluate(DataDocument fpmlDataDocument) {
		TransactedPrice.TransactedPriceBuilder transactedPriceBuilder = doEvaluate(fpmlDataDocument);
		
		final TransactedPrice transactedPrice;
		if (transactedPriceBuilder == null) {
			transactedPrice = null;
		} else {
			transactedPrice = transactedPriceBuilder.build();
			objectValidator.validate(TransactedPrice.class, transactedPrice);
		}
		
		return transactedPrice;
	}

	protected abstract TransactedPrice.TransactedPriceBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapTransactedPriceDefault extends MapTransactedPrice {
		@Override
		protected TransactedPrice.TransactedPriceBuilder doEvaluate(DataDocument fpmlDataDocument) {
			TransactedPrice.TransactedPriceBuilder transactedPrice = TransactedPrice.builder();
			return assignOutput(transactedPrice, fpmlDataDocument);
		}
		
		protected TransactedPrice.TransactedPriceBuilder assignOutput(TransactedPrice.TransactedPriceBuilder transactedPrice, DataDocument fpmlDataDocument) {
			transactedPrice = toBuilder(TransactedPrice.builder()
				.setMarketFixedRate(null)
				.setInitialPoints(null)
				.setMarketPrice(null)
				.setQuotationStyle(null)
				.build());
			
			return Optional.ofNullable(transactedPrice)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
