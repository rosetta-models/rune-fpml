package fpml.mapping.functions;

import cdm.product.common.settlement.DeliverableObligations;
import cdm.product.common.settlement.DeliverableObligations.DeliverableObligationsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDeliverableObligations.MapDeliverableObligationsDefault.class)
public abstract class MapDeliverableObligations implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapLoanParticipation mapLoanParticipation;
	@Inject protected MapNotDomesticCurrency mapNotDomesticCurrency;
	@Inject protected MapPCDeliverableObligationCharac mapPCDeliverableObligationCharac;
	@Inject protected MapPeriod mapPeriod;
	@Inject protected MapSpecifiedCurrency mapSpecifiedCurrency;

	/**
	* @param fpmlDataDocument 
	* @return deliverableObligations 
	*/
	public DeliverableObligations evaluate(DataDocument fpmlDataDocument) {
		DeliverableObligations.DeliverableObligationsBuilder deliverableObligationsBuilder = doEvaluate(fpmlDataDocument);
		
		final DeliverableObligations deliverableObligations;
		if (deliverableObligationsBuilder == null) {
			deliverableObligations = null;
		} else {
			deliverableObligations = deliverableObligationsBuilder.build();
			objectValidator.validate(DeliverableObligations.class, deliverableObligations);
		}
		
		return deliverableObligations;
	}

	protected abstract DeliverableObligations.DeliverableObligationsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapDeliverableObligationsDefault extends MapDeliverableObligations {
		@Override
		protected DeliverableObligations.DeliverableObligationsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			DeliverableObligations.DeliverableObligationsBuilder deliverableObligations = DeliverableObligations.builder();
			return assignOutput(deliverableObligations, fpmlDataDocument);
		}
		
		protected DeliverableObligations.DeliverableObligationsBuilder assignOutput(DeliverableObligations.DeliverableObligationsBuilder deliverableObligations, DataDocument fpmlDataDocument) {
			deliverableObligations = toBuilder(DeliverableObligations.builder()
				.setAccruedInterest(null)
				.setCategory(null)
				.setNotSubordinated(null)
				.setSpecifiedCurrency(mapSpecifiedCurrency.evaluate(fpmlDataDocument))
				.setNotSovereignLender(null)
				.setNotDomesticCurrency(mapNotDomesticCurrency.evaluate(fpmlDataDocument))
				.setNotDomesticLaw(null)
				.setListed(null)
				.setNotContingent(null)
				.setNotDomesticIssuance(null)
				.setAssignableLoan(mapPCDeliverableObligationCharac.evaluate(fpmlDataDocument))
				.setConsentRequiredLoan(mapPCDeliverableObligationCharac.evaluate(fpmlDataDocument))
				.setDirectLoanParticipation(mapLoanParticipation.evaluate(fpmlDataDocument))
				.setTransferable(null)
				.setMaximumMaturity(mapPeriod.evaluate(fpmlDataDocument))
				.setAcceleratedOrMatured(null)
				.setNotBearer(null)
				.setFullFaithAndCreditObLiability(null)
				.setGeneralFundObligationLiability(null)
				.setRevenueObligationLiability(null)
				.setIndirectLoanParticipation(mapLoanParticipation.evaluate(fpmlDataDocument))
				.setExcluded(null)
				.setOthReferenceEntityObligations(null)
				.build());
			
			return Optional.ofNullable(deliverableObligations)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
