package fpml.mapping.functions;

import cdm.product.asset.ReferencePair;
import cdm.product.asset.ReferencePair.ReferencePairBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapReferencePair.MapReferencePairDefault.class)
public abstract class MapReferencePair implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapEntityTypeWithScheme mapEntityTypeWithScheme;
	@Inject protected MapLegalEntity mapLegalEntity;
	@Inject protected MapReferenceObligation mapReferenceObligation;

	/**
	* @param fpmlDataDocument 
	* @return referencePair 
	*/
	public ReferencePair evaluate(DataDocument fpmlDataDocument) {
		ReferencePair.ReferencePairBuilder referencePairBuilder = doEvaluate(fpmlDataDocument);
		
		final ReferencePair referencePair;
		if (referencePairBuilder == null) {
			referencePair = null;
		} else {
			referencePair = referencePairBuilder.build();
			objectValidator.validate(ReferencePair.class, referencePair);
		}
		
		return referencePair;
	}

	protected abstract ReferencePair.ReferencePairBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapReferencePairDefault extends MapReferencePair {
		@Override
		protected ReferencePair.ReferencePairBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ReferencePair.ReferencePairBuilder referencePair = ReferencePair.builder();
			return assignOutput(referencePair, fpmlDataDocument);
		}
		
		protected ReferencePair.ReferencePairBuilder assignOutput(ReferencePair.ReferencePairBuilder referencePair, DataDocument fpmlDataDocument) {
			referencePair = toBuilder(ReferencePair.builder()
				.setReferenceEntity(mapLegalEntity.evaluate(fpmlDataDocument))
				.setReferenceObligation(mapReferenceObligation.evaluate(fpmlDataDocument))
				.setNoReferenceObligation(null)
				.setEntityTypeValue(mapEntityTypeWithScheme.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(referencePair)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
