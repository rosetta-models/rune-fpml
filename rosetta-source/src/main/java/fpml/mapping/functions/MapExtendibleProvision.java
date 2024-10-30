package fpml.mapping.functions;

import cdm.product.template.ExtendibleProvision;
import cdm.product.template.ExtendibleProvision.ExtendibleProvisionBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapExtendibleProvision.MapExtendibleProvisionDefault.class)
public abstract class MapExtendibleProvision implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableRelativeOrPeriodicDates mapAdjustableRelativeOrPeriodicDates;
	@Inject protected MapExerciseNotice mapExerciseNotice;
	@Inject protected MapExerciseTerms mapExerciseTerms;
	@Inject protected MapExtendibleProvisionAdjustedDates mapExtendibleProvisionAdjustedDates;
	@Inject protected MapPartyRole mapPartyRole;
	@Inject protected MapRelativeDateOffset mapRelativeDateOffset;

	/**
	* @param fpmlDataDocument 
	* @return extendibleProvision 
	*/
	public ExtendibleProvision evaluate(DataDocument fpmlDataDocument) {
		ExtendibleProvision.ExtendibleProvisionBuilder extendibleProvisionBuilder = doEvaluate(fpmlDataDocument);
		
		final ExtendibleProvision extendibleProvision;
		if (extendibleProvisionBuilder == null) {
			extendibleProvision = null;
		} else {
			extendibleProvision = extendibleProvisionBuilder.build();
			objectValidator.validate(ExtendibleProvision.class, extendibleProvision);
		}
		
		return extendibleProvision;
	}

	protected abstract ExtendibleProvision.ExtendibleProvisionBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapExtendibleProvisionDefault extends MapExtendibleProvision {
		@Override
		protected ExtendibleProvision.ExtendibleProvisionBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ExtendibleProvision.ExtendibleProvisionBuilder extendibleProvision = ExtendibleProvision.builder();
			return assignOutput(extendibleProvision, fpmlDataDocument);
		}
		
		protected ExtendibleProvision.ExtendibleProvisionBuilder assignOutput(ExtendibleProvision.ExtendibleProvisionBuilder extendibleProvision, DataDocument fpmlDataDocument) {
			extendibleProvision = toBuilder(ExtendibleProvision.builder()
				.setBuyer(null)
				.setSeller(null)
				.setExerciseNotice(mapExerciseNotice.evaluate(fpmlDataDocument))
				.setFollowUpConfirmation(null)
				.setExtendibleProvisionAdjustedDates(mapExtendibleProvisionAdjustedDates.evaluate(fpmlDataDocument))
				.setCallingParty(null)
				.setSinglePartyOption(mapPartyRole.evaluate(fpmlDataDocument))
				.setNoticeDeadlinePeriod(mapRelativeDateOffset.evaluate(fpmlDataDocument))
				.setNoticeDeadlineDateTime(null)
				.setExtensionTerm(mapRelativeDateOffset.evaluate(fpmlDataDocument))
				.setExtensionPeriod(mapAdjustableRelativeOrPeriodicDates.evaluate(fpmlDataDocument))
				.setExerciseTerms(mapExerciseTerms.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(extendibleProvision)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
