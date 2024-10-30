package fpml.mapping.functions;

import cdm.base.staticdata.asset.common.Commodity;
import cdm.base.staticdata.asset.common.Commodity.CommodityBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCommodity.MapCommodityDefault.class)
public abstract class MapCommodity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetIdentifierList mapAssetIdentifierList;
	@Inject protected MapCommodityProductDefinition mapCommodityProductDefinition;
	@Inject protected MapDeliveryDateParameters mapDeliveryDateParameters;
	@Inject protected MapLegalEntity mapLegalEntity;
	@Inject protected MapLegalEntityList mapLegalEntityList;
	@Inject protected MapTaxonomyList mapTaxonomyList;

	/**
	* @param fpmlDataDocument 
	* @return commodity 
	*/
	public Commodity evaluate(DataDocument fpmlDataDocument) {
		Commodity.CommodityBuilder commodityBuilder = doEvaluate(fpmlDataDocument);
		
		final Commodity commodity;
		if (commodityBuilder == null) {
			commodity = null;
		} else {
			commodity = commodityBuilder.build();
			objectValidator.validate(Commodity.class, commodity);
		}
		
		return commodity;
	}

	protected abstract Commodity.CommodityBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCommodityDefault extends MapCommodity {
		@Override
		protected Commodity.CommodityBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Commodity.CommodityBuilder commodity = Commodity.builder();
			return assignOutput(commodity, fpmlDataDocument);
		}
		
		protected Commodity.CommodityBuilder assignOutput(Commodity.CommodityBuilder commodity, DataDocument fpmlDataDocument) {
			commodity = toBuilder(Commodity.builder()
				.setIdentifier(new ArrayList(mapAssetIdentifierList.evaluate(fpmlDataDocument)))
				.setTaxonomy(new ArrayList(mapTaxonomyList.evaluate(fpmlDataDocument)))
				.setIsExchangeListed(null)
				.setExchange(mapLegalEntity.evaluate(fpmlDataDocument))
				.setRelatedExchange(new ArrayList(mapLegalEntityList.evaluate(fpmlDataDocument)))
				.setCommodityProductDefinition(mapCommodityProductDefinition.evaluate(fpmlDataDocument))
				.setPriceQuoteType(null)
				.setDeliveryDateReference(mapDeliveryDateParameters.evaluate(fpmlDataDocument))
				.setDescription(null)
				.build());
			
			return Optional.ofNullable(commodity)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
