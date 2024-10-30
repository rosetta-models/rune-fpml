package fpml.mapping.functions;

import cdm.base.staticdata.asset.common.DeliveryDateParameters;
import cdm.base.staticdata.asset.common.DeliveryDateParameters.DeliveryDateParametersBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDeliveryDateParameters.MapDeliveryDateParametersDefault.class)
public abstract class MapDeliveryDateParameters implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableDate mapAdjustableDate;
	@Inject protected MapOffset mapOffset;

	/**
	* @param fpmlDataDocument 
	* @return deliveryDateParameters 
	*/
	public DeliveryDateParameters evaluate(DataDocument fpmlDataDocument) {
		DeliveryDateParameters.DeliveryDateParametersBuilder deliveryDateParametersBuilder = doEvaluate(fpmlDataDocument);
		
		final DeliveryDateParameters deliveryDateParameters;
		if (deliveryDateParametersBuilder == null) {
			deliveryDateParameters = null;
		} else {
			deliveryDateParameters = deliveryDateParametersBuilder.build();
			objectValidator.validate(DeliveryDateParameters.class, deliveryDateParameters);
		}
		
		return deliveryDateParameters;
	}

	protected abstract DeliveryDateParameters.DeliveryDateParametersBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapDeliveryDateParametersDefault extends MapDeliveryDateParameters {
		@Override
		protected DeliveryDateParameters.DeliveryDateParametersBuilder doEvaluate(DataDocument fpmlDataDocument) {
			DeliveryDateParameters.DeliveryDateParametersBuilder deliveryDateParameters = DeliveryDateParameters.builder();
			return assignOutput(deliveryDateParameters, fpmlDataDocument);
		}
		
		protected DeliveryDateParameters.DeliveryDateParametersBuilder assignOutput(DeliveryDateParameters.DeliveryDateParametersBuilder deliveryDateParameters, DataDocument fpmlDataDocument) {
			deliveryDateParameters = toBuilder(DeliveryDateParameters.builder()
				.setDeliveryNearby(mapOffset.evaluate(fpmlDataDocument))
				.setDeliveryDate(mapAdjustableDate.evaluate(fpmlDataDocument))
				.setDeliveryDateRollConvention(mapOffset.evaluate(fpmlDataDocument))
				.setDeliveryDateExpirationConvention(mapOffset.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(deliveryDateParameters)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
