package fpml.mapping.functions;

import cdm.product.asset.AssetDeliveryInformation;
import cdm.product.asset.AssetDeliveryInformation.AssetDeliveryInformationBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAssetDeliveryInformation.MapAssetDeliveryInformationDefault.class)
public abstract class MapAssetDeliveryInformation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetDeliveryPeriods mapAssetDeliveryPeriods;
	@Inject protected MapLocationIdentifierList mapLocationIdentifierList;
	@Inject protected MapQuantity mapQuantity;

	/**
	* @param fpmlDataDocument 
	* @return assetDeliveryInformation 
	*/
	public AssetDeliveryInformation evaluate(DataDocument fpmlDataDocument) {
		AssetDeliveryInformation.AssetDeliveryInformationBuilder assetDeliveryInformationBuilder = doEvaluate(fpmlDataDocument);
		
		final AssetDeliveryInformation assetDeliveryInformation;
		if (assetDeliveryInformationBuilder == null) {
			assetDeliveryInformation = null;
		} else {
			assetDeliveryInformation = assetDeliveryInformationBuilder.build();
			objectValidator.validate(AssetDeliveryInformation.class, assetDeliveryInformation);
		}
		
		return assetDeliveryInformation;
	}

	protected abstract AssetDeliveryInformation.AssetDeliveryInformationBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAssetDeliveryInformationDefault extends MapAssetDeliveryInformation {
		@Override
		protected AssetDeliveryInformation.AssetDeliveryInformationBuilder doEvaluate(DataDocument fpmlDataDocument) {
			AssetDeliveryInformation.AssetDeliveryInformationBuilder assetDeliveryInformation = AssetDeliveryInformation.builder();
			return assignOutput(assetDeliveryInformation, fpmlDataDocument);
		}
		
		protected AssetDeliveryInformation.AssetDeliveryInformationBuilder assignOutput(AssetDeliveryInformation.AssetDeliveryInformationBuilder assetDeliveryInformation, DataDocument fpmlDataDocument) {
			assetDeliveryInformation = toBuilder(AssetDeliveryInformation.builder()
				.setPeriods(mapAssetDeliveryPeriods.evaluate(fpmlDataDocument))
				.setLocation(new ArrayList(mapLocationIdentifierList.evaluate(fpmlDataDocument)))
				.setDeliveryCapacity(mapQuantity.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(assetDeliveryInformation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
