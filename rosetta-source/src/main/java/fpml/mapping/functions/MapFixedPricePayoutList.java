package fpml.mapping.functions;

import cdm.product.template.FixedPricePayout;
import cdm.product.template.FixedPricePayout.FixedPricePayoutBuilder;
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


@ImplementedBy(MapFixedPricePayoutList.MapFixedPricePayoutListDefault.class)
public abstract class MapFixedPricePayoutList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCalculationSchedule mapCalculationSchedule;
	@Inject protected MapFixedPrice mapFixedPrice;
	@Inject protected MapPayerReceiver mapPayerReceiver;
	@Inject protected MapPaymentDates mapPaymentDates;
	@Inject protected MapPrincipalPayments mapPrincipalPayments;
	@Inject protected MapResolvablePriceQuantity mapResolvablePriceQuantity;
	@Inject protected MapSettlementTerms mapSettlementTerms;

	/**
	* @param fpmlDataDocument 
	* @return fixedPricePayoutList 
	*/
	public List<? extends FixedPricePayout> evaluate(DataDocument fpmlDataDocument) {
		List<FixedPricePayout.FixedPricePayoutBuilder> fixedPricePayoutListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends FixedPricePayout> fixedPricePayoutList;
		if (fixedPricePayoutListBuilder == null) {
			fixedPricePayoutList = null;
		} else {
			fixedPricePayoutList = fixedPricePayoutListBuilder.stream().map(FixedPricePayout::build).collect(Collectors.toList());
			objectValidator.validate(FixedPricePayout.class, fixedPricePayoutList);
		}
		
		return fixedPricePayoutList;
	}

	protected abstract List<FixedPricePayout.FixedPricePayoutBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapFixedPricePayoutListDefault extends MapFixedPricePayoutList {
		@Override
		protected List<FixedPricePayout.FixedPricePayoutBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<FixedPricePayout.FixedPricePayoutBuilder> fixedPricePayoutList = new ArrayList<>();
			return assignOutput(fixedPricePayoutList, fpmlDataDocument);
		}
		
		protected List<FixedPricePayout.FixedPricePayoutBuilder> assignOutput(List<FixedPricePayout.FixedPricePayoutBuilder> fixedPricePayoutList, DataDocument fpmlDataDocument) {
			fixedPricePayoutList.addAll(toBuilder(MapperC.<FixedPricePayout>of(MapperS.of(FixedPricePayout.builder()
				.setPayerReceiver(mapPayerReceiver.evaluate(fpmlDataDocument))
				.setPriceQuantity(mapResolvablePriceQuantity.evaluate(fpmlDataDocument))
				.setPrincipalPayment(mapPrincipalPayments.evaluate(fpmlDataDocument))
				.setSettlementTerms(mapSettlementTerms.evaluate(fpmlDataDocument))
				.setPaymentDates(mapPaymentDates.evaluate(fpmlDataDocument))
				.setFixedPrice(mapFixedPrice.evaluate(fpmlDataDocument))
				.setSchedule(mapCalculationSchedule.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(fixedPricePayoutList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
