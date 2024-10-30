package fpml.mapping.functions;

import cdm.observable.asset.InflationIndex;
import cdm.observable.asset.InflationIndex.InflationIndexBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapInflationIndex.MapInflationIndexDefault.class)
public abstract class MapInflationIndex implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetIdentifierList mapAssetIdentifierList;
	@Inject protected MapInflationRateIndexWithScheme mapInflationRateIndexWithScheme;
	@Inject protected MapLegalEntity mapLegalEntity;
	@Inject protected MapLegalEntityList mapLegalEntityList;
	@Inject protected MapNameWithScheme mapNameWithScheme;
	@Inject protected MapPeriod mapPeriod;
	@Inject protected MapTaxonomyList mapTaxonomyList;

	/**
	* @param fpmlDataDocument 
	* @return inflationIndex 
	*/
	public InflationIndex evaluate(DataDocument fpmlDataDocument) {
		InflationIndex.InflationIndexBuilder inflationIndexBuilder = doEvaluate(fpmlDataDocument);
		
		final InflationIndex inflationIndex;
		if (inflationIndexBuilder == null) {
			inflationIndex = null;
		} else {
			inflationIndex = inflationIndexBuilder.build();
			objectValidator.validate(InflationIndex.class, inflationIndex);
		}
		
		return inflationIndex;
	}

	protected abstract InflationIndex.InflationIndexBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapInflationIndexDefault extends MapInflationIndex {
		@Override
		protected InflationIndex.InflationIndexBuilder doEvaluate(DataDocument fpmlDataDocument) {
			InflationIndex.InflationIndexBuilder inflationIndex = InflationIndex.builder();
			return assignOutput(inflationIndex, fpmlDataDocument);
		}
		
		protected InflationIndex.InflationIndexBuilder assignOutput(InflationIndex.InflationIndexBuilder inflationIndex, DataDocument fpmlDataDocument) {
			inflationIndex = toBuilder(InflationIndex.builder()
				.setIdentifier(new ArrayList(mapAssetIdentifierList.evaluate(fpmlDataDocument)))
				.setTaxonomy(new ArrayList(mapTaxonomyList.evaluate(fpmlDataDocument)))
				.setIsExchangeListed(null)
				.setExchange(mapLegalEntity.evaluate(fpmlDataDocument))
				.setRelatedExchange(new ArrayList(mapLegalEntityList.evaluate(fpmlDataDocument)))
				.setNameValue(mapNameWithScheme.evaluate(fpmlDataDocument))
				.setProvider(mapLegalEntity.evaluate(fpmlDataDocument))
				.setAssetClass(null)
				.setInflationRateIndexValue(mapInflationRateIndexWithScheme.evaluate(fpmlDataDocument))
				.setIndexTenor(mapPeriod.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(inflationIndex)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
