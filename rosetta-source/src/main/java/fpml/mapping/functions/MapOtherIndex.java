package fpml.mapping.functions;

import cdm.observable.asset.OtherIndex;
import cdm.observable.asset.OtherIndex.OtherIndexBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapOtherIndex.MapOtherIndexDefault.class)
public abstract class MapOtherIndex implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetIdentifierList mapAssetIdentifierList;
	@Inject protected MapLegalEntity mapLegalEntity;
	@Inject protected MapLegalEntityList mapLegalEntityList;
	@Inject protected MapNameWithScheme mapNameWithScheme;
	@Inject protected MapTaxonomyList mapTaxonomyList;

	/**
	* @param fpmlDataDocument 
	* @return otherIndex 
	*/
	public OtherIndex evaluate(DataDocument fpmlDataDocument) {
		OtherIndex.OtherIndexBuilder otherIndexBuilder = doEvaluate(fpmlDataDocument);
		
		final OtherIndex otherIndex;
		if (otherIndexBuilder == null) {
			otherIndex = null;
		} else {
			otherIndex = otherIndexBuilder.build();
			objectValidator.validate(OtherIndex.class, otherIndex);
		}
		
		return otherIndex;
	}

	protected abstract OtherIndex.OtherIndexBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapOtherIndexDefault extends MapOtherIndex {
		@Override
		protected OtherIndex.OtherIndexBuilder doEvaluate(DataDocument fpmlDataDocument) {
			OtherIndex.OtherIndexBuilder otherIndex = OtherIndex.builder();
			return assignOutput(otherIndex, fpmlDataDocument);
		}
		
		protected OtherIndex.OtherIndexBuilder assignOutput(OtherIndex.OtherIndexBuilder otherIndex, DataDocument fpmlDataDocument) {
			otherIndex = toBuilder(OtherIndex.builder()
				.setIdentifier(new ArrayList(mapAssetIdentifierList.evaluate(fpmlDataDocument)))
				.setTaxonomy(new ArrayList(mapTaxonomyList.evaluate(fpmlDataDocument)))
				.setIsExchangeListed(null)
				.setExchange(mapLegalEntity.evaluate(fpmlDataDocument))
				.setRelatedExchange(new ArrayList(mapLegalEntityList.evaluate(fpmlDataDocument)))
				.setNameValue(mapNameWithScheme.evaluate(fpmlDataDocument))
				.setProvider(mapLegalEntity.evaluate(fpmlDataDocument))
				.setAssetClass(null)
				.setDescription(null)
				.build());
			
			return Optional.ofNullable(otherIndex)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
