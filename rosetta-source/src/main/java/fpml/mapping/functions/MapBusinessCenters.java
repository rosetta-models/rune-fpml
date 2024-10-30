package fpml.mapping.functions;

import cdm.base.datetime.BusinessCenters;
import cdm.base.datetime.BusinessCenters.BusinessCentersBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapBusinessCenters.MapBusinessCentersDefault.class)
public abstract class MapBusinessCenters implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBusinessCenterWithSchemeList mapBusinessCenterWithSchemeList;
	@Inject protected fpml.mapping.functions.MapBusinessCenters mapBusinessCenters;
	@Inject protected MapCommodityBusinessCalendarWithSchemeList mapCommodityBusinessCalendarWithSchemeList;

	/**
	* @param fpmlDataDocument 
	* @return businessCenters 
	*/
	public BusinessCenters evaluate(DataDocument fpmlDataDocument) {
		BusinessCenters.BusinessCentersBuilder businessCentersBuilder = doEvaluate(fpmlDataDocument);
		
		final BusinessCenters businessCenters;
		if (businessCentersBuilder == null) {
			businessCenters = null;
		} else {
			businessCenters = businessCentersBuilder.build();
			objectValidator.validate(BusinessCenters.class, businessCenters);
		}
		
		return businessCenters;
	}

	protected abstract BusinessCenters.BusinessCentersBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapBusinessCentersDefault extends MapBusinessCenters {
		@Override
		protected BusinessCenters.BusinessCentersBuilder doEvaluate(DataDocument fpmlDataDocument) {
			BusinessCenters.BusinessCentersBuilder businessCenters = BusinessCenters.builder();
			return assignOutput(businessCenters, fpmlDataDocument);
		}
		
		protected BusinessCenters.BusinessCentersBuilder assignOutput(BusinessCenters.BusinessCentersBuilder businessCenters, DataDocument fpmlDataDocument) {
			businessCenters = toBuilder(BusinessCenters.builder()
				.setBusinessCenterValue(mapBusinessCenterWithSchemeList.evaluate(fpmlDataDocument))
				.setCommodityBusinessCalendarValue(mapCommodityBusinessCalendarWithSchemeList.evaluate(fpmlDataDocument))
				.setBusinessCentersReferenceValue(mapBusinessCenters.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(businessCenters)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
