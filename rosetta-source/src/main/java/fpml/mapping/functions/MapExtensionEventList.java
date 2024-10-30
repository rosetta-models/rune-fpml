package fpml.mapping.functions;

import cdm.product.template.ExtensionEvent;
import cdm.product.template.ExtensionEvent.ExtensionEventBuilder;
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


@ImplementedBy(MapExtensionEventList.MapExtensionEventListDefault.class)
public abstract class MapExtensionEventList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return extensionEventList 
	*/
	public List<? extends ExtensionEvent> evaluate(DataDocument fpmlDataDocument) {
		List<ExtensionEvent.ExtensionEventBuilder> extensionEventListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends ExtensionEvent> extensionEventList;
		if (extensionEventListBuilder == null) {
			extensionEventList = null;
		} else {
			extensionEventList = extensionEventListBuilder.stream().map(ExtensionEvent::build).collect(Collectors.toList());
			objectValidator.validate(ExtensionEvent.class, extensionEventList);
		}
		
		return extensionEventList;
	}

	protected abstract List<ExtensionEvent.ExtensionEventBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapExtensionEventListDefault extends MapExtensionEventList {
		@Override
		protected List<ExtensionEvent.ExtensionEventBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<ExtensionEvent.ExtensionEventBuilder> extensionEventList = new ArrayList<>();
			return assignOutput(extensionEventList, fpmlDataDocument);
		}
		
		protected List<ExtensionEvent.ExtensionEventBuilder> assignOutput(List<ExtensionEvent.ExtensionEventBuilder> extensionEventList, DataDocument fpmlDataDocument) {
			extensionEventList.addAll(toBuilder(MapperC.<ExtensionEvent>of(MapperS.of(ExtensionEvent.builder()
				.setAdjustedExerciseDate(null)
				.setAdjustedExtendedTerminationDate(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(extensionEventList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
