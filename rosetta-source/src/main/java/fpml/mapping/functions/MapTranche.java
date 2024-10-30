package fpml.mapping.functions;

import cdm.product.asset.Tranche;
import cdm.product.asset.Tranche.TrancheBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapTranche.MapTrancheDefault.class)
public abstract class MapTranche implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return tranche 
	*/
	public Tranche evaluate(DataDocument fpmlDataDocument) {
		Tranche.TrancheBuilder trancheBuilder = doEvaluate(fpmlDataDocument);
		
		final Tranche tranche;
		if (trancheBuilder == null) {
			tranche = null;
		} else {
			tranche = trancheBuilder.build();
			objectValidator.validate(Tranche.class, tranche);
		}
		
		return tranche;
	}

	protected abstract Tranche.TrancheBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapTrancheDefault extends MapTranche {
		@Override
		protected Tranche.TrancheBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Tranche.TrancheBuilder tranche = Tranche.builder();
			return assignOutput(tranche, fpmlDataDocument);
		}
		
		protected Tranche.TrancheBuilder assignOutput(Tranche.TrancheBuilder tranche, DataDocument fpmlDataDocument) {
			tranche = toBuilder(Tranche.builder()
				.setAttachmentPoint(null)
				.setExhaustionPoint(null)
				.setIncurredRecoveryApplicable(null)
				.build());
			
			return Optional.ofNullable(tranche)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
