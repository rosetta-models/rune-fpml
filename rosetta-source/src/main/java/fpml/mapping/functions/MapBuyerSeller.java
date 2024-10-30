package fpml.mapping.functions;

import cdm.base.staticdata.party.BuyerSeller;
import cdm.base.staticdata.party.BuyerSeller.BuyerSellerBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapBuyerSeller.MapBuyerSellerDefault.class)
public abstract class MapBuyerSeller implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return buyerSeller 
	*/
	public BuyerSeller evaluate(DataDocument fpmlDataDocument) {
		BuyerSeller.BuyerSellerBuilder buyerSellerBuilder = doEvaluate(fpmlDataDocument);
		
		final BuyerSeller buyerSeller;
		if (buyerSellerBuilder == null) {
			buyerSeller = null;
		} else {
			buyerSeller = buyerSellerBuilder.build();
			objectValidator.validate(BuyerSeller.class, buyerSeller);
		}
		
		return buyerSeller;
	}

	protected abstract BuyerSeller.BuyerSellerBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapBuyerSellerDefault extends MapBuyerSeller {
		@Override
		protected BuyerSeller.BuyerSellerBuilder doEvaluate(DataDocument fpmlDataDocument) {
			BuyerSeller.BuyerSellerBuilder buyerSeller = BuyerSeller.builder();
			return assignOutput(buyerSeller, fpmlDataDocument);
		}
		
		protected BuyerSeller.BuyerSellerBuilder assignOutput(BuyerSeller.BuyerSellerBuilder buyerSeller, DataDocument fpmlDataDocument) {
			buyerSeller = toBuilder(BuyerSeller.builder()
				.setBuyer(null)
				.setSeller(null)
				.build());
			
			return Optional.ofNullable(buyerSeller)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
