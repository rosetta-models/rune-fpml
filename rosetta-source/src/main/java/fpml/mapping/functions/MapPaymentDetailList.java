package fpml.mapping.functions;

import cdm.product.common.settlement.PaymentDetail;
import cdm.product.common.settlement.PaymentDetail.PaymentDetailBuilder;
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


@ImplementedBy(MapPaymentDetailList.MapPaymentDetailListDefault.class)
public abstract class MapPaymentDetailList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapMoney mapMoney;
	@Inject protected MapPaymentRule mapPaymentRule;

	/**
	* @param fpmlDataDocument 
	* @return paymentDetailList 
	*/
	public List<? extends PaymentDetail> evaluate(DataDocument fpmlDataDocument) {
		List<PaymentDetail.PaymentDetailBuilder> paymentDetailListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends PaymentDetail> paymentDetailList;
		if (paymentDetailListBuilder == null) {
			paymentDetailList = null;
		} else {
			paymentDetailList = paymentDetailListBuilder.stream().map(PaymentDetail::build).collect(Collectors.toList());
			objectValidator.validate(PaymentDetail.class, paymentDetailList);
		}
		
		return paymentDetailList;
	}

	protected abstract List<PaymentDetail.PaymentDetailBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPaymentDetailListDefault extends MapPaymentDetailList {
		@Override
		protected List<PaymentDetail.PaymentDetailBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<PaymentDetail.PaymentDetailBuilder> paymentDetailList = new ArrayList<>();
			return assignOutput(paymentDetailList, fpmlDataDocument);
		}
		
		protected List<PaymentDetail.PaymentDetailBuilder> assignOutput(List<PaymentDetail.PaymentDetailBuilder> paymentDetailList, DataDocument fpmlDataDocument) {
			paymentDetailList.addAll(toBuilder(MapperC.<PaymentDetail>of(MapperS.of(PaymentDetail.builder()
				.setPaymentDate(mapAdjustableOrRelativeDate.evaluate(fpmlDataDocument))
				.setPaymentRule(mapPaymentRule.evaluate(fpmlDataDocument))
				.setPaymentAmount(mapMoney.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(paymentDetailList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
