package fpml.mapping.functions;

import cdm.product.template.CancellationEvent;
import cdm.product.template.CancellationEvent.CancellationEventBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapCancellationEventList.MapCancellationEventListDefault.class)
public abstract class MapCancellationEventList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return cancellationEventList 
	*/
	public List<? extends CancellationEvent> evaluate(DataDocument fpmlDataDocument) {
		List<CancellationEvent.CancellationEventBuilder> cancellationEventListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends CancellationEvent> cancellationEventList;
		if (cancellationEventListBuilder == null) {
			cancellationEventList = null;
		} else {
			cancellationEventList = cancellationEventListBuilder.stream().map(CancellationEvent::build).collect(Collectors.toList());
			objectValidator.validate(CancellationEvent.class, cancellationEventList);
		}
		
		return cancellationEventList;
	}

	protected abstract List<CancellationEvent.CancellationEventBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCancellationEventListDefault extends MapCancellationEventList {
		@Override
		protected List<CancellationEvent.CancellationEventBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<CancellationEvent.CancellationEventBuilder> cancellationEventList = new ArrayList<>();
			return assignOutput(cancellationEventList, fpmlDataDocument);
		}
		
		protected List<CancellationEvent.CancellationEventBuilder> assignOutput(List<CancellationEvent.CancellationEventBuilder> cancellationEventList, DataDocument fpmlDataDocument) {
			cancellationEventList.addAll(toBuilder(MapperC.<CancellationEvent>of(MapperS.of(CancellationEvent.builder()
				.setAdjustedExerciseDate(null)
				.setAdjustedEarlyTerminationDate(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(cancellationEventList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
