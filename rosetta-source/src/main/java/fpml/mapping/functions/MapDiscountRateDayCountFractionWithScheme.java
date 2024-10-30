package fpml.mapping.functions;

import cdm.base.datetime.daycount.DayCountFractionEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;


@ImplementedBy(MapDiscountRateDayCountFractionWithScheme.MapDiscountRateDayCountFractionWithSchemeDefault.class)
public abstract class MapDiscountRateDayCountFractionWithScheme implements RosettaFunction {

	/**
	* @param fpmlDataDocument 
	* @return dayCountFractionEnum 
	*/
	public DayCountFractionEnum evaluate(DataDocument fpmlDataDocument) {
		DayCountFractionEnum dayCountFractionEnum = doEvaluate(fpmlDataDocument);
		
		return dayCountFractionEnum;
	}

	protected abstract DayCountFractionEnum doEvaluate(DataDocument fpmlDataDocument);

	public static class MapDiscountRateDayCountFractionWithSchemeDefault extends MapDiscountRateDayCountFractionWithScheme {
		@Override
		protected DayCountFractionEnum doEvaluate(DataDocument fpmlDataDocument) {
			DayCountFractionEnum dayCountFractionEnum = null;
			return assignOutput(dayCountFractionEnum, fpmlDataDocument);
		}
		
		protected DayCountFractionEnum assignOutput(DayCountFractionEnum dayCountFractionEnum, DataDocument fpmlDataDocument) {
			dayCountFractionEnum = null;
			
			return dayCountFractionEnum;
		}
	}
}
