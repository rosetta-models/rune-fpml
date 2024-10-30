package fpml.mapping.functions;

import cdm.observable.asset.MultipleValuationDates;
import cdm.observable.asset.MultipleValuationDates.MultipleValuationDatesBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapMultipleValuationDates.MapMultipleValuationDatesDefault.class)
public abstract class MapMultipleValuationDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return multipleValuationDates 
	*/
	public MultipleValuationDates evaluate(DataDocument fpmlDataDocument) {
		MultipleValuationDates.MultipleValuationDatesBuilder multipleValuationDatesBuilder = doEvaluate(fpmlDataDocument);
		
		final MultipleValuationDates multipleValuationDates;
		if (multipleValuationDatesBuilder == null) {
			multipleValuationDates = null;
		} else {
			multipleValuationDates = multipleValuationDatesBuilder.build();
			objectValidator.validate(MultipleValuationDates.class, multipleValuationDates);
		}
		
		return multipleValuationDates;
	}

	protected abstract MultipleValuationDates.MultipleValuationDatesBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapMultipleValuationDatesDefault extends MapMultipleValuationDates {
		@Override
		protected MultipleValuationDates.MultipleValuationDatesBuilder doEvaluate(DataDocument fpmlDataDocument) {
			MultipleValuationDates.MultipleValuationDatesBuilder multipleValuationDates = MultipleValuationDates.builder();
			return assignOutput(multipleValuationDates, fpmlDataDocument);
		}
		
		protected MultipleValuationDates.MultipleValuationDatesBuilder assignOutput(MultipleValuationDates.MultipleValuationDatesBuilder multipleValuationDates, DataDocument fpmlDataDocument) {
			multipleValuationDates = toBuilder(MultipleValuationDates.builder()
				.setBusinessDays(null)
				.setBusinessDaysThereafter(null)
				.setNumberValuationDates(null)
				.build());
			
			return Optional.ofNullable(multipleValuationDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
