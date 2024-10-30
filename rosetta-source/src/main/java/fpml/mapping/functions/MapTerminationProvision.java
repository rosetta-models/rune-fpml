package fpml.mapping.functions;

import cdm.product.template.TerminationProvision;
import cdm.product.template.TerminationProvision.TerminationProvisionBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapTerminationProvision.MapTerminationProvisionDefault.class)
public abstract class MapTerminationProvision implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCancelableProvision mapCancelableProvision;
	@Inject protected MapEarlyTerminationProvision mapEarlyTerminationProvision;
	@Inject protected MapEvergreenProvision mapEvergreenProvision;
	@Inject protected MapExtendibleProvision mapExtendibleProvision;

	/**
	* @param fpmlDataDocument 
	* @return terminationProvision 
	*/
	public TerminationProvision evaluate(DataDocument fpmlDataDocument) {
		TerminationProvision.TerminationProvisionBuilder terminationProvisionBuilder = doEvaluate(fpmlDataDocument);
		
		final TerminationProvision terminationProvision;
		if (terminationProvisionBuilder == null) {
			terminationProvision = null;
		} else {
			terminationProvision = terminationProvisionBuilder.build();
			objectValidator.validate(TerminationProvision.class, terminationProvision);
		}
		
		return terminationProvision;
	}

	protected abstract TerminationProvision.TerminationProvisionBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapTerminationProvisionDefault extends MapTerminationProvision {
		@Override
		protected TerminationProvision.TerminationProvisionBuilder doEvaluate(DataDocument fpmlDataDocument) {
			TerminationProvision.TerminationProvisionBuilder terminationProvision = TerminationProvision.builder();
			return assignOutput(terminationProvision, fpmlDataDocument);
		}
		
		protected TerminationProvision.TerminationProvisionBuilder assignOutput(TerminationProvision.TerminationProvisionBuilder terminationProvision, DataDocument fpmlDataDocument) {
			terminationProvision = toBuilder(TerminationProvision.builder()
				.setCancelableProvision(mapCancelableProvision.evaluate(fpmlDataDocument))
				.setEarlyTerminationProvision(mapEarlyTerminationProvision.evaluate(fpmlDataDocument))
				.setEvergreenProvision(mapEvergreenProvision.evaluate(fpmlDataDocument))
				.setExtendibleProvision(mapExtendibleProvision.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(terminationProvision)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
