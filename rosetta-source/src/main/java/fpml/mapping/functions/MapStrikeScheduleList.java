package fpml.mapping.functions;

import cdm.product.template.StrikeSchedule;
import cdm.product.template.StrikeSchedule.StrikeScheduleBuilder;
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


@ImplementedBy(MapStrikeScheduleList.MapStrikeScheduleListDefault.class)
public abstract class MapStrikeScheduleList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPriceSchedule mapPriceSchedule;

	/**
	* @param fpmlDataDocument 
	* @return strikeScheduleList 
	*/
	public List<? extends StrikeSchedule> evaluate(DataDocument fpmlDataDocument) {
		List<StrikeSchedule.StrikeScheduleBuilder> strikeScheduleListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends StrikeSchedule> strikeScheduleList;
		if (strikeScheduleListBuilder == null) {
			strikeScheduleList = null;
		} else {
			strikeScheduleList = strikeScheduleListBuilder.stream().map(StrikeSchedule::build).collect(Collectors.toList());
			objectValidator.validate(StrikeSchedule.class, strikeScheduleList);
		}
		
		return strikeScheduleList;
	}

	protected abstract List<StrikeSchedule.StrikeScheduleBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapStrikeScheduleListDefault extends MapStrikeScheduleList {
		@Override
		protected List<StrikeSchedule.StrikeScheduleBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<StrikeSchedule.StrikeScheduleBuilder> strikeScheduleList = new ArrayList<>();
			return assignOutput(strikeScheduleList, fpmlDataDocument);
		}
		
		protected List<StrikeSchedule.StrikeScheduleBuilder> assignOutput(List<StrikeSchedule.StrikeScheduleBuilder> strikeScheduleList, DataDocument fpmlDataDocument) {
			strikeScheduleList.addAll(toBuilder(MapperC.<StrikeSchedule>of(MapperS.of(StrikeSchedule.builder()
				.setPriceValue(mapPriceSchedule.evaluate(fpmlDataDocument))
				.setBuyer(null)
				.setSeller(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(strikeScheduleList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
