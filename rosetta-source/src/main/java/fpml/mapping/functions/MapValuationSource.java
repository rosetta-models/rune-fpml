package fpml.mapping.functions;

import cdm.observable.asset.ValuationSource;
import cdm.observable.asset.ValuationSource.ValuationSourceBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapValuationSource.MapValuationSourceDefault.class)
public abstract class MapValuationSource implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAncillaryEntity mapAncillaryEntity;
	@Inject protected MapFxSpotRateSource mapFxSpotRateSource;
	@Inject protected MapQuotedCurrencyPair mapQuotedCurrencyPair;
	@Inject protected MapReferenceBanks mapReferenceBanks;
	@Inject protected MapSettlementRateOption mapSettlementRateOption;

	/**
	* @param fpmlDataDocument 
	* @return valuationSource 
	*/
	public ValuationSource evaluate(DataDocument fpmlDataDocument) {
		ValuationSource.ValuationSourceBuilder valuationSourceBuilder = doEvaluate(fpmlDataDocument);
		
		final ValuationSource valuationSource;
		if (valuationSourceBuilder == null) {
			valuationSource = null;
		} else {
			valuationSource = valuationSourceBuilder.build();
			objectValidator.validate(ValuationSource.class, valuationSource);
		}
		
		return valuationSource;
	}

	protected abstract ValuationSource.ValuationSourceBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapValuationSourceDefault extends MapValuationSource {
		@Override
		protected ValuationSource.ValuationSourceBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ValuationSource.ValuationSourceBuilder valuationSource = ValuationSource.builder();
			return assignOutput(valuationSource, fpmlDataDocument);
		}
		
		protected ValuationSource.ValuationSourceBuilder assignOutput(ValuationSource.ValuationSourceBuilder valuationSource, DataDocument fpmlDataDocument) {
			valuationSource = toBuilder(ValuationSource.builder()
				.setQuotedCurrencyPairValue(mapQuotedCurrencyPair.evaluate(fpmlDataDocument))
				.setInformationSource(mapFxSpotRateSource.evaluate(fpmlDataDocument))
				.setSettlementRateOption(mapSettlementRateOption.evaluate(fpmlDataDocument))
				.setReferenceBanks(mapReferenceBanks.evaluate(fpmlDataDocument))
				.setDealerOrCCP(mapAncillaryEntity.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(valuationSource)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
