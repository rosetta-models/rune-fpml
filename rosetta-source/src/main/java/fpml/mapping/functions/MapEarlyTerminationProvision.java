package fpml.mapping.functions;

import cdm.product.template.EarlyTerminationProvision;
import cdm.product.template.EarlyTerminationProvision.EarlyTerminationProvisionBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapEarlyTerminationProvision.MapEarlyTerminationProvisionDefault.class)
public abstract class MapEarlyTerminationProvision implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapExercisePeriod mapExercisePeriod;
	@Inject protected MapMandatoryEarlyTermination mapMandatoryEarlyTermination;
	@Inject protected MapOptionalEarlyTermination mapOptionalEarlyTermination;
	@Inject protected MapPeriod mapPeriod;

	/**
	* @param fpmlDataDocument 
	* @return earlyTerminationProvision 
	*/
	public EarlyTerminationProvision evaluate(DataDocument fpmlDataDocument) {
		EarlyTerminationProvision.EarlyTerminationProvisionBuilder earlyTerminationProvisionBuilder = doEvaluate(fpmlDataDocument);
		
		final EarlyTerminationProvision earlyTerminationProvision;
		if (earlyTerminationProvisionBuilder == null) {
			earlyTerminationProvision = null;
		} else {
			earlyTerminationProvision = earlyTerminationProvisionBuilder.build();
			objectValidator.validate(EarlyTerminationProvision.class, earlyTerminationProvision);
		}
		
		return earlyTerminationProvision;
	}

	protected abstract EarlyTerminationProvision.EarlyTerminationProvisionBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapEarlyTerminationProvisionDefault extends MapEarlyTerminationProvision {
		@Override
		protected EarlyTerminationProvision.EarlyTerminationProvisionBuilder doEvaluate(DataDocument fpmlDataDocument) {
			EarlyTerminationProvision.EarlyTerminationProvisionBuilder earlyTerminationProvision = EarlyTerminationProvision.builder();
			return assignOutput(earlyTerminationProvision, fpmlDataDocument);
		}
		
		protected EarlyTerminationProvision.EarlyTerminationProvisionBuilder assignOutput(EarlyTerminationProvision.EarlyTerminationProvisionBuilder earlyTerminationProvision, DataDocument fpmlDataDocument) {
			earlyTerminationProvision = toBuilder(EarlyTerminationProvision.builder()
				.setMandatoryEarlyTermination(mapMandatoryEarlyTermination.evaluate(fpmlDataDocument))
				.setMandatoryEarlyTerminationDateTenor(mapPeriod.evaluate(fpmlDataDocument))
				.setOptionalEarlyTermination(mapOptionalEarlyTermination.evaluate(fpmlDataDocument))
				.setOptionalEarlyTerminationParameters(mapExercisePeriod.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(earlyTerminationProvision)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
