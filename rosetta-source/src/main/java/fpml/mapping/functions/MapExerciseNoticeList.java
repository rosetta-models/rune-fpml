package fpml.mapping.functions;

import cdm.product.template.ExerciseNotice;
import cdm.product.template.ExerciseNotice.ExerciseNoticeBuilder;
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


@ImplementedBy(MapExerciseNoticeList.MapExerciseNoticeListDefault.class)
public abstract class MapExerciseNoticeList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenterWithScheme mapBusinessCenterWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return exerciseNoticeList 
	*/
	public List<? extends ExerciseNotice> evaluate(DataDocument fpmlDataDocument) {
		List<ExerciseNotice.ExerciseNoticeBuilder> exerciseNoticeListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends ExerciseNotice> exerciseNoticeList;
		if (exerciseNoticeListBuilder == null) {
			exerciseNoticeList = null;
		} else {
			exerciseNoticeList = exerciseNoticeListBuilder.stream().map(ExerciseNotice::build).collect(Collectors.toList());
			objectValidator.validate(ExerciseNotice.class, exerciseNoticeList);
		}
		
		return exerciseNoticeList;
	}

	protected abstract List<ExerciseNotice.ExerciseNoticeBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapExerciseNoticeListDefault extends MapExerciseNoticeList {
		@Override
		protected List<ExerciseNotice.ExerciseNoticeBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<ExerciseNotice.ExerciseNoticeBuilder> exerciseNoticeList = new ArrayList<>();
			return assignOutput(exerciseNoticeList, fpmlDataDocument);
		}
		
		protected List<ExerciseNotice.ExerciseNoticeBuilder> assignOutput(List<ExerciseNotice.ExerciseNoticeBuilder> exerciseNoticeList, DataDocument fpmlDataDocument) {
			exerciseNoticeList.addAll(toBuilder(MapperC.<ExerciseNotice>of(MapperS.of(ExerciseNotice.builder()
				.setExerciseNoticeGiver(null)
				.setExerciseNoticeReceiver(null)
				.setBusinessCenterValue(mapBusinessCenterWithScheme.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(exerciseNoticeList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
