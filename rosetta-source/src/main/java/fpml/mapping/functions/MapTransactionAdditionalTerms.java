package fpml.mapping.functions;

import cdm.legaldocumentation.master.TransactionAdditionalTerms;
import cdm.legaldocumentation.master.TransactionAdditionalTerms.TransactionAdditionalTermsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapTransactionAdditionalTerms.MapTransactionAdditionalTermsDefault.class)
public abstract class MapTransactionAdditionalTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapEquityAdditionalTerms mapEquityAdditionalTerms;
	@Inject protected MapFxAdditionalTerms mapFxAdditionalTerms;

	/**
	* @param fpmlDataDocument 
	* @return transactionAdditionalTerms 
	*/
	public TransactionAdditionalTerms evaluate(DataDocument fpmlDataDocument) {
		TransactionAdditionalTerms.TransactionAdditionalTermsBuilder transactionAdditionalTermsBuilder = doEvaluate(fpmlDataDocument);
		
		final TransactionAdditionalTerms transactionAdditionalTerms;
		if (transactionAdditionalTermsBuilder == null) {
			transactionAdditionalTerms = null;
		} else {
			transactionAdditionalTerms = transactionAdditionalTermsBuilder.build();
			objectValidator.validate(TransactionAdditionalTerms.class, transactionAdditionalTerms);
		}
		
		return transactionAdditionalTerms;
	}

	protected abstract TransactionAdditionalTerms.TransactionAdditionalTermsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapTransactionAdditionalTermsDefault extends MapTransactionAdditionalTerms {
		@Override
		protected TransactionAdditionalTerms.TransactionAdditionalTermsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			TransactionAdditionalTerms.TransactionAdditionalTermsBuilder transactionAdditionalTerms = TransactionAdditionalTerms.builder();
			return assignOutput(transactionAdditionalTerms, fpmlDataDocument);
		}
		
		protected TransactionAdditionalTerms.TransactionAdditionalTermsBuilder assignOutput(TransactionAdditionalTerms.TransactionAdditionalTermsBuilder transactionAdditionalTerms, DataDocument fpmlDataDocument) {
			transactionAdditionalTerms = toBuilder(TransactionAdditionalTerms.builder()
				.setEquityAdditionalTerms(mapEquityAdditionalTerms.evaluate(fpmlDataDocument))
				.setForeignExchangeAdditionalTerms(mapFxAdditionalTerms.evaluate(fpmlDataDocument))
				.setCommoditiesAdditionalTerms(null)
				.setCreditAdditionalTerms(null)
				.setInterestRateAdditionalTerms(null)
				.setDigitalAssetAdditionalTerms(null)
				.build());
			
			return Optional.ofNullable(transactionAdditionalTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
