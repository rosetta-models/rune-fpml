package fpml.mapping.functions;

import cdm.product.asset.EquityUnderlierProvisions;
import cdm.product.asset.EquityUnderlierProvisions.EquityUnderlierProvisionsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapEquityUnderlierProvisions.MapEquityUnderlierProvisionsDefault.class)
public abstract class MapEquityUnderlierProvisions implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapLocalJurisdictionWithScheme mapLocalJurisdictionWithScheme;
	@Inject protected MapRelevantJurisdictionWithScheme mapRelevantJurisdictionWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return equityUnderlierProvisions 
	*/
	public EquityUnderlierProvisions evaluate(DataDocument fpmlDataDocument) {
		EquityUnderlierProvisions.EquityUnderlierProvisionsBuilder equityUnderlierProvisionsBuilder = doEvaluate(fpmlDataDocument);
		
		final EquityUnderlierProvisions equityUnderlierProvisions;
		if (equityUnderlierProvisionsBuilder == null) {
			equityUnderlierProvisions = null;
		} else {
			equityUnderlierProvisions = equityUnderlierProvisionsBuilder.build();
			objectValidator.validate(EquityUnderlierProvisions.class, equityUnderlierProvisions);
		}
		
		return equityUnderlierProvisions;
	}

	protected abstract EquityUnderlierProvisions.EquityUnderlierProvisionsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapEquityUnderlierProvisionsDefault extends MapEquityUnderlierProvisions {
		@Override
		protected EquityUnderlierProvisions.EquityUnderlierProvisionsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			EquityUnderlierProvisions.EquityUnderlierProvisionsBuilder equityUnderlierProvisions = EquityUnderlierProvisions.builder();
			return assignOutput(equityUnderlierProvisions, fpmlDataDocument);
		}
		
		protected EquityUnderlierProvisions.EquityUnderlierProvisionsBuilder assignOutput(EquityUnderlierProvisions.EquityUnderlierProvisionsBuilder equityUnderlierProvisions, DataDocument fpmlDataDocument) {
			equityUnderlierProvisions = toBuilder(EquityUnderlierProvisions.builder()
				.setMultipleExchangeIndexAnnexFallback(null)
				.setComponentSecurityIndexAnnexFallback(null)
				.setLocalJurisdictionValue(mapLocalJurisdictionWithScheme.evaluate(fpmlDataDocument))
				.setRelevantJurisdictionValue(mapRelevantJurisdictionWithScheme.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(equityUnderlierProvisions)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
