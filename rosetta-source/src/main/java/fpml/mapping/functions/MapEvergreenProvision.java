package fpml.mapping.functions;

import cdm.product.template.EvergreenProvision;
import cdm.product.template.EvergreenProvision.EvergreenProvisionBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapEvergreenProvision.MapEvergreenProvisionDefault.class)
public abstract class MapEvergreenProvision implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableRelativeOrPeriodicDates mapAdjustableRelativeOrPeriodicDates;
	@Inject protected MapPartyRole mapPartyRole;
	@Inject protected MapPrice mapPrice;
	@Inject protected MapRelativeDateOffset mapRelativeDateOffset;

	/**
	* @param fpmlDataDocument 
	* @return evergreenProvision 
	*/
	public EvergreenProvision evaluate(DataDocument fpmlDataDocument) {
		EvergreenProvision.EvergreenProvisionBuilder evergreenProvisionBuilder = doEvaluate(fpmlDataDocument);
		
		final EvergreenProvision evergreenProvision;
		if (evergreenProvisionBuilder == null) {
			evergreenProvision = null;
		} else {
			evergreenProvision = evergreenProvisionBuilder.build();
			objectValidator.validate(EvergreenProvision.class, evergreenProvision);
		}
		
		return evergreenProvision;
	}

	protected abstract EvergreenProvision.EvergreenProvisionBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapEvergreenProvisionDefault extends MapEvergreenProvision {
		@Override
		protected EvergreenProvision.EvergreenProvisionBuilder doEvaluate(DataDocument fpmlDataDocument) {
			EvergreenProvision.EvergreenProvisionBuilder evergreenProvision = EvergreenProvision.builder();
			return assignOutput(evergreenProvision, fpmlDataDocument);
		}
		
		protected EvergreenProvision.EvergreenProvisionBuilder assignOutput(EvergreenProvision.EvergreenProvisionBuilder evergreenProvision, DataDocument fpmlDataDocument) {
			evergreenProvision = toBuilder(EvergreenProvision.builder()
				.setSinglePartyOption(mapPartyRole.evaluate(fpmlDataDocument))
				.setNoticePeriod(mapRelativeDateOffset.evaluate(fpmlDataDocument))
				.setNoticeDeadlinePeriod(mapRelativeDateOffset.evaluate(fpmlDataDocument))
				.setNoticeDeadlineDateTime(null)
				.setExtensionFrequency(mapAdjustableRelativeOrPeriodicDates.evaluate(fpmlDataDocument))
				.setFinalPeriodFeeAdjustment(mapPrice.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(evergreenProvision)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
