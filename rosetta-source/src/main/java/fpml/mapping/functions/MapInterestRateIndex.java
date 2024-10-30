package fpml.mapping.functions;

import cdm.observable.asset.InterestRateIndex;
import cdm.observable.asset.InterestRateIndex.InterestRateIndexBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapInterestRateIndex.MapInterestRateIndexDefault.class)
public abstract class MapInterestRateIndex implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetIdentifierList mapAssetIdentifierList;
	@Inject protected MapFloatingRateIndexWithScheme mapFloatingRateIndexWithScheme;
	@Inject protected MapLegalEntity mapLegalEntity;
	@Inject protected MapLegalEntityList mapLegalEntityList;
	@Inject protected MapNameWithScheme mapNameWithScheme;
	@Inject protected MapPeriod mapPeriod;
	@Inject protected MapTaxonomyList mapTaxonomyList;

	/**
	* @param fpmlDataDocument 
	* @return interestRateIndex 
	*/
	public InterestRateIndex evaluate(DataDocument fpmlDataDocument) {
		InterestRateIndex.InterestRateIndexBuilder interestRateIndexBuilder = doEvaluate(fpmlDataDocument);
		
		final InterestRateIndex interestRateIndex;
		if (interestRateIndexBuilder == null) {
			interestRateIndex = null;
		} else {
			interestRateIndex = interestRateIndexBuilder.build();
			objectValidator.validate(InterestRateIndex.class, interestRateIndex);
		}
		
		return interestRateIndex;
	}

	protected abstract InterestRateIndex.InterestRateIndexBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapInterestRateIndexDefault extends MapInterestRateIndex {
		@Override
		protected InterestRateIndex.InterestRateIndexBuilder doEvaluate(DataDocument fpmlDataDocument) {
			InterestRateIndex.InterestRateIndexBuilder interestRateIndex = InterestRateIndex.builder();
			return assignOutput(interestRateIndex, fpmlDataDocument);
		}
		
		protected InterestRateIndex.InterestRateIndexBuilder assignOutput(InterestRateIndex.InterestRateIndexBuilder interestRateIndex, DataDocument fpmlDataDocument) {
			interestRateIndex = toBuilder(InterestRateIndex.builder()
				.setIdentifier(new ArrayList(mapAssetIdentifierList.evaluate(fpmlDataDocument)))
				.setTaxonomy(new ArrayList(mapTaxonomyList.evaluate(fpmlDataDocument)))
				.setIsExchangeListed(null)
				.setExchange(mapLegalEntity.evaluate(fpmlDataDocument))
				.setRelatedExchange(new ArrayList(mapLegalEntityList.evaluate(fpmlDataDocument)))
				.setNameValue(mapNameWithScheme.evaluate(fpmlDataDocument))
				.setProvider(mapLegalEntity.evaluate(fpmlDataDocument))
				.setAssetClass(null)
				.setFloatingRateIndexValue(mapFloatingRateIndexWithScheme.evaluate(fpmlDataDocument))
				.setIndexTenor(mapPeriod.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(interestRateIndex)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
