package fpml.mapping.functions;

import cdm.observable.asset.DividendApplicability;
import cdm.observable.asset.DividendApplicability.DividendApplicabilityBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapDividendApplicability.MapDividendApplicabilityDefault.class)
public abstract class MapDividendApplicability implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return dividendApplicability 
	*/
	public DividendApplicability evaluate(DataDocument fpmlDataDocument) {
		DividendApplicability.DividendApplicabilityBuilder dividendApplicabilityBuilder = doEvaluate(fpmlDataDocument);
		
		final DividendApplicability dividendApplicability;
		if (dividendApplicabilityBuilder == null) {
			dividendApplicability = null;
		} else {
			dividendApplicability = dividendApplicabilityBuilder.build();
			objectValidator.validate(DividendApplicability.class, dividendApplicability);
		}
		
		return dividendApplicability;
	}

	protected abstract DividendApplicability.DividendApplicabilityBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapDividendApplicabilityDefault extends MapDividendApplicability {
		@Override
		protected DividendApplicability.DividendApplicabilityBuilder doEvaluate(DataDocument fpmlDataDocument) {
			DividendApplicability.DividendApplicabilityBuilder dividendApplicability = DividendApplicability.builder();
			return assignOutput(dividendApplicability, fpmlDataDocument);
		}
		
		protected DividendApplicability.DividendApplicabilityBuilder assignOutput(DividendApplicability.DividendApplicabilityBuilder dividendApplicability, DataDocument fpmlDataDocument) {
			dividendApplicability = toBuilder(DividendApplicability.builder()
				.setOptionsExchangeDividends(null)
				.setAdditionalDividends(null)
				.setAllDividends(null)
				.build());
			
			return Optional.ofNullable(dividendApplicability)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
