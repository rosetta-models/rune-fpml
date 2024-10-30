package fpml.mapping.functions;

import cdm.product.asset.DividendPaymentDate;
import cdm.product.asset.DividendPaymentDate.DividendPaymentDateBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDividendPaymentDate.MapDividendPaymentDateDefault.class)
public abstract class MapDividendPaymentDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapDividendDateReference mapDividendDateReference;

	/**
	* @param fpmlDataDocument 
	* @return dividendPaymentDate 
	*/
	public DividendPaymentDate evaluate(DataDocument fpmlDataDocument) {
		DividendPaymentDate.DividendPaymentDateBuilder dividendPaymentDateBuilder = doEvaluate(fpmlDataDocument);
		
		final DividendPaymentDate dividendPaymentDate;
		if (dividendPaymentDateBuilder == null) {
			dividendPaymentDate = null;
		} else {
			dividendPaymentDate = dividendPaymentDateBuilder.build();
			objectValidator.validate(DividendPaymentDate.class, dividendPaymentDate);
		}
		
		return dividendPaymentDate;
	}

	protected abstract DividendPaymentDate.DividendPaymentDateBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapDividendPaymentDateDefault extends MapDividendPaymentDate {
		@Override
		protected DividendPaymentDate.DividendPaymentDateBuilder doEvaluate(DataDocument fpmlDataDocument) {
			DividendPaymentDate.DividendPaymentDateBuilder dividendPaymentDate = DividendPaymentDate.builder();
			return assignOutput(dividendPaymentDate, fpmlDataDocument);
		}
		
		protected DividendPaymentDate.DividendPaymentDateBuilder assignOutput(DividendPaymentDate.DividendPaymentDateBuilder dividendPaymentDate, DataDocument fpmlDataDocument) {
			dividendPaymentDate = toBuilder(DividendPaymentDate.builder()
				.setDividendDateReference(mapDividendDateReference.evaluate(fpmlDataDocument))
				.setDividendDateValue(mapAdjustableOrRelativeDate.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(dividendPaymentDate)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
