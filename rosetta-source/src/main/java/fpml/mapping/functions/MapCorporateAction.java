package fpml.mapping.functions;

import cdm.event.common.CorporateAction;
import cdm.event.common.CorporateAction.CorporateActionBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCorporateAction.MapCorporateActionDefault.class)
public abstract class MapCorporateAction implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapInstrument mapInstrument;

	/**
	* @param fpmlDataDocument 
	* @return corporateAction 
	*/
	public CorporateAction evaluate(DataDocument fpmlDataDocument) {
		CorporateAction.CorporateActionBuilder corporateActionBuilder = doEvaluate(fpmlDataDocument);
		
		final CorporateAction corporateAction;
		if (corporateActionBuilder == null) {
			corporateAction = null;
		} else {
			corporateAction = corporateActionBuilder.build();
			objectValidator.validate(CorporateAction.class, corporateAction);
		}
		
		return corporateAction;
	}

	protected abstract CorporateAction.CorporateActionBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCorporateActionDefault extends MapCorporateAction {
		@Override
		protected CorporateAction.CorporateActionBuilder doEvaluate(DataDocument fpmlDataDocument) {
			CorporateAction.CorporateActionBuilder corporateAction = CorporateAction.builder();
			return assignOutput(corporateAction, fpmlDataDocument);
		}
		
		protected CorporateAction.CorporateActionBuilder assignOutput(CorporateAction.CorporateActionBuilder corporateAction, DataDocument fpmlDataDocument) {
			corporateAction = toBuilder(CorporateAction.builder()
				.setCorporateActionType(null)
				.setExDate(null)
				.setPayDate(null)
				.setUnderlier(mapInstrument.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(corporateAction)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
