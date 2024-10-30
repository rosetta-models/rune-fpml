package fpml.mapping.functions;

import cdm.base.datetime.DateRange;
import cdm.base.datetime.DateRange.DateRangeBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDateRange.MapDateRangeDefault.class)
public abstract class MapDateRange implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return dateRange 
	*/
	public DateRange evaluate(DataDocument fpmlDataDocument) {
		DateRange.DateRangeBuilder dateRangeBuilder = doEvaluate(fpmlDataDocument);
		
		final DateRange dateRange;
		if (dateRangeBuilder == null) {
			dateRange = null;
		} else {
			dateRange = dateRangeBuilder.build();
			objectValidator.validate(DateRange.class, dateRange);
		}
		
		return dateRange;
	}

	protected abstract DateRange.DateRangeBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapDateRangeDefault extends MapDateRange {
		@Override
		protected DateRange.DateRangeBuilder doEvaluate(DataDocument fpmlDataDocument) {
			DateRange.DateRangeBuilder dateRange = DateRange.builder();
			return assignOutput(dateRange, fpmlDataDocument);
		}
		
		protected DateRange.DateRangeBuilder assignOutput(DateRange.DateRangeBuilder dateRange, DataDocument fpmlDataDocument) {
			dateRange = toBuilder(DateRange.builder()
				.setStartDate(null)
				.setEndDate(null)
				.build());
			
			return Optional.ofNullable(dateRange)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
