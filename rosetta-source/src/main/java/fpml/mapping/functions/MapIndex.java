package fpml.mapping.functions;

import cdm.observable.asset.Index;
import cdm.observable.asset.Index.IndexBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapIndex.MapIndexDefault.class)
public abstract class MapIndex implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCreditIndex mapCreditIndex;
	@Inject protected MapEquityIndex mapEquityIndex;
	@Inject protected MapFloatingRateIndex mapFloatingRateIndex;
	@Inject protected MapForeignExchangeRateIndex mapForeignExchangeRateIndex;
	@Inject protected MapOtherIndex mapOtherIndex;

	/**
	* @param fpmlDataDocument 
	* @return index 
	*/
	public Index evaluate(DataDocument fpmlDataDocument) {
		Index.IndexBuilder indexBuilder = doEvaluate(fpmlDataDocument);
		
		final Index index;
		if (indexBuilder == null) {
			index = null;
		} else {
			index = indexBuilder.build();
			objectValidator.validate(Index.class, index);
		}
		
		return index;
	}

	protected abstract Index.IndexBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapIndexDefault extends MapIndex {
		@Override
		protected Index.IndexBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Index.IndexBuilder index = Index.builder();
			return assignOutput(index, fpmlDataDocument);
		}
		
		protected Index.IndexBuilder assignOutput(Index.IndexBuilder index, DataDocument fpmlDataDocument) {
			index = toBuilder(Index.builder()
				.setCreditIndex(mapCreditIndex.evaluate(fpmlDataDocument))
				.setEquityIndex(mapEquityIndex.evaluate(fpmlDataDocument))
				.setFloatingRateIndexValue(mapFloatingRateIndex.evaluate(fpmlDataDocument))
				.setForeignExchangeRateIndex(mapForeignExchangeRateIndex.evaluate(fpmlDataDocument))
				.setOtherIndex(mapOtherIndex.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(index)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
