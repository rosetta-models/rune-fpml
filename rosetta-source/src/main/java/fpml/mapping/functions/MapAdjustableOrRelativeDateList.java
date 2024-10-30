package fpml.mapping.functions;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder;
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


@ImplementedBy(MapAdjustableOrRelativeDateList.MapAdjustableOrRelativeDateListDefault.class)
public abstract class MapAdjustableOrRelativeDateList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableDate mapAdjustableDate;
	@Inject protected MapAdjustedRelativeDateOffset mapAdjustedRelativeDateOffset;

	/**
	* @param fpmlDataDocument 
	* @return adjustableOrRelativeDateList 
	*/
	public List<? extends AdjustableOrRelativeDate> evaluate(DataDocument fpmlDataDocument) {
		List<AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder> adjustableOrRelativeDateListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends AdjustableOrRelativeDate> adjustableOrRelativeDateList;
		if (adjustableOrRelativeDateListBuilder == null) {
			adjustableOrRelativeDateList = null;
		} else {
			adjustableOrRelativeDateList = adjustableOrRelativeDateListBuilder.stream().map(AdjustableOrRelativeDate::build).collect(Collectors.toList());
			objectValidator.validate(AdjustableOrRelativeDate.class, adjustableOrRelativeDateList);
		}
		
		return adjustableOrRelativeDateList;
	}

	protected abstract List<AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAdjustableOrRelativeDateListDefault extends MapAdjustableOrRelativeDateList {
		@Override
		protected List<AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder> adjustableOrRelativeDateList = new ArrayList<>();
			return assignOutput(adjustableOrRelativeDateList, fpmlDataDocument);
		}
		
		protected List<AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder> assignOutput(List<AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder> adjustableOrRelativeDateList, DataDocument fpmlDataDocument) {
			adjustableOrRelativeDateList.addAll(toBuilder(MapperC.<AdjustableOrRelativeDate>of(MapperS.of(AdjustableOrRelativeDate.builder()
				.setAdjustableDate(mapAdjustableDate.evaluate(fpmlDataDocument))
				.setRelativeDate(mapAdjustedRelativeDateOffset.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(adjustableOrRelativeDateList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
