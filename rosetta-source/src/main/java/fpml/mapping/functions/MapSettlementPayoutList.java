package fpml.mapping.functions;

import cdm.product.template.SettlementPayout;
import cdm.product.template.SettlementPayout.SettlementPayoutBuilder;
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


@ImplementedBy(MapSettlementPayoutList.MapSettlementPayoutListDefault.class)
public abstract class MapSettlementPayoutList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetDeliveryInformation mapAssetDeliveryInformation;
	@Inject protected MapCalculationSchedule mapCalculationSchedule;
	@Inject protected MapPayerReceiver mapPayerReceiver;
	@Inject protected MapPrincipalPayments mapPrincipalPayments;
	@Inject protected MapResolvablePriceQuantity mapResolvablePriceQuantity;
	@Inject protected MapSettlementTerms mapSettlementTerms;
	@Inject protected MapUnderlier mapUnderlier;

	/**
	* @param fpmlDataDocument 
	* @return settlementPayoutList 
	*/
	public List<? extends SettlementPayout> evaluate(DataDocument fpmlDataDocument) {
		List<SettlementPayout.SettlementPayoutBuilder> settlementPayoutListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends SettlementPayout> settlementPayoutList;
		if (settlementPayoutListBuilder == null) {
			settlementPayoutList = null;
		} else {
			settlementPayoutList = settlementPayoutListBuilder.stream().map(SettlementPayout::build).collect(Collectors.toList());
			objectValidator.validate(SettlementPayout.class, settlementPayoutList);
		}
		
		return settlementPayoutList;
	}

	protected abstract List<SettlementPayout.SettlementPayoutBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapSettlementPayoutListDefault extends MapSettlementPayoutList {
		@Override
		protected List<SettlementPayout.SettlementPayoutBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<SettlementPayout.SettlementPayoutBuilder> settlementPayoutList = new ArrayList<>();
			return assignOutput(settlementPayoutList, fpmlDataDocument);
		}
		
		protected List<SettlementPayout.SettlementPayoutBuilder> assignOutput(List<SettlementPayout.SettlementPayoutBuilder> settlementPayoutList, DataDocument fpmlDataDocument) {
			settlementPayoutList.addAll(toBuilder(MapperC.<SettlementPayout>of(MapperS.of(SettlementPayout.builder()
				.setPayerReceiver(mapPayerReceiver.evaluate(fpmlDataDocument))
				.setPriceQuantity(mapResolvablePriceQuantity.evaluate(fpmlDataDocument))
				.setPrincipalPayment(mapPrincipalPayments.evaluate(fpmlDataDocument))
				.setSettlementTerms(mapSettlementTerms.evaluate(fpmlDataDocument))
				.setUnderlier(mapUnderlier.evaluate(fpmlDataDocument))
				.setDeliveryTerm(null)
				.setDelivery(mapAssetDeliveryInformation.evaluate(fpmlDataDocument))
				.setSchedule(mapCalculationSchedule.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(settlementPayoutList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
