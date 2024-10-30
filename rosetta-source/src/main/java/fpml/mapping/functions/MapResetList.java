package fpml.mapping.functions;

import cdm.event.common.Reset;
import cdm.event.common.Reset.ResetBuilder;
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


@ImplementedBy(MapResetList.MapResetListDefault.class)
public abstract class MapResetList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAveragingCalculation mapAveragingCalculation;
	@Inject protected MapObservationList mapObservationList;
	@Inject protected MapPrice mapPrice;

	/**
	* @param fpmlDataDocument 
	* @return resetList 
	*/
	public List<? extends Reset> evaluate(DataDocument fpmlDataDocument) {
		List<Reset.ResetBuilder> resetListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends Reset> resetList;
		if (resetListBuilder == null) {
			resetList = null;
		} else {
			resetList = resetListBuilder.stream().map(Reset::build).collect(Collectors.toList());
			objectValidator.validate(Reset.class, resetList);
		}
		
		return resetList;
	}

	protected abstract List<Reset.ResetBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapResetListDefault extends MapResetList {
		@Override
		protected List<Reset.ResetBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<Reset.ResetBuilder> resetList = new ArrayList<>();
			return assignOutput(resetList, fpmlDataDocument);
		}
		
		protected List<Reset.ResetBuilder> assignOutput(List<Reset.ResetBuilder> resetList, DataDocument fpmlDataDocument) {
			resetList.addAll(toBuilder(MapperC.<Reset>of(MapperS.of(Reset.builder()
				.setResetValue(mapPrice.evaluate(fpmlDataDocument))
				.setResetDate(null)
				.setRateRecordDate(null)
				.setObservationsValue(new ArrayList(mapObservationList.evaluate(fpmlDataDocument)))
				.setAveragingMethodology(mapAveragingCalculation.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(resetList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
