package fpml.mapping.functions;

import cdm.product.common.schedule.InitialFixingDate;
import cdm.product.common.schedule.InitialFixingDate.InitialFixingDateBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapInitialFixingDate.MapInitialFixingDateDefault.class)
public abstract class MapInitialFixingDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapRelativeDateOffset mapRelativeDateOffset;

	/**
	* @param fpmlDataDocument 
	* @return initialFixingDate 
	*/
	public InitialFixingDate evaluate(DataDocument fpmlDataDocument) {
		InitialFixingDate.InitialFixingDateBuilder initialFixingDateBuilder = doEvaluate(fpmlDataDocument);
		
		final InitialFixingDate initialFixingDate;
		if (initialFixingDateBuilder == null) {
			initialFixingDate = null;
		} else {
			initialFixingDate = initialFixingDateBuilder.build();
			objectValidator.validate(InitialFixingDate.class, initialFixingDate);
		}
		
		return initialFixingDate;
	}

	protected abstract InitialFixingDate.InitialFixingDateBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapInitialFixingDateDefault extends MapInitialFixingDate {
		@Override
		protected InitialFixingDate.InitialFixingDateBuilder doEvaluate(DataDocument fpmlDataDocument) {
			InitialFixingDate.InitialFixingDateBuilder initialFixingDate = InitialFixingDate.builder();
			return assignOutput(initialFixingDate, fpmlDataDocument);
		}
		
		protected InitialFixingDate.InitialFixingDateBuilder assignOutput(InitialFixingDate.InitialFixingDateBuilder initialFixingDate, DataDocument fpmlDataDocument) {
			initialFixingDate = toBuilder(InitialFixingDate.builder()
				.setRelativeDateOffset(mapRelativeDateOffset.evaluate(fpmlDataDocument))
				.setInitialFixingDate(null)
				.build());
			
			return Optional.ofNullable(initialFixingDate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
