package fpml.mapping.functions;

import cdm.product.common.settlement.ShapingProvision;
import cdm.product.common.settlement.ShapingProvision.ShapingProvisionBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapShapingProvision.MapShapingProvisionDefault.class)
public abstract class MapShapingProvision implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapMoneyList mapMoneyList;

	/**
	* @param fpmlDataDocument 
	* @return shapingProvision 
	*/
	public ShapingProvision evaluate(DataDocument fpmlDataDocument) {
		ShapingProvision.ShapingProvisionBuilder shapingProvisionBuilder = doEvaluate(fpmlDataDocument);
		
		final ShapingProvision shapingProvision;
		if (shapingProvisionBuilder == null) {
			shapingProvision = null;
		} else {
			shapingProvision = shapingProvisionBuilder.build();
			objectValidator.validate(ShapingProvision.class, shapingProvision);
		}
		
		return shapingProvision;
	}

	protected abstract ShapingProvision.ShapingProvisionBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapShapingProvisionDefault extends MapShapingProvision {
		@Override
		protected ShapingProvision.ShapingProvisionBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ShapingProvision.ShapingProvisionBuilder shapingProvision = ShapingProvision.builder();
			return assignOutput(shapingProvision, fpmlDataDocument);
		}
		
		protected ShapingProvision.ShapingProvisionBuilder assignOutput(ShapingProvision.ShapingProvisionBuilder shapingProvision, DataDocument fpmlDataDocument) {
			shapingProvision = toBuilder(ShapingProvision.builder()
				.setShapeSchedule(new ArrayList(mapMoneyList.evaluate(fpmlDataDocument)))
				.build());
			
			return Optional.ofNullable(shapingProvision)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
