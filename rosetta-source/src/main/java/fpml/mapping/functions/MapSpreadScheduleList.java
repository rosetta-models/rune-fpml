package fpml.mapping.functions;

import cdm.product.asset.SpreadSchedule;
import cdm.product.asset.SpreadSchedule.SpreadScheduleBuilder;
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


@ImplementedBy(MapSpreadScheduleList.MapSpreadScheduleListDefault.class)
public abstract class MapSpreadScheduleList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPriceSchedule mapPriceSchedule;
	@Inject protected MapSpreadScheduleTypeWithScheme mapSpreadScheduleTypeWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return spreadScheduleList 
	*/
	public List<? extends SpreadSchedule> evaluate(DataDocument fpmlDataDocument) {
		List<SpreadSchedule.SpreadScheduleBuilder> spreadScheduleListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends SpreadSchedule> spreadScheduleList;
		if (spreadScheduleListBuilder == null) {
			spreadScheduleList = null;
		} else {
			spreadScheduleList = spreadScheduleListBuilder.stream().map(SpreadSchedule::build).collect(Collectors.toList());
			objectValidator.validate(SpreadSchedule.class, spreadScheduleList);
		}
		
		return spreadScheduleList;
	}

	protected abstract List<SpreadSchedule.SpreadScheduleBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapSpreadScheduleListDefault extends MapSpreadScheduleList {
		@Override
		protected List<SpreadSchedule.SpreadScheduleBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<SpreadSchedule.SpreadScheduleBuilder> spreadScheduleList = new ArrayList<>();
			return assignOutput(spreadScheduleList, fpmlDataDocument);
		}
		
		protected List<SpreadSchedule.SpreadScheduleBuilder> assignOutput(List<SpreadSchedule.SpreadScheduleBuilder> spreadScheduleList, DataDocument fpmlDataDocument) {
			spreadScheduleList.addAll(toBuilder(MapperC.<SpreadSchedule>of(MapperS.of(SpreadSchedule.builder()
				.setPriceValue(mapPriceSchedule.evaluate(fpmlDataDocument))
				.setSpreadScheduleTypeValue(mapSpreadScheduleTypeWithScheme.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(spreadScheduleList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
