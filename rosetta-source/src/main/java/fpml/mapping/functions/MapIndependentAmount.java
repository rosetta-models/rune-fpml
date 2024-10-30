package fpml.mapping.functions;

import cdm.product.collateral.IndependentAmount;
import cdm.product.collateral.IndependentAmount.IndependentAmountBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapIndependentAmount.MapIndependentAmountDefault.class)
public abstract class MapIndependentAmount implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAccount mapAccount;
	@Inject protected MapParty mapParty;
	@Inject protected MapPaymentDetailList mapPaymentDetailList;

	/**
	* @param fpmlDataDocument 
	* @return independentAmount 
	*/
	public IndependentAmount evaluate(DataDocument fpmlDataDocument) {
		IndependentAmount.IndependentAmountBuilder independentAmountBuilder = doEvaluate(fpmlDataDocument);
		
		final IndependentAmount independentAmount;
		if (independentAmountBuilder == null) {
			independentAmount = null;
		} else {
			independentAmount = independentAmountBuilder.build();
			objectValidator.validate(IndependentAmount.class, independentAmount);
		}
		
		return independentAmount;
	}

	protected abstract IndependentAmount.IndependentAmountBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapIndependentAmountDefault extends MapIndependentAmount {
		@Override
		protected IndependentAmount.IndependentAmountBuilder doEvaluate(DataDocument fpmlDataDocument) {
			IndependentAmount.IndependentAmountBuilder independentAmount = IndependentAmount.builder();
			return assignOutput(independentAmount, fpmlDataDocument);
		}
		
		protected IndependentAmount.IndependentAmountBuilder assignOutput(IndependentAmount.IndependentAmountBuilder independentAmount, DataDocument fpmlDataDocument) {
			independentAmount = toBuilder(IndependentAmount.builder()
				.setPayerPartyReferenceValue(mapParty.evaluate(fpmlDataDocument))
				.setPayerAccountReferenceValue(mapAccount.evaluate(fpmlDataDocument))
				.setReceiverPartyReferenceValue(mapParty.evaluate(fpmlDataDocument))
				.setReceiverAccountReferenceValue(mapAccount.evaluate(fpmlDataDocument))
				.setPaymentDetail(new ArrayList(mapPaymentDetailList.evaluate(fpmlDataDocument)))
				.build());
			
			return Optional.ofNullable(independentAmount)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
