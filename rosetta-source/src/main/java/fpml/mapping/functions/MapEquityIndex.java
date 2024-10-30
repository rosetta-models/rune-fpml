package fpml.mapping.functions;

import cdm.observable.asset.EquityIndex;
import cdm.observable.asset.EquityIndex.EquityIndexBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapEquityIndex.MapEquityIndexDefault.class)
public abstract class MapEquityIndex implements RosettaFunction {
	
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
	* @return equityIndex 
	*/
	public EquityIndex evaluate(DataDocument fpmlDataDocument) {
		EquityIndex.EquityIndexBuilder equityIndexBuilder = doEvaluate(fpmlDataDocument);
		
		final EquityIndex equityIndex;
		if (equityIndexBuilder == null) {
			equityIndex = null;
		} else {
			equityIndex = equityIndexBuilder.build();
			objectValidator.validate(EquityIndex.class, equityIndex);
		}
		
		return equityIndex;
	}

	protected abstract EquityIndex.EquityIndexBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapEquityIndexDefault extends MapEquityIndex {
		@Override
		protected EquityIndex.EquityIndexBuilder doEvaluate(DataDocument fpmlDataDocument) {
			EquityIndex.EquityIndexBuilder equityIndex = EquityIndex.builder();
			return assignOutput(equityIndex, fpmlDataDocument);
		}
		
		protected EquityIndex.EquityIndexBuilder assignOutput(EquityIndex.EquityIndexBuilder equityIndex, DataDocument fpmlDataDocument) {
			equityIndex = toBuilder(EquityIndex.builder()
				.setIdentifier(new ArrayList(mapAssetIdentifierList.evaluate(fpmlDataDocument)))
				.setTaxonomy(new ArrayList(mapTaxonomyList.evaluate(fpmlDataDocument)))
				.setIsExchangeListed(null)
				.setExchange(mapLegalEntity.evaluate(fpmlDataDocument))
				.setRelatedExchange(new ArrayList(mapLegalEntityList.evaluate(fpmlDataDocument)))
				.setNameValue(mapNameWithScheme.evaluate(fpmlDataDocument))
				.setProvider(mapLegalEntity.evaluate(fpmlDataDocument))
				.setAssetClass(null)
				.build());
			
			return Optional.ofNullable(equityIndex)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
