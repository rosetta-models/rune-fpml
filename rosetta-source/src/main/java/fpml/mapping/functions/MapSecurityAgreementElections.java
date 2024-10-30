package fpml.mapping.functions;

import cdm.legaldocumentation.csa.SecurityAgreementElections;
import cdm.legaldocumentation.csa.SecurityAgreementElections.SecurityAgreementElectionsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapSecurityAgreementElections.MapSecurityAgreementElectionsDefault.class)
public abstract class MapSecurityAgreementElections implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return securityAgreementElections 
	*/
	public SecurityAgreementElections evaluate(DataDocument fpmlDataDocument) {
		SecurityAgreementElections.SecurityAgreementElectionsBuilder securityAgreementElectionsBuilder = doEvaluate(fpmlDataDocument);
		
		final SecurityAgreementElections securityAgreementElections;
		if (securityAgreementElectionsBuilder == null) {
			securityAgreementElections = null;
		} else {
			securityAgreementElections = securityAgreementElectionsBuilder.build();
			objectValidator.validate(SecurityAgreementElections.class, securityAgreementElections);
		}
		
		return securityAgreementElections;
	}

	protected abstract SecurityAgreementElections.SecurityAgreementElectionsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapSecurityAgreementElectionsDefault extends MapSecurityAgreementElections {
		@Override
		protected SecurityAgreementElections.SecurityAgreementElectionsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			SecurityAgreementElections.SecurityAgreementElectionsBuilder securityAgreementElections = SecurityAgreementElections.builder();
			return assignOutput(securityAgreementElections, fpmlDataDocument);
		}
		
		protected SecurityAgreementElections.SecurityAgreementElectionsBuilder assignOutput(SecurityAgreementElections.SecurityAgreementElectionsBuilder securityAgreementElections, DataDocument fpmlDataDocument) {
			securityAgreementElections = toBuilder(SecurityAgreementElections.builder()
				.build());
			
			return Optional.ofNullable(securityAgreementElections)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
