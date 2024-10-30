package fpml.mapping.functions;

import cdm.product.asset.AssetDeliveryPeriods;
import cdm.product.asset.AssetDeliveryPeriods.AssetDeliveryPeriodsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAssetDeliveryPeriods.MapAssetDeliveryPeriodsDefault.class)
public abstract class MapAssetDeliveryPeriods implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetDeliveryProfileList mapAssetDeliveryProfileList;

	/**
	* @param fpmlDataDocument 
	* @return assetDeliveryPeriods 
	*/
	public AssetDeliveryPeriods evaluate(DataDocument fpmlDataDocument) {
		AssetDeliveryPeriods.AssetDeliveryPeriodsBuilder assetDeliveryPeriodsBuilder = doEvaluate(fpmlDataDocument);
		
		final AssetDeliveryPeriods assetDeliveryPeriods;
		if (assetDeliveryPeriodsBuilder == null) {
			assetDeliveryPeriods = null;
		} else {
			assetDeliveryPeriods = assetDeliveryPeriodsBuilder.build();
			objectValidator.validate(AssetDeliveryPeriods.class, assetDeliveryPeriods);
		}
		
		return assetDeliveryPeriods;
	}

	protected abstract AssetDeliveryPeriods.AssetDeliveryPeriodsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAssetDeliveryPeriodsDefault extends MapAssetDeliveryPeriods {
		@Override
		protected AssetDeliveryPeriods.AssetDeliveryPeriodsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			AssetDeliveryPeriods.AssetDeliveryPeriodsBuilder assetDeliveryPeriods = AssetDeliveryPeriods.builder();
			return assignOutput(assetDeliveryPeriods, fpmlDataDocument);
		}
		
		protected AssetDeliveryPeriods.AssetDeliveryPeriodsBuilder assignOutput(AssetDeliveryPeriods.AssetDeliveryPeriodsBuilder assetDeliveryPeriods, DataDocument fpmlDataDocument) {
			assetDeliveryPeriods = toBuilder(AssetDeliveryPeriods.builder()
				.setProfile(new ArrayList(mapAssetDeliveryProfileList.evaluate(fpmlDataDocument)))
				.setStartDate(null)
				.setEndDate(null)
				.build());
			
			return Optional.ofNullable(assetDeliveryPeriods)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
