package fpml.mapping.functions;

import cdm.base.staticdata.party.PayerReceiver;
import cdm.base.staticdata.party.PayerReceiver.PayerReceiverBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapPayerReceiver.MapPayerReceiverDefault.class)
public abstract class MapPayerReceiver implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return payerReceiver 
	*/
	public PayerReceiver evaluate(DataDocument fpmlDataDocument) {
		PayerReceiver.PayerReceiverBuilder payerReceiverBuilder = doEvaluate(fpmlDataDocument);
		
		final PayerReceiver payerReceiver;
		if (payerReceiverBuilder == null) {
			payerReceiver = null;
		} else {
			payerReceiver = payerReceiverBuilder.build();
			objectValidator.validate(PayerReceiver.class, payerReceiver);
		}
		
		return payerReceiver;
	}

	protected abstract PayerReceiver.PayerReceiverBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPayerReceiverDefault extends MapPayerReceiver {
		@Override
		protected PayerReceiver.PayerReceiverBuilder doEvaluate(DataDocument fpmlDataDocument) {
			PayerReceiver.PayerReceiverBuilder payerReceiver = PayerReceiver.builder();
			return assignOutput(payerReceiver, fpmlDataDocument);
		}
		
		protected PayerReceiver.PayerReceiverBuilder assignOutput(PayerReceiver.PayerReceiverBuilder payerReceiver, DataDocument fpmlDataDocument) {
			payerReceiver = toBuilder(PayerReceiver.builder()
				.setPayer(null)
				.setReceiver(null)
				.build());
			
			return Optional.ofNullable(payerReceiver)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
