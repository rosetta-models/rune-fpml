package fpml.mapping.functions;

import cdm.base.datetime.DateList;
import cdm.base.datetime.DateList.DateListBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.DataDocument;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDateList.MapDateListDefault.class)
public abstract class MapDateList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return dateList 
	*/
	public DateList evaluate(DataDocument fpmlDataDocument) {
		DateList.DateListBuilder dateListBuilder = doEvaluate(fpmlDataDocument);
		
		final DateList dateList;
		if (dateListBuilder == null) {
			dateList = null;
		} else {
			dateList = dateListBuilder.build();
			objectValidator.validate(DateList.class, dateList);
		}
		
		return dateList;
	}

	protected abstract DateList.DateListBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapDateListDefault extends MapDateList {
		@Override
		protected DateList.DateListBuilder doEvaluate(DataDocument fpmlDataDocument) {
			DateList.DateListBuilder dateList = DateList.builder();
			return assignOutput(dateList, fpmlDataDocument);
		}
		
		protected DateList.DateListBuilder assignOutput(DateList.DateListBuilder dateList, DataDocument fpmlDataDocument) {
			dateList = toBuilder(DateList.builder()
				.setDate(Collections.<Date>emptyList())
				.build());
			
			return Optional.ofNullable(dateList)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
