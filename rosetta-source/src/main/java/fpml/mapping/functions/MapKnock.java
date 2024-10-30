package fpml.mapping.functions;

import cdm.product.template.Knock;
import cdm.product.template.Knock.KnockBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapKnock.MapKnockDefault.class)
public abstract class MapKnock implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapTriggerEvent mapTriggerEvent;

	/**
	* @param fpmlDataDocument 
	* @return knock 
	*/
	public Knock evaluate(DataDocument fpmlDataDocument) {
		Knock.KnockBuilder knockBuilder = doEvaluate(fpmlDataDocument);
		
		final Knock knock;
		if (knockBuilder == null) {
			knock = null;
		} else {
			knock = knockBuilder.build();
			objectValidator.validate(Knock.class, knock);
		}
		
		return knock;
	}

	protected abstract Knock.KnockBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapKnockDefault extends MapKnock {
		@Override
		protected Knock.KnockBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Knock.KnockBuilder knock = Knock.builder();
			return assignOutput(knock, fpmlDataDocument);
		}
		
		protected Knock.KnockBuilder assignOutput(Knock.KnockBuilder knock, DataDocument fpmlDataDocument) {
			knock = toBuilder(Knock.builder()
				.setKnockIn(mapTriggerEvent.evaluate(fpmlDataDocument))
				.setKnockOut(mapTriggerEvent.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(knock)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
