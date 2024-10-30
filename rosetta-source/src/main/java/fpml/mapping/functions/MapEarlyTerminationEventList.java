package fpml.mapping.functions;

import cdm.product.template.EarlyTerminationEvent;
import cdm.product.template.EarlyTerminationEvent.EarlyTerminationEventBuilder;
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


@ImplementedBy(MapEarlyTerminationEventList.MapEarlyTerminationEventListDefault.class)
public abstract class MapEarlyTerminationEventList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return earlyTerminationEventList 
	*/
	public List<? extends EarlyTerminationEvent> evaluate(DataDocument fpmlDataDocument) {
		List<EarlyTerminationEvent.EarlyTerminationEventBuilder> earlyTerminationEventListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends EarlyTerminationEvent> earlyTerminationEventList;
		if (earlyTerminationEventListBuilder == null) {
			earlyTerminationEventList = null;
		} else {
			earlyTerminationEventList = earlyTerminationEventListBuilder.stream().map(EarlyTerminationEvent::build).collect(Collectors.toList());
			objectValidator.validate(EarlyTerminationEvent.class, earlyTerminationEventList);
		}
		
		return earlyTerminationEventList;
	}

	protected abstract List<EarlyTerminationEvent.EarlyTerminationEventBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapEarlyTerminationEventListDefault extends MapEarlyTerminationEventList {
		@Override
		protected List<EarlyTerminationEvent.EarlyTerminationEventBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<EarlyTerminationEvent.EarlyTerminationEventBuilder> earlyTerminationEventList = new ArrayList<>();
			return assignOutput(earlyTerminationEventList, fpmlDataDocument);
		}
		
		protected List<EarlyTerminationEvent.EarlyTerminationEventBuilder> assignOutput(List<EarlyTerminationEvent.EarlyTerminationEventBuilder> earlyTerminationEventList, DataDocument fpmlDataDocument) {
			earlyTerminationEventList.addAll(toBuilder(MapperC.<EarlyTerminationEvent>of(MapperS.of(EarlyTerminationEvent.builder()
				.setAdjustedExerciseDate(null)
				.setAdjustedEarlyTerminationDate(null)
				.setAdjustedCashSettlementValuationDate(null)
				.setAdjustedCashSettlementPaymentDate(null)
				.setAdjustedExerciseFeePaymentDate(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(earlyTerminationEventList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
