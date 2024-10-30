package fpml.mapping.functions;

import cdm.product.common.settlement.PhysicalSettlementPeriod;
import cdm.product.common.settlement.PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPhysicalSettlementPeriod.MapPhysicalSettlementPeriodDefault.class)
public abstract class MapPhysicalSettlementPeriod implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return physicalSettlementPeriod 
	*/
	public PhysicalSettlementPeriod evaluate(DataDocument fpmlDataDocument) {
		PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder physicalSettlementPeriodBuilder = doEvaluate(fpmlDataDocument);
		
		final PhysicalSettlementPeriod physicalSettlementPeriod;
		if (physicalSettlementPeriodBuilder == null) {
			physicalSettlementPeriod = null;
		} else {
			physicalSettlementPeriod = physicalSettlementPeriodBuilder.build();
			objectValidator.validate(PhysicalSettlementPeriod.class, physicalSettlementPeriod);
		}
		
		return physicalSettlementPeriod;
	}

	protected abstract PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPhysicalSettlementPeriodDefault extends MapPhysicalSettlementPeriod {
		@Override
		protected PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder doEvaluate(DataDocument fpmlDataDocument) {
			PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder physicalSettlementPeriod = PhysicalSettlementPeriod.builder();
			return assignOutput(physicalSettlementPeriod, fpmlDataDocument);
		}
		
		protected PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder assignOutput(PhysicalSettlementPeriod.PhysicalSettlementPeriodBuilder physicalSettlementPeriod, DataDocument fpmlDataDocument) {
			physicalSettlementPeriod = toBuilder(PhysicalSettlementPeriod.builder()
				.setBusinessDaysNotSpecified(null)
				.setBusinessDays(null)
				.setMaximumBusinessDays(null)
				.build());
			
			return Optional.ofNullable(physicalSettlementPeriod)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
