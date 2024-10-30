package fpml.mapping.functions;

import cdm.base.datetime.BusinessCenterTime;
import cdm.base.datetime.BusinessCenterTime.BusinessCenterTimeBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapBusinessCenterTime.MapBusinessCenterTimeDefault.class)
public abstract class MapBusinessCenterTime implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenterWithScheme mapBusinessCenterWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return businessCenterTime 
	*/
	public BusinessCenterTime evaluate(DataDocument fpmlDataDocument) {
		BusinessCenterTime.BusinessCenterTimeBuilder businessCenterTimeBuilder = doEvaluate(fpmlDataDocument);
		
		final BusinessCenterTime businessCenterTime;
		if (businessCenterTimeBuilder == null) {
			businessCenterTime = null;
		} else {
			businessCenterTime = businessCenterTimeBuilder.build();
			objectValidator.validate(BusinessCenterTime.class, businessCenterTime);
		}
		
		return businessCenterTime;
	}

	protected abstract BusinessCenterTime.BusinessCenterTimeBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapBusinessCenterTimeDefault extends MapBusinessCenterTime {
		@Override
		protected BusinessCenterTime.BusinessCenterTimeBuilder doEvaluate(DataDocument fpmlDataDocument) {
			BusinessCenterTime.BusinessCenterTimeBuilder businessCenterTime = BusinessCenterTime.builder();
			return assignOutput(businessCenterTime, fpmlDataDocument);
		}
		
		protected BusinessCenterTime.BusinessCenterTimeBuilder assignOutput(BusinessCenterTime.BusinessCenterTimeBuilder businessCenterTime, DataDocument fpmlDataDocument) {
			businessCenterTime = toBuilder(BusinessCenterTime.builder()
				.setHourMinuteTime(null)
				.setBusinessCenterValue(mapBusinessCenterWithScheme.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(businessCenterTime)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
