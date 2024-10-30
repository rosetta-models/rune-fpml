package fpml.mapping.functions;

import cdm.product.asset.CashflowRepresentation;
import cdm.product.asset.CashflowRepresentation.CashflowRepresentationBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapCashflowRepresentation.MapCashflowRepresentationDefault.class)
public abstract class MapCashflowRepresentation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPaymentCalculationPeriodList mapPaymentCalculationPeriodList;

	/**
	* @param fpmlDataDocument 
	* @return cashflowRepresentation 
	*/
	public CashflowRepresentation evaluate(DataDocument fpmlDataDocument) {
		CashflowRepresentation.CashflowRepresentationBuilder cashflowRepresentationBuilder = doEvaluate(fpmlDataDocument);
		
		final CashflowRepresentation cashflowRepresentation;
		if (cashflowRepresentationBuilder == null) {
			cashflowRepresentation = null;
		} else {
			cashflowRepresentation = cashflowRepresentationBuilder.build();
			objectValidator.validate(CashflowRepresentation.class, cashflowRepresentation);
		}
		
		return cashflowRepresentation;
	}

	protected abstract CashflowRepresentation.CashflowRepresentationBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCashflowRepresentationDefault extends MapCashflowRepresentation {
		@Override
		protected CashflowRepresentation.CashflowRepresentationBuilder doEvaluate(DataDocument fpmlDataDocument) {
			CashflowRepresentation.CashflowRepresentationBuilder cashflowRepresentation = CashflowRepresentation.builder();
			return assignOutput(cashflowRepresentation, fpmlDataDocument);
		}
		
		protected CashflowRepresentation.CashflowRepresentationBuilder assignOutput(CashflowRepresentation.CashflowRepresentationBuilder cashflowRepresentation, DataDocument fpmlDataDocument) {
			cashflowRepresentation = toBuilder(CashflowRepresentation.builder()
				.setCashflowsMatchParameters(null)
				.setPaymentCalculationPeriod(new ArrayList(mapPaymentCalculationPeriodList.evaluate(fpmlDataDocument)))
				.build());
			
			return Optional.ofNullable(cashflowRepresentation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
