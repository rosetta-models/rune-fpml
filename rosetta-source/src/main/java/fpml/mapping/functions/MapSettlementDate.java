package fpml.mapping.functions;

import cdm.product.common.settlement.SettlementDate;
import cdm.product.common.settlement.SettlementDate.SettlementDateBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapSettlementDate.MapSettlementDateDefault.class)
public abstract class MapSettlementDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableDates mapAdjustableDates;
	@Inject protected MapAdjustableOrAdjustedOrRelativeDate mapAdjustableOrAdjustedOrRelativeDate;
	@Inject protected MapBusinessDateRange mapBusinessDateRange;

	/**
	* @param fpmlDataDocument 
	* @return settlementDate 
	*/
	public SettlementDate evaluate(DataDocument fpmlDataDocument) {
		SettlementDate.SettlementDateBuilder settlementDateBuilder = doEvaluate(fpmlDataDocument);
		
		final SettlementDate settlementDate;
		if (settlementDateBuilder == null) {
			settlementDate = null;
		} else {
			settlementDate = settlementDateBuilder.build();
			objectValidator.validate(SettlementDate.class, settlementDate);
		}
		
		return settlementDate;
	}

	protected abstract SettlementDate.SettlementDateBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapSettlementDateDefault extends MapSettlementDate {
		@Override
		protected SettlementDate.SettlementDateBuilder doEvaluate(DataDocument fpmlDataDocument) {
			SettlementDate.SettlementDateBuilder settlementDate = SettlementDate.builder();
			return assignOutput(settlementDate, fpmlDataDocument);
		}
		
		protected SettlementDate.SettlementDateBuilder assignOutput(SettlementDate.SettlementDateBuilder settlementDate, DataDocument fpmlDataDocument) {
			settlementDate = toBuilder(SettlementDate.builder()
				.setAdjustableOrRelativeDate(mapAdjustableOrAdjustedOrRelativeDate.evaluate(fpmlDataDocument))
				.setValueDate(null)
				.setAdjustableDates(mapAdjustableDates.evaluate(fpmlDataDocument))
				.setBusinessDateRange(mapBusinessDateRange.evaluate(fpmlDataDocument))
				.setCashSettlementBusinessDays(null)
				.setPaymentDelay(null)
				.build());
			
			return Optional.ofNullable(settlementDate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
