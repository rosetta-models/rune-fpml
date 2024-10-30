package fpml.mapping.functions;

import cdm.product.common.settlement.PCDeliverableObligationCharac;
import cdm.product.common.settlement.PCDeliverableObligationCharac.PCDeliverableObligationCharacBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPCDeliverableObligationCharac.MapPCDeliverableObligationCharacDefault.class)
public abstract class MapPCDeliverableObligationCharac implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return pCDeliverableObligationCharac 
	*/
	public PCDeliverableObligationCharac evaluate(DataDocument fpmlDataDocument) {
		PCDeliverableObligationCharac.PCDeliverableObligationCharacBuilder pCDeliverableObligationCharacBuilder = doEvaluate(fpmlDataDocument);
		
		final PCDeliverableObligationCharac pCDeliverableObligationCharac;
		if (pCDeliverableObligationCharacBuilder == null) {
			pCDeliverableObligationCharac = null;
		} else {
			pCDeliverableObligationCharac = pCDeliverableObligationCharacBuilder.build();
			objectValidator.validate(PCDeliverableObligationCharac.class, pCDeliverableObligationCharac);
		}
		
		return pCDeliverableObligationCharac;
	}

	protected abstract PCDeliverableObligationCharac.PCDeliverableObligationCharacBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPCDeliverableObligationCharacDefault extends MapPCDeliverableObligationCharac {
		@Override
		protected PCDeliverableObligationCharac.PCDeliverableObligationCharacBuilder doEvaluate(DataDocument fpmlDataDocument) {
			PCDeliverableObligationCharac.PCDeliverableObligationCharacBuilder pCDeliverableObligationCharac = PCDeliverableObligationCharac.builder();
			return assignOutput(pCDeliverableObligationCharac, fpmlDataDocument);
		}
		
		protected PCDeliverableObligationCharac.PCDeliverableObligationCharacBuilder assignOutput(PCDeliverableObligationCharac.PCDeliverableObligationCharacBuilder pCDeliverableObligationCharac, DataDocument fpmlDataDocument) {
			pCDeliverableObligationCharac = toBuilder(PCDeliverableObligationCharac.builder()
				.setApplicable(null)
				.setPartialCashSettlement(null)
				.build());
			
			return Optional.ofNullable(pCDeliverableObligationCharac)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
