package fpml.mapping.functions;

import cdm.base.staticdata.asset.common.CommodityProductDefinition;
import cdm.base.staticdata.asset.common.CommodityProductDefinition.CommodityProductDefinitionBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCommodityProductDefinition.MapCommodityProductDefinitionDefault.class)
public abstract class MapCommodityProductDefinition implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCommodityReferenceFramework mapCommodityReferenceFramework;
	@Inject protected MapExchangeIdWithScheme mapExchangeIdWithScheme;
	@Inject protected MapPriceSource mapPriceSource;

	/**
	* @param fpmlDataDocument 
	* @return commodityProductDefinition 
	*/
	public CommodityProductDefinition evaluate(DataDocument fpmlDataDocument) {
		CommodityProductDefinition.CommodityProductDefinitionBuilder commodityProductDefinitionBuilder = doEvaluate(fpmlDataDocument);
		
		final CommodityProductDefinition commodityProductDefinition;
		if (commodityProductDefinitionBuilder == null) {
			commodityProductDefinition = null;
		} else {
			commodityProductDefinition = commodityProductDefinitionBuilder.build();
			objectValidator.validate(CommodityProductDefinition.class, commodityProductDefinition);
		}
		
		return commodityProductDefinition;
	}

	protected abstract CommodityProductDefinition.CommodityProductDefinitionBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCommodityProductDefinitionDefault extends MapCommodityProductDefinition {
		@Override
		protected CommodityProductDefinition.CommodityProductDefinitionBuilder doEvaluate(DataDocument fpmlDataDocument) {
			CommodityProductDefinition.CommodityProductDefinitionBuilder commodityProductDefinition = CommodityProductDefinition.builder();
			return assignOutput(commodityProductDefinition, fpmlDataDocument);
		}
		
		protected CommodityProductDefinition.CommodityProductDefinitionBuilder assignOutput(CommodityProductDefinition.CommodityProductDefinitionBuilder commodityProductDefinition, DataDocument fpmlDataDocument) {
			commodityProductDefinition = toBuilder(CommodityProductDefinition.builder()
				.setReferenceFramework(mapCommodityReferenceFramework.evaluate(fpmlDataDocument))
				.setPriceSource(mapPriceSource.evaluate(fpmlDataDocument))
				.setCommodityInfoPublisher(null)
				.setExchangeIdValue(mapExchangeIdWithScheme.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(commodityProductDefinition)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
