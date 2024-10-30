package fpml.mapping.functions;

import cdm.product.common.settlement.CommodityPriceReturnTerms;
import cdm.product.common.settlement.CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCommodityPriceReturnTerms.MapCommodityPriceReturnTermsDefault.class)
public abstract class MapCommodityPriceReturnTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapRollFeature mapRollFeature;
	@Inject protected MapRounding mapRounding;
	@Inject protected MapSpreadSchedule mapSpreadSchedule;

	/**
	* @param fpmlDataDocument 
	* @return commodityPriceReturnTerms 
	*/
	public CommodityPriceReturnTerms evaluate(DataDocument fpmlDataDocument) {
		CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder commodityPriceReturnTermsBuilder = doEvaluate(fpmlDataDocument);
		
		final CommodityPriceReturnTerms commodityPriceReturnTerms;
		if (commodityPriceReturnTermsBuilder == null) {
			commodityPriceReturnTerms = null;
		} else {
			commodityPriceReturnTerms = commodityPriceReturnTermsBuilder.build();
			objectValidator.validate(CommodityPriceReturnTerms.class, commodityPriceReturnTerms);
		}
		
		return commodityPriceReturnTerms;
	}

	protected abstract CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCommodityPriceReturnTermsDefault extends MapCommodityPriceReturnTerms {
		@Override
		protected CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder commodityPriceReturnTerms = CommodityPriceReturnTerms.builder();
			return assignOutput(commodityPriceReturnTerms, fpmlDataDocument);
		}
		
		protected CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder assignOutput(CommodityPriceReturnTerms.CommodityPriceReturnTermsBuilder commodityPriceReturnTerms, DataDocument fpmlDataDocument) {
			commodityPriceReturnTerms = toBuilder(CommodityPriceReturnTerms.builder()
				.setRounding(mapRounding.evaluate(fpmlDataDocument))
				.setSpread(mapSpreadSchedule.evaluate(fpmlDataDocument))
				.setRollFeature(mapRollFeature.evaluate(fpmlDataDocument))
				.setConversionFactor(null)
				.build());
			
			return Optional.ofNullable(commodityPriceReturnTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
