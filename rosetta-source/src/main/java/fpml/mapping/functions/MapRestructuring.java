package fpml.mapping.functions;

import cdm.observable.event.Restructuring;
import cdm.observable.event.Restructuring.RestructuringBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapRestructuring.MapRestructuringDefault.class)
public abstract class MapRestructuring implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapRestructuringTypeWithScheme mapRestructuringTypeWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return restructuring 
	*/
	public Restructuring evaluate(DataDocument fpmlDataDocument) {
		Restructuring.RestructuringBuilder restructuringBuilder = doEvaluate(fpmlDataDocument);
		
		final Restructuring restructuring;
		if (restructuringBuilder == null) {
			restructuring = null;
		} else {
			restructuring = restructuringBuilder.build();
			objectValidator.validate(Restructuring.class, restructuring);
		}
		
		return restructuring;
	}

	protected abstract Restructuring.RestructuringBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapRestructuringDefault extends MapRestructuring {
		@Override
		protected Restructuring.RestructuringBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Restructuring.RestructuringBuilder restructuring = Restructuring.builder();
			return assignOutput(restructuring, fpmlDataDocument);
		}
		
		protected Restructuring.RestructuringBuilder assignOutput(Restructuring.RestructuringBuilder restructuring, DataDocument fpmlDataDocument) {
			restructuring = toBuilder(Restructuring.builder()
				.setApplicable(null)
				.setRestructuringTypeValue(mapRestructuringTypeWithScheme.evaluate(fpmlDataDocument))
				.setMultipleHolderObligation(null)
				.setMultipleCreditEventNotices(null)
				.build());
			
			return Optional.ofNullable(restructuring)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
