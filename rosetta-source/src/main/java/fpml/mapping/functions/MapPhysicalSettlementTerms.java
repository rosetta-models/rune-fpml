package fpml.mapping.functions;

import cdm.product.common.settlement.PhysicalSettlementTerms;
import cdm.product.common.settlement.PhysicalSettlementTerms.PhysicalSettlementTermsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPhysicalSettlementTerms.MapPhysicalSettlementTermsDefault.class)
public abstract class MapPhysicalSettlementTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDeliverableObligations mapDeliverableObligations;
	@Inject protected MapPhysicalSettlementPeriod mapPhysicalSettlementPeriod;

	/**
	* @param fpmlDataDocument 
	* @return physicalSettlementTerms 
	*/
	public PhysicalSettlementTerms evaluate(DataDocument fpmlDataDocument) {
		PhysicalSettlementTerms.PhysicalSettlementTermsBuilder physicalSettlementTermsBuilder = doEvaluate(fpmlDataDocument);
		
		final PhysicalSettlementTerms physicalSettlementTerms;
		if (physicalSettlementTermsBuilder == null) {
			physicalSettlementTerms = null;
		} else {
			physicalSettlementTerms = physicalSettlementTermsBuilder.build();
			objectValidator.validate(PhysicalSettlementTerms.class, physicalSettlementTerms);
		}
		
		return physicalSettlementTerms;
	}

	protected abstract PhysicalSettlementTerms.PhysicalSettlementTermsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPhysicalSettlementTermsDefault extends MapPhysicalSettlementTerms {
		@Override
		protected PhysicalSettlementTerms.PhysicalSettlementTermsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			PhysicalSettlementTerms.PhysicalSettlementTermsBuilder physicalSettlementTerms = PhysicalSettlementTerms.builder();
			return assignOutput(physicalSettlementTerms, fpmlDataDocument);
		}
		
		protected PhysicalSettlementTerms.PhysicalSettlementTermsBuilder assignOutput(PhysicalSettlementTerms.PhysicalSettlementTermsBuilder physicalSettlementTerms, DataDocument fpmlDataDocument) {
			physicalSettlementTerms = toBuilder(PhysicalSettlementTerms.builder()
				.setClearedPhysicalSettlement(null)
				.setPredeterminedClearingOrganizationParty(null)
				.setPhysicalSettlementPeriod(mapPhysicalSettlementPeriod.evaluate(fpmlDataDocument))
				.setDeliverableObligations(mapDeliverableObligations.evaluate(fpmlDataDocument))
				.setEscrow(null)
				.setSixtyBusinessDaySettlementCap(null)
				.build());
			
			return Optional.ofNullable(physicalSettlementTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
