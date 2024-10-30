package fpml.mapping.functions;

import cdm.product.template.CancelableProvision;
import cdm.product.template.CancelableProvision.CancelableProvisionBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCancelableProvision.MapCancelableProvisionDefault.class)
public abstract class MapCancelableProvision implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapAdjustableOrRelativeDates mapAdjustableOrRelativeDates;
	@Inject protected MapBusinessCenterTime mapBusinessCenterTime;
	@Inject protected MapCancelableProvisionAdjustedDates mapCancelableProvisionAdjustedDates;
	@Inject protected MapExerciseNotice mapExerciseNotice;
	@Inject protected MapExerciseTerms mapExerciseTerms;
	@Inject protected MapFinalCalculationPeriodDateAdjustmentList mapFinalCalculationPeriodDateAdjustmentList;
	@Inject protected MapPeriod mapPeriod;
	@Inject protected MapTransfer mapTransfer;

	/**
	* @param fpmlDataDocument 
	* @return cancelableProvision 
	*/
	public CancelableProvision evaluate(DataDocument fpmlDataDocument) {
		CancelableProvision.CancelableProvisionBuilder cancelableProvisionBuilder = doEvaluate(fpmlDataDocument);
		
		final CancelableProvision cancelableProvision;
		if (cancelableProvisionBuilder == null) {
			cancelableProvision = null;
		} else {
			cancelableProvision = cancelableProvisionBuilder.build();
			objectValidator.validate(CancelableProvision.class, cancelableProvision);
		}
		
		return cancelableProvision;
	}

	protected abstract CancelableProvision.CancelableProvisionBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCancelableProvisionDefault extends MapCancelableProvision {
		@Override
		protected CancelableProvision.CancelableProvisionBuilder doEvaluate(DataDocument fpmlDataDocument) {
			CancelableProvision.CancelableProvisionBuilder cancelableProvision = CancelableProvision.builder();
			return assignOutput(cancelableProvision, fpmlDataDocument);
		}
		
		protected CancelableProvision.CancelableProvisionBuilder assignOutput(CancelableProvision.CancelableProvisionBuilder cancelableProvision, DataDocument fpmlDataDocument) {
			cancelableProvision = toBuilder(CancelableProvision.builder()
				.setBuyer(null)
				.setSeller(null)
				.setExerciseNotice(mapExerciseNotice.evaluate(fpmlDataDocument))
				.setFollowUpConfirmation(null)
				.setCancelableProvisionAdjustedDates(mapCancelableProvisionAdjustedDates.evaluate(fpmlDataDocument))
				.setFinalCalculationPeriodDateAdjustment(new ArrayList(mapFinalCalculationPeriodDateAdjustmentList.evaluate(fpmlDataDocument)))
				.setInitialFee(mapTransfer.evaluate(fpmlDataDocument))
				.setCallingParty(null)
				.setEarliestDate(mapAdjustableOrRelativeDate.evaluate(fpmlDataDocument))
				.setExpirationDate(mapAdjustableOrRelativeDate.evaluate(fpmlDataDocument))
				.setEffectiveDate(mapAdjustableOrRelativeDates.evaluate(fpmlDataDocument))
				.setEffectivePeriod(mapPeriod.evaluate(fpmlDataDocument))
				.setEarliestCancellationTime(mapBusinessCenterTime.evaluate(fpmlDataDocument))
				.setLatestCancelationTime(mapBusinessCenterTime.evaluate(fpmlDataDocument))
				.setExerciseTerms(mapExerciseTerms.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(cancelableProvision)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
