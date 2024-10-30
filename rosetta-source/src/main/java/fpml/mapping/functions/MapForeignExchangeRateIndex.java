package fpml.mapping.functions;

import cdm.observable.asset.ForeignExchangeRateIndex;
import cdm.observable.asset.ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapForeignExchangeRateIndex.MapForeignExchangeRateIndexDefault.class)
public abstract class MapForeignExchangeRateIndex implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetIdentifierList mapAssetIdentifierList;
	@Inject protected MapInformationSource mapInformationSource;
	@Inject protected MapLegalEntity mapLegalEntity;
	@Inject protected MapLegalEntityList mapLegalEntityList;
	@Inject protected MapNameWithScheme mapNameWithScheme;
	@Inject protected MapQuotedCurrencyPair mapQuotedCurrencyPair;
	@Inject protected MapTaxonomyList mapTaxonomyList;

	/**
	* @param fpmlDataDocument 
	* @return foreignExchangeRateIndex 
	*/
	public ForeignExchangeRateIndex evaluate(DataDocument fpmlDataDocument) {
		ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder foreignExchangeRateIndexBuilder = doEvaluate(fpmlDataDocument);
		
		final ForeignExchangeRateIndex foreignExchangeRateIndex;
		if (foreignExchangeRateIndexBuilder == null) {
			foreignExchangeRateIndex = null;
		} else {
			foreignExchangeRateIndex = foreignExchangeRateIndexBuilder.build();
			objectValidator.validate(ForeignExchangeRateIndex.class, foreignExchangeRateIndex);
		}
		
		return foreignExchangeRateIndex;
	}

	protected abstract ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapForeignExchangeRateIndexDefault extends MapForeignExchangeRateIndex {
		@Override
		protected ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder foreignExchangeRateIndex = ForeignExchangeRateIndex.builder();
			return assignOutput(foreignExchangeRateIndex, fpmlDataDocument);
		}
		
		protected ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder assignOutput(ForeignExchangeRateIndex.ForeignExchangeRateIndexBuilder foreignExchangeRateIndex, DataDocument fpmlDataDocument) {
			foreignExchangeRateIndex = toBuilder(ForeignExchangeRateIndex.builder()
				.setIdentifier(new ArrayList(mapAssetIdentifierList.evaluate(fpmlDataDocument)))
				.setTaxonomy(new ArrayList(mapTaxonomyList.evaluate(fpmlDataDocument)))
				.setIsExchangeListed(null)
				.setExchange(mapLegalEntity.evaluate(fpmlDataDocument))
				.setRelatedExchange(new ArrayList(mapLegalEntityList.evaluate(fpmlDataDocument)))
				.setNameValue(mapNameWithScheme.evaluate(fpmlDataDocument))
				.setProvider(mapLegalEntity.evaluate(fpmlDataDocument))
				.setAssetClass(null)
				.setQuotedCurrencyPairValue(mapQuotedCurrencyPair.evaluate(fpmlDataDocument))
				.setPrimaryFxSpotRateSource(mapInformationSource.evaluate(fpmlDataDocument))
				.setSecondaryFxSpotRateSource(mapInformationSource.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(foreignExchangeRateIndex)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
