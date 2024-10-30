package fpml.mapping.functions;

import cdm.base.staticdata.asset.common.CommodityReferenceFramework;
import cdm.base.staticdata.asset.common.CommodityReferenceFramework.CommodityReferenceFrameworkBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCommodityReferenceFramework.MapCommodityReferenceFrameworkDefault.class)
public abstract class MapCommodityReferenceFramework implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCurrencyWithScheme mapCurrencyWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return commodityReferenceFramework 
	*/
	public CommodityReferenceFramework evaluate(DataDocument fpmlDataDocument) {
		CommodityReferenceFramework.CommodityReferenceFrameworkBuilder commodityReferenceFrameworkBuilder = doEvaluate(fpmlDataDocument);
		
		final CommodityReferenceFramework commodityReferenceFramework;
		if (commodityReferenceFrameworkBuilder == null) {
			commodityReferenceFramework = null;
		} else {
			commodityReferenceFramework = commodityReferenceFrameworkBuilder.build();
			objectValidator.validate(CommodityReferenceFramework.class, commodityReferenceFramework);
		}
		
		return commodityReferenceFramework;
	}

	protected abstract CommodityReferenceFramework.CommodityReferenceFrameworkBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCommodityReferenceFrameworkDefault extends MapCommodityReferenceFramework {
		@Override
		protected CommodityReferenceFramework.CommodityReferenceFrameworkBuilder doEvaluate(DataDocument fpmlDataDocument) {
			CommodityReferenceFramework.CommodityReferenceFrameworkBuilder commodityReferenceFramework = CommodityReferenceFramework.builder();
			return assignOutput(commodityReferenceFramework, fpmlDataDocument);
		}
		
		protected CommodityReferenceFramework.CommodityReferenceFrameworkBuilder assignOutput(CommodityReferenceFramework.CommodityReferenceFrameworkBuilder commodityReferenceFramework, DataDocument fpmlDataDocument) {
			commodityReferenceFramework = toBuilder(CommodityReferenceFramework.builder()
				.setCommodityName(null)
				.setCapacityUnit(null)
				.setWeatherUnit(null)
				.setCurrencyValue(mapCurrencyWithScheme.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(commodityReferenceFramework)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
