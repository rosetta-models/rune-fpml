package fpml.mapping.functions;

import cdm.product.common.schedule.PaymentCalculationPeriod;
import cdm.product.common.schedule.PaymentCalculationPeriod.PaymentCalculationPeriodBuilder;
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


@ImplementedBy(MapPaymentCalculationPeriodList.MapPaymentCalculationPeriodListDefault.class)
public abstract class MapPaymentCalculationPeriodList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCalculationPeriodList mapCalculationPeriodList;
	@Inject protected MapMoney mapMoney;

	/**
	* @param fpmlDataDocument 
	* @return paymentCalculationPeriodList 
	*/
	public List<? extends PaymentCalculationPeriod> evaluate(DataDocument fpmlDataDocument) {
		List<PaymentCalculationPeriod.PaymentCalculationPeriodBuilder> paymentCalculationPeriodListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends PaymentCalculationPeriod> paymentCalculationPeriodList;
		if (paymentCalculationPeriodListBuilder == null) {
			paymentCalculationPeriodList = null;
		} else {
			paymentCalculationPeriodList = paymentCalculationPeriodListBuilder.stream().map(PaymentCalculationPeriod::build).collect(Collectors.toList());
			objectValidator.validate(PaymentCalculationPeriod.class, paymentCalculationPeriodList);
		}
		
		return paymentCalculationPeriodList;
	}

	protected abstract List<PaymentCalculationPeriod.PaymentCalculationPeriodBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPaymentCalculationPeriodListDefault extends MapPaymentCalculationPeriodList {
		@Override
		protected List<PaymentCalculationPeriod.PaymentCalculationPeriodBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<PaymentCalculationPeriod.PaymentCalculationPeriodBuilder> paymentCalculationPeriodList = new ArrayList<>();
			return assignOutput(paymentCalculationPeriodList, fpmlDataDocument);
		}
		
		protected List<PaymentCalculationPeriod.PaymentCalculationPeriodBuilder> assignOutput(List<PaymentCalculationPeriod.PaymentCalculationPeriodBuilder> paymentCalculationPeriodList, DataDocument fpmlDataDocument) {
			paymentCalculationPeriodList.addAll(toBuilder(MapperC.<PaymentCalculationPeriod>of(MapperS.of(PaymentCalculationPeriod.builder()
				.setUnadjustedPaymentDate(null)
				.setAdjustedPaymentDate(null)
				.setCalculationPeriod(new ArrayList(mapCalculationPeriodList.evaluate(fpmlDataDocument)))
				.setFixedPaymentAmount(mapMoney.evaluate(fpmlDataDocument))
				.setDiscountFactor(null)
				.setForecastPaymentAmount(mapMoney.evaluate(fpmlDataDocument))
				.setPresentValueAmount(mapMoney.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(paymentCalculationPeriodList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
