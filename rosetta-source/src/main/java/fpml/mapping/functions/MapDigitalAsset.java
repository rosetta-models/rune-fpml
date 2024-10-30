package fpml.mapping.functions;

import cdm.base.staticdata.asset.common.DigitalAsset;
import cdm.base.staticdata.asset.common.DigitalAsset.DigitalAssetBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDigitalAsset.MapDigitalAssetDefault.class)
public abstract class MapDigitalAsset implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetIdentifierList mapAssetIdentifierList;
	@Inject protected MapLegalEntity mapLegalEntity;
	@Inject protected MapLegalEntityList mapLegalEntityList;
	@Inject protected MapTaxonomyList mapTaxonomyList;

	/**
	* @param fpmlDataDocument 
	* @return digitalAsset 
	*/
	public DigitalAsset evaluate(DataDocument fpmlDataDocument) {
		DigitalAsset.DigitalAssetBuilder digitalAssetBuilder = doEvaluate(fpmlDataDocument);
		
		final DigitalAsset digitalAsset;
		if (digitalAssetBuilder == null) {
			digitalAsset = null;
		} else {
			digitalAsset = digitalAssetBuilder.build();
			objectValidator.validate(DigitalAsset.class, digitalAsset);
		}
		
		return digitalAsset;
	}

	protected abstract DigitalAsset.DigitalAssetBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapDigitalAssetDefault extends MapDigitalAsset {
		@Override
		protected DigitalAsset.DigitalAssetBuilder doEvaluate(DataDocument fpmlDataDocument) {
			DigitalAsset.DigitalAssetBuilder digitalAsset = DigitalAsset.builder();
			return assignOutput(digitalAsset, fpmlDataDocument);
		}
		
		protected DigitalAsset.DigitalAssetBuilder assignOutput(DigitalAsset.DigitalAssetBuilder digitalAsset, DataDocument fpmlDataDocument) {
			digitalAsset = toBuilder(DigitalAsset.builder()
				.setIdentifier(new ArrayList(mapAssetIdentifierList.evaluate(fpmlDataDocument)))
				.setTaxonomy(new ArrayList(mapTaxonomyList.evaluate(fpmlDataDocument)))
				.setIsExchangeListed(null)
				.setExchange(mapLegalEntity.evaluate(fpmlDataDocument))
				.setRelatedExchange(new ArrayList(mapLegalEntityList.evaluate(fpmlDataDocument)))
				.build());
			
			return Optional.ofNullable(digitalAsset)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
