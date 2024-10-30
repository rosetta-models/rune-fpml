package fpml.mapping.functions;

import cdm.product.template.DividendTerms;
import cdm.product.template.DividendTerms.DividendTermsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDividendTerms.MapDividendTermsDefault.class)
public abstract class MapDividendTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDividendPayoutRatio mapDividendPayoutRatio;
	@Inject protected MapMoney mapMoney;

	/**
	* @param fpmlDataDocument 
	* @return dividendTerms 
	*/
	public DividendTerms evaluate(DataDocument fpmlDataDocument) {
		DividendTerms.DividendTermsBuilder dividendTermsBuilder = doEvaluate(fpmlDataDocument);
		
		final DividendTerms dividendTerms;
		if (dividendTermsBuilder == null) {
			dividendTerms = null;
		} else {
			dividendTerms = dividendTermsBuilder.build();
			objectValidator.validate(DividendTerms.class, dividendTerms);
		}
		
		return dividendTerms;
	}

	protected abstract DividendTerms.DividendTermsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapDividendTermsDefault extends MapDividendTerms {
		@Override
		protected DividendTerms.DividendTermsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			DividendTerms.DividendTermsBuilder dividendTerms = DividendTerms.builder();
			return assignOutput(dividendTerms, fpmlDataDocument);
		}
		
		protected DividendTerms.DividendTermsBuilder assignOutput(DividendTerms.DividendTermsBuilder dividendTerms, DataDocument fpmlDataDocument) {
			dividendTerms = toBuilder(DividendTerms.builder()
				.setManufacturedIncomeRequirement(mapDividendPayoutRatio.evaluate(fpmlDataDocument))
				.setDividendEntitlement(null)
				.setMinimumBillingAmount(mapMoney.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(dividendTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
