package fpml.mapping.functions;

import cdm.base.staticdata.asset.credit.Obligations;
import cdm.base.staticdata.asset.credit.Obligations.ObligationsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapObligations.MapObligationsDefault.class)
public abstract class MapObligations implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDesignatedPriorityWithScheme mapDesignatedPriorityWithScheme;
	@Inject protected MapNotDomesticCurrency mapNotDomesticCurrency;
	@Inject protected MapSpecifiedCurrency mapSpecifiedCurrency;

	/**
	* @param fpmlDataDocument 
	* @return obligations 
	*/
	public Obligations evaluate(DataDocument fpmlDataDocument) {
		Obligations.ObligationsBuilder obligationsBuilder = doEvaluate(fpmlDataDocument);
		
		final Obligations obligations;
		if (obligationsBuilder == null) {
			obligations = null;
		} else {
			obligations = obligationsBuilder.build();
			objectValidator.validate(Obligations.class, obligations);
		}
		
		return obligations;
	}

	protected abstract Obligations.ObligationsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapObligationsDefault extends MapObligations {
		@Override
		protected Obligations.ObligationsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Obligations.ObligationsBuilder obligations = Obligations.builder();
			return assignOutput(obligations, fpmlDataDocument);
		}
		
		protected Obligations.ObligationsBuilder assignOutput(Obligations.ObligationsBuilder obligations, DataDocument fpmlDataDocument) {
			obligations = toBuilder(Obligations.builder()
				.setCategory(null)
				.setNotSubordinated(null)
				.setSpecifiedCurrency(mapSpecifiedCurrency.evaluate(fpmlDataDocument))
				.setNotSovereignLender(null)
				.setNotDomesticCurrency(mapNotDomesticCurrency.evaluate(fpmlDataDocument))
				.setNotDomesticLaw(null)
				.setListed(null)
				.setNotDomesticIssuance(null)
				.setFullFaithAndCreditObLiability(null)
				.setGeneralFundObligationLiability(null)
				.setRevenueObligationLiability(null)
				.setNotContingent(null)
				.setExcluded(null)
				.setOthReferenceEntityObligations(null)
				.setDesignatedPriorityValue(mapDesignatedPriorityWithScheme.evaluate(fpmlDataDocument))
				.setCashSettlementOnly(null)
				.setDeliveryOfCommitments(null)
				.setContinuity(null)
				.build());
			
			return Optional.ofNullable(obligations)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
