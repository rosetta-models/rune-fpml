package fpml.mapping.functions;

import cdm.product.asset.ProtectionTerms;
import cdm.product.asset.ProtectionTerms.ProtectionTermsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapProtectionTerms.MapProtectionTermsDefault.class)
public abstract class MapProtectionTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCreditEvents mapCreditEvents;
	@Inject protected MapFloatingAmountEvents mapFloatingAmountEvents;
	@Inject protected MapObligations mapObligations;

	/**
	* @param fpmlDataDocument 
	* @return protectionTerms 
	*/
	public ProtectionTerms evaluate(DataDocument fpmlDataDocument) {
		ProtectionTerms.ProtectionTermsBuilder protectionTermsBuilder = doEvaluate(fpmlDataDocument);
		
		final ProtectionTerms protectionTerms;
		if (protectionTermsBuilder == null) {
			protectionTerms = null;
		} else {
			protectionTerms = protectionTermsBuilder.build();
			objectValidator.validate(ProtectionTerms.class, protectionTerms);
		}
		
		return protectionTerms;
	}

	protected abstract ProtectionTerms.ProtectionTermsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapProtectionTermsDefault extends MapProtectionTerms {
		@Override
		protected ProtectionTerms.ProtectionTermsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ProtectionTerms.ProtectionTermsBuilder protectionTerms = ProtectionTerms.builder();
			return assignOutput(protectionTerms, fpmlDataDocument);
		}
		
		protected ProtectionTerms.ProtectionTermsBuilder assignOutput(ProtectionTerms.ProtectionTermsBuilder protectionTerms, DataDocument fpmlDataDocument) {
			protectionTerms = toBuilder(ProtectionTerms.builder()
				.setCreditEvents(mapCreditEvents.evaluate(fpmlDataDocument))
				.setObligations(mapObligations.evaluate(fpmlDataDocument))
				.setFloatingAmountEvents(mapFloatingAmountEvents.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(protectionTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
