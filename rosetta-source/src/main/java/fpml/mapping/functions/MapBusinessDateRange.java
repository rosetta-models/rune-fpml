package fpml.mapping.functions;

import cdm.base.datetime.BusinessDateRange;
import cdm.base.datetime.BusinessDateRange.BusinessDateRangeBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapBusinessDateRange.MapBusinessDateRangeDefault.class)
public abstract class MapBusinessDateRange implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenters mapBusinessCenters;

	/**
	* @param fpmlDataDocument 
	* @return businessDateRange 
	*/
	public BusinessDateRange evaluate(DataDocument fpmlDataDocument) {
		BusinessDateRange.BusinessDateRangeBuilder businessDateRangeBuilder = doEvaluate(fpmlDataDocument);
		
		final BusinessDateRange businessDateRange;
		if (businessDateRangeBuilder == null) {
			businessDateRange = null;
		} else {
			businessDateRange = businessDateRangeBuilder.build();
			objectValidator.validate(BusinessDateRange.class, businessDateRange);
		}
		
		return businessDateRange;
	}

	protected abstract BusinessDateRange.BusinessDateRangeBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapBusinessDateRangeDefault extends MapBusinessDateRange {
		@Override
		protected BusinessDateRange.BusinessDateRangeBuilder doEvaluate(DataDocument fpmlDataDocument) {
			BusinessDateRange.BusinessDateRangeBuilder businessDateRange = BusinessDateRange.builder();
			return assignOutput(businessDateRange, fpmlDataDocument);
		}
		
		protected BusinessDateRange.BusinessDateRangeBuilder assignOutput(BusinessDateRange.BusinessDateRangeBuilder businessDateRange, DataDocument fpmlDataDocument) {
			businessDateRange = toBuilder(BusinessDateRange.builder()
				.setStartDate(null)
				.setEndDate(null)
				.setBusinessDayConvention(null)
				.setBusinessCenters(mapBusinessCenters.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(businessDateRange)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
