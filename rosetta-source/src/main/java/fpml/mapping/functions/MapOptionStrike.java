package fpml.mapping.functions;

import cdm.product.template.OptionStrike;
import cdm.product.template.OptionStrike.OptionStrikeBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapOptionStrike.MapOptionStrikeDefault.class)
public abstract class MapOptionStrike implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAveragingStrikeFeature mapAveragingStrikeFeature;
	@Inject protected MapFixedRateSpecification mapFixedRateSpecification;
	@Inject protected MapPrice mapPrice;
	@Inject protected MapReferenceSwapCurve mapReferenceSwapCurve;

	/**
	* @param fpmlDataDocument 
	* @return optionStrike 
	*/
	public OptionStrike evaluate(DataDocument fpmlDataDocument) {
		OptionStrike.OptionStrikeBuilder optionStrikeBuilder = doEvaluate(fpmlDataDocument);
		
		final OptionStrike optionStrike;
		if (optionStrikeBuilder == null) {
			optionStrike = null;
		} else {
			optionStrike = optionStrikeBuilder.build();
			objectValidator.validate(OptionStrike.class, optionStrike);
		}
		
		return optionStrike;
	}

	protected abstract OptionStrike.OptionStrikeBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapOptionStrikeDefault extends MapOptionStrike {
		@Override
		protected OptionStrike.OptionStrikeBuilder doEvaluate(DataDocument fpmlDataDocument) {
			OptionStrike.OptionStrikeBuilder optionStrike = OptionStrike.builder();
			return assignOutput(optionStrike, fpmlDataDocument);
		}
		
		protected OptionStrike.OptionStrikeBuilder assignOutput(OptionStrike.OptionStrikeBuilder optionStrike, DataDocument fpmlDataDocument) {
			optionStrike = toBuilder(OptionStrike.builder()
				.setStrikePrice(mapPrice.evaluate(fpmlDataDocument))
				.setStrikeReferenceValue(mapFixedRateSpecification.evaluate(fpmlDataDocument))
				.setReferenceSwapCurve(mapReferenceSwapCurve.evaluate(fpmlDataDocument))
				.setAveragingStrikeFeature(mapAveragingStrikeFeature.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(optionStrike)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
