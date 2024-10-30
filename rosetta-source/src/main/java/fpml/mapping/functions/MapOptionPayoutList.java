package fpml.mapping.functions;

import cdm.product.template.OptionPayout;
import cdm.product.template.OptionPayout.OptionPayoutBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapOptionPayoutList.MapOptionPayoutListDefault.class)
public abstract class MapOptionPayoutList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetDeliveryInformation mapAssetDeliveryInformation;
	@Inject protected MapBuyerSeller mapBuyerSeller;
	@Inject protected MapCalculationSchedule mapCalculationSchedule;
	@Inject protected MapExerciseTerms mapExerciseTerms;
	@Inject protected MapObservationTerms mapObservationTerms;
	@Inject protected MapOptionFeature mapOptionFeature;
	@Inject protected MapOptionStrike mapOptionStrike;
	@Inject protected MapPayerReceiver mapPayerReceiver;
	@Inject protected MapPrincipalPayments mapPrincipalPayments;
	@Inject protected MapResolvablePriceQuantity mapResolvablePriceQuantity;
	@Inject protected MapSettlementTerms mapSettlementTerms;
	@Inject protected MapUnderlier mapUnderlier;

	/**
	* @param fpmlDataDocument 
	* @return optionPayoutList 
	*/
	public List<? extends OptionPayout> evaluate(DataDocument fpmlDataDocument) {
		List<OptionPayout.OptionPayoutBuilder> optionPayoutListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends OptionPayout> optionPayoutList;
		if (optionPayoutListBuilder == null) {
			optionPayoutList = null;
		} else {
			optionPayoutList = optionPayoutListBuilder.stream().map(OptionPayout::build).collect(Collectors.toList());
			objectValidator.validate(OptionPayout.class, optionPayoutList);
		}
		
		return optionPayoutList;
	}

	protected abstract List<OptionPayout.OptionPayoutBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapOptionPayoutListDefault extends MapOptionPayoutList {
		@Override
		protected List<OptionPayout.OptionPayoutBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<OptionPayout.OptionPayoutBuilder> optionPayoutList = new ArrayList<>();
			return assignOutput(optionPayoutList, fpmlDataDocument);
		}
		
		protected List<OptionPayout.OptionPayoutBuilder> assignOutput(List<OptionPayout.OptionPayoutBuilder> optionPayoutList, DataDocument fpmlDataDocument) {
			optionPayoutList.addAll(toBuilder(MapperC.<OptionPayout>of(MapperS.of(OptionPayout.builder()
				.setPayerReceiver(mapPayerReceiver.evaluate(fpmlDataDocument))
				.setPriceQuantity(mapResolvablePriceQuantity.evaluate(fpmlDataDocument))
				.setPrincipalPayment(mapPrincipalPayments.evaluate(fpmlDataDocument))
				.setSettlementTerms(mapSettlementTerms.evaluate(fpmlDataDocument))
				.setBuyerSeller(mapBuyerSeller.evaluate(fpmlDataDocument))
				.setFeature(mapOptionFeature.evaluate(fpmlDataDocument))
				.setObservationTerms(mapObservationTerms.evaluate(fpmlDataDocument))
				.setSchedule(mapCalculationSchedule.evaluate(fpmlDataDocument))
				.setDelivery(mapAssetDeliveryInformation.evaluate(fpmlDataDocument))
				.setUnderlier(mapUnderlier.evaluate(fpmlDataDocument))
				.setOptionType(null)
				.setExerciseTerms(mapExerciseTerms.evaluate(fpmlDataDocument))
				.setStrike(mapOptionStrike.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(optionPayoutList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
