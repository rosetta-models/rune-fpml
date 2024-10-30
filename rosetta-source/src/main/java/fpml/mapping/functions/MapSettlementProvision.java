package fpml.mapping.functions;

import cdm.product.common.settlement.SettlementProvision;
import cdm.product.common.settlement.SettlementProvision.SettlementProvisionBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapSettlementProvision.MapSettlementProvisionDefault.class)
public abstract class MapSettlementProvision implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapShapingProvision mapShapingProvision;

	/**
	* @param fpmlDataDocument 
	* @return settlementProvision 
	*/
	public SettlementProvision evaluate(DataDocument fpmlDataDocument) {
		SettlementProvision.SettlementProvisionBuilder settlementProvisionBuilder = doEvaluate(fpmlDataDocument);
		
		final SettlementProvision settlementProvision;
		if (settlementProvisionBuilder == null) {
			settlementProvision = null;
		} else {
			settlementProvision = settlementProvisionBuilder.build();
			objectValidator.validate(SettlementProvision.class, settlementProvision);
		}
		
		return settlementProvision;
	}

	protected abstract SettlementProvision.SettlementProvisionBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapSettlementProvisionDefault extends MapSettlementProvision {
		@Override
		protected SettlementProvision.SettlementProvisionBuilder doEvaluate(DataDocument fpmlDataDocument) {
			SettlementProvision.SettlementProvisionBuilder settlementProvision = SettlementProvision.builder();
			return assignOutput(settlementProvision, fpmlDataDocument);
		}
		
		protected SettlementProvision.SettlementProvisionBuilder assignOutput(SettlementProvision.SettlementProvisionBuilder settlementProvision, DataDocument fpmlDataDocument) {
			settlementProvision = toBuilder(SettlementProvision.builder()
				.setShapingProvisions(mapShapingProvision.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(settlementProvision)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
