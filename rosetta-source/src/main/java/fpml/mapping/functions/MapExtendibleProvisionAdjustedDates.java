package fpml.mapping.functions;

import cdm.product.template.ExtendibleProvisionAdjustedDates;
import cdm.product.template.ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapExtendibleProvisionAdjustedDates.MapExtendibleProvisionAdjustedDatesDefault.class)
public abstract class MapExtendibleProvisionAdjustedDates implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapExtensionEventList mapExtensionEventList;

	/**
	* @param fpmlDataDocument 
	* @return extendibleProvisionAdjustedDates 
	*/
	public ExtendibleProvisionAdjustedDates evaluate(DataDocument fpmlDataDocument) {
		ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder extendibleProvisionAdjustedDatesBuilder = doEvaluate(fpmlDataDocument);
		
		final ExtendibleProvisionAdjustedDates extendibleProvisionAdjustedDates;
		if (extendibleProvisionAdjustedDatesBuilder == null) {
			extendibleProvisionAdjustedDates = null;
		} else {
			extendibleProvisionAdjustedDates = extendibleProvisionAdjustedDatesBuilder.build();
			objectValidator.validate(ExtendibleProvisionAdjustedDates.class, extendibleProvisionAdjustedDates);
		}
		
		return extendibleProvisionAdjustedDates;
	}

	protected abstract ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapExtendibleProvisionAdjustedDatesDefault extends MapExtendibleProvisionAdjustedDates {
		@Override
		protected ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder extendibleProvisionAdjustedDates = ExtendibleProvisionAdjustedDates.builder();
			return assignOutput(extendibleProvisionAdjustedDates, fpmlDataDocument);
		}
		
		protected ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder assignOutput(ExtendibleProvisionAdjustedDates.ExtendibleProvisionAdjustedDatesBuilder extendibleProvisionAdjustedDates, DataDocument fpmlDataDocument) {
			extendibleProvisionAdjustedDates = toBuilder(ExtendibleProvisionAdjustedDates.builder()
				.setExtensionEvent(new ArrayList(mapExtensionEventList.evaluate(fpmlDataDocument)))
				.build());
			
			return Optional.ofNullable(extendibleProvisionAdjustedDates)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
