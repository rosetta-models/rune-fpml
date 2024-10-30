package fpml.mapping.functions;

import cdm.observable.asset.CashCollateralValuationMethod;
import cdm.observable.asset.CashCollateralValuationMethod.CashCollateralValuationMethodBuilder;
import cdm.observable.asset.PartyDeterminationEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCashCollateralValuationMethod.MapCashCollateralValuationMethodDefault.class)
public abstract class MapCashCollateralValuationMethod implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAgreedDiscountRateWithScheme mapAgreedDiscountRateWithScheme;
	@Inject protected MapCashCollateralInterestRateWithScheme mapCashCollateralInterestRateWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return cashCollateralValuationMethod 
	*/
	public CashCollateralValuationMethod evaluate(DataDocument fpmlDataDocument) {
		CashCollateralValuationMethod.CashCollateralValuationMethodBuilder cashCollateralValuationMethodBuilder = doEvaluate(fpmlDataDocument);
		
		final CashCollateralValuationMethod cashCollateralValuationMethod;
		if (cashCollateralValuationMethodBuilder == null) {
			cashCollateralValuationMethod = null;
		} else {
			cashCollateralValuationMethod = cashCollateralValuationMethodBuilder.build();
			objectValidator.validate(CashCollateralValuationMethod.class, cashCollateralValuationMethod);
		}
		
		return cashCollateralValuationMethod;
	}

	protected abstract CashCollateralValuationMethod.CashCollateralValuationMethodBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCashCollateralValuationMethodDefault extends MapCashCollateralValuationMethod {
		@Override
		protected CashCollateralValuationMethod.CashCollateralValuationMethodBuilder doEvaluate(DataDocument fpmlDataDocument) {
			CashCollateralValuationMethod.CashCollateralValuationMethodBuilder cashCollateralValuationMethod = CashCollateralValuationMethod.builder();
			return assignOutput(cashCollateralValuationMethod, fpmlDataDocument);
		}
		
		protected CashCollateralValuationMethod.CashCollateralValuationMethodBuilder assignOutput(CashCollateralValuationMethod.CashCollateralValuationMethodBuilder cashCollateralValuationMethod, DataDocument fpmlDataDocument) {
			cashCollateralValuationMethod = toBuilder(CashCollateralValuationMethod.builder()
				.setApplicableCsa(null)
				.setCashCollateralCurrency(null)
				.setCashCollateralInterestRateValue(mapCashCollateralInterestRateWithScheme.evaluate(fpmlDataDocument))
				.setAgreedDiscountRateValue(mapAgreedDiscountRateWithScheme.evaluate(fpmlDataDocument))
				.setProtectedParty(Collections.<PartyDeterminationEnum>emptyList())
				.setPrescribedDocumentationAdjustment(null)
				.build());
			
			return Optional.ofNullable(cashCollateralValuationMethod)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
