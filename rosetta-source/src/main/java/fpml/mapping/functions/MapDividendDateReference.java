package fpml.mapping.functions;

import cdm.product.asset.DividendDateReference;
import cdm.product.asset.DividendDateReference.DividendDateReferenceBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDividendDateReference.MapDividendDateReferenceDefault.class)
public abstract class MapDividendDateReference implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapOffset mapOffset;

	/**
	* @param fpmlDataDocument 
	* @return dividendDateReference 
	*/
	public DividendDateReference evaluate(DataDocument fpmlDataDocument) {
		DividendDateReference.DividendDateReferenceBuilder dividendDateReferenceBuilder = doEvaluate(fpmlDataDocument);
		
		final DividendDateReference dividendDateReference;
		if (dividendDateReferenceBuilder == null) {
			dividendDateReference = null;
		} else {
			dividendDateReference = dividendDateReferenceBuilder.build();
			objectValidator.validate(DividendDateReference.class, dividendDateReference);
		}
		
		return dividendDateReference;
	}

	protected abstract DividendDateReference.DividendDateReferenceBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapDividendDateReferenceDefault extends MapDividendDateReference {
		@Override
		protected DividendDateReference.DividendDateReferenceBuilder doEvaluate(DataDocument fpmlDataDocument) {
			DividendDateReference.DividendDateReferenceBuilder dividendDateReference = DividendDateReference.builder();
			return assignOutput(dividendDateReference, fpmlDataDocument);
		}
		
		protected DividendDateReference.DividendDateReferenceBuilder assignOutput(DividendDateReference.DividendDateReferenceBuilder dividendDateReference, DataDocument fpmlDataDocument) {
			dividendDateReference = toBuilder(DividendDateReference.builder()
				.setDateReference(null)
				.setPaymentDateOffset(mapOffset.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(dividendDateReference)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
