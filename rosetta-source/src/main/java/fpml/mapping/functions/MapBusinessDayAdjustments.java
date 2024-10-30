package fpml.mapping.functions;

import cdm.base.datetime.BusinessDayAdjustments;
import cdm.base.datetime.BusinessDayAdjustments.BusinessDayAdjustmentsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapBusinessDayAdjustments.MapBusinessDayAdjustmentsDefault.class)
public abstract class MapBusinessDayAdjustments implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenters mapBusinessCenters;

	/**
	* @param fpmlDataDocument 
	* @return businessDayAdjustments 
	*/
	public BusinessDayAdjustments evaluate(DataDocument fpmlDataDocument) {
		BusinessDayAdjustments.BusinessDayAdjustmentsBuilder businessDayAdjustmentsBuilder = doEvaluate(fpmlDataDocument);
		
		final BusinessDayAdjustments businessDayAdjustments;
		if (businessDayAdjustmentsBuilder == null) {
			businessDayAdjustments = null;
		} else {
			businessDayAdjustments = businessDayAdjustmentsBuilder.build();
			objectValidator.validate(BusinessDayAdjustments.class, businessDayAdjustments);
		}
		
		return businessDayAdjustments;
	}

	protected abstract BusinessDayAdjustments.BusinessDayAdjustmentsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapBusinessDayAdjustmentsDefault extends MapBusinessDayAdjustments {
		@Override
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			BusinessDayAdjustments.BusinessDayAdjustmentsBuilder businessDayAdjustments = BusinessDayAdjustments.builder();
			return assignOutput(businessDayAdjustments, fpmlDataDocument);
		}
		
		protected BusinessDayAdjustments.BusinessDayAdjustmentsBuilder assignOutput(BusinessDayAdjustments.BusinessDayAdjustmentsBuilder businessDayAdjustments, DataDocument fpmlDataDocument) {
			businessDayAdjustments = toBuilder(BusinessDayAdjustments.builder()
				.setBusinessDayConvention(null)
				.setBusinessCenters(mapBusinessCenters.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(businessDayAdjustments)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
