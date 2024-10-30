package fpml.mapping.functions;

import cdm.observable.asset.CreditRatingDebt;
import cdm.observable.asset.CreditRatingDebt.CreditRatingDebtBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCreditRatingDebt.MapCreditRatingDebtDefault.class)
public abstract class MapCreditRatingDebt implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDebtTypeWithScheme mapDebtTypeWithScheme;
	@Inject protected MapMultipleDebtTypes mapMultipleDebtTypes;

	/**
	* @param fpmlDataDocument 
	* @return creditRatingDebt 
	*/
	public CreditRatingDebt evaluate(DataDocument fpmlDataDocument) {
		CreditRatingDebt.CreditRatingDebtBuilder creditRatingDebtBuilder = doEvaluate(fpmlDataDocument);
		
		final CreditRatingDebt creditRatingDebt;
		if (creditRatingDebtBuilder == null) {
			creditRatingDebt = null;
		} else {
			creditRatingDebt = creditRatingDebtBuilder.build();
			objectValidator.validate(CreditRatingDebt.class, creditRatingDebt);
		}
		
		return creditRatingDebt;
	}

	protected abstract CreditRatingDebt.CreditRatingDebtBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCreditRatingDebtDefault extends MapCreditRatingDebt {
		@Override
		protected CreditRatingDebt.CreditRatingDebtBuilder doEvaluate(DataDocument fpmlDataDocument) {
			CreditRatingDebt.CreditRatingDebtBuilder creditRatingDebt = CreditRatingDebt.builder();
			return assignOutput(creditRatingDebt, fpmlDataDocument);
		}
		
		protected CreditRatingDebt.CreditRatingDebtBuilder assignOutput(CreditRatingDebt.CreditRatingDebtBuilder creditRatingDebt, DataDocument fpmlDataDocument) {
			creditRatingDebt = toBuilder(CreditRatingDebt.builder()
				.setDebtTypeValue(mapDebtTypeWithScheme.evaluate(fpmlDataDocument))
				.setDebtTypes(mapMultipleDebtTypes.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(creditRatingDebt)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
