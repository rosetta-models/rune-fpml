package fpml.mapping.functions;

import cdm.legaldocumentation.csa.CreditSupportAgreementElections;
import cdm.legaldocumentation.csa.CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCreditSupportAgreementElections.MapCreditSupportAgreementElectionsDefault.class)
public abstract class MapCreditSupportAgreementElections implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return creditSupportAgreementElections 
	*/
	public CreditSupportAgreementElections evaluate(DataDocument fpmlDataDocument) {
		CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder creditSupportAgreementElectionsBuilder = doEvaluate(fpmlDataDocument);
		
		final CreditSupportAgreementElections creditSupportAgreementElections;
		if (creditSupportAgreementElectionsBuilder == null) {
			creditSupportAgreementElections = null;
		} else {
			creditSupportAgreementElections = creditSupportAgreementElectionsBuilder.build();
			objectValidator.validate(CreditSupportAgreementElections.class, creditSupportAgreementElections);
		}
		
		return creditSupportAgreementElections;
	}

	protected abstract CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCreditSupportAgreementElectionsDefault extends MapCreditSupportAgreementElections {
		@Override
		protected CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder creditSupportAgreementElections = CreditSupportAgreementElections.builder();
			return assignOutput(creditSupportAgreementElections, fpmlDataDocument);
		}
		
		protected CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder assignOutput(CreditSupportAgreementElections.CreditSupportAgreementElectionsBuilder creditSupportAgreementElections, DataDocument fpmlDataDocument) {
			creditSupportAgreementElections = toBuilder(CreditSupportAgreementElections.builder()
				.build());
			
			return Optional.ofNullable(creditSupportAgreementElections)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
