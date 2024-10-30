package fpml.mapping.functions;

import cdm.product.common.settlement.CashflowType;
import cdm.product.common.settlement.CashflowType.CashflowTypeBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCashflowType.MapCashflowTypeDefault.class)
public abstract class MapCashflowType implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCashPrice mapCashPrice;

	/**
	* @param fpmlDataDocument 
	* @return cashflowType 
	*/
	public CashflowType evaluate(DataDocument fpmlDataDocument) {
		CashflowType.CashflowTypeBuilder cashflowTypeBuilder = doEvaluate(fpmlDataDocument);
		
		final CashflowType cashflowType;
		if (cashflowTypeBuilder == null) {
			cashflowType = null;
		} else {
			cashflowType = cashflowTypeBuilder.build();
			objectValidator.validate(CashflowType.class, cashflowType);
		}
		
		return cashflowType;
	}

	protected abstract CashflowType.CashflowTypeBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCashflowTypeDefault extends MapCashflowType {
		@Override
		protected CashflowType.CashflowTypeBuilder doEvaluate(DataDocument fpmlDataDocument) {
			CashflowType.CashflowTypeBuilder cashflowType = CashflowType.builder();
			return assignOutput(cashflowType, fpmlDataDocument);
		}
		
		protected CashflowType.CashflowTypeBuilder assignOutput(CashflowType.CashflowTypeBuilder cashflowType, DataDocument fpmlDataDocument) {
			cashflowType = toBuilder(CashflowType.builder()
				.setCashflowType(null)
				.setCashPrice(mapCashPrice.evaluate(fpmlDataDocument))
				.setPriceExpression(null)
				.build());
			
			return Optional.ofNullable(cashflowType)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
