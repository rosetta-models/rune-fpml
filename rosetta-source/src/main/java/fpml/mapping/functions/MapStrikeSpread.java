package fpml.mapping.functions;

import cdm.product.template.StrikeSpread;
import cdm.product.template.StrikeSpread.StrikeSpreadBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapStrikeSpread.MapStrikeSpreadDefault.class)
public abstract class MapStrikeSpread implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapOptionStrike mapOptionStrike;

	/**
	* @param fpmlDataDocument 
	* @return strikeSpread 
	*/
	public StrikeSpread evaluate(DataDocument fpmlDataDocument) {
		StrikeSpread.StrikeSpreadBuilder strikeSpreadBuilder = doEvaluate(fpmlDataDocument);
		
		final StrikeSpread strikeSpread;
		if (strikeSpreadBuilder == null) {
			strikeSpread = null;
		} else {
			strikeSpread = strikeSpreadBuilder.build();
			objectValidator.validate(StrikeSpread.class, strikeSpread);
		}
		
		return strikeSpread;
	}

	protected abstract StrikeSpread.StrikeSpreadBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapStrikeSpreadDefault extends MapStrikeSpread {
		@Override
		protected StrikeSpread.StrikeSpreadBuilder doEvaluate(DataDocument fpmlDataDocument) {
			StrikeSpread.StrikeSpreadBuilder strikeSpread = StrikeSpread.builder();
			return assignOutput(strikeSpread, fpmlDataDocument);
		}
		
		protected StrikeSpread.StrikeSpreadBuilder assignOutput(StrikeSpread.StrikeSpreadBuilder strikeSpread, DataDocument fpmlDataDocument) {
			strikeSpread = toBuilder(StrikeSpread.builder()
				.setUpperStrike(mapOptionStrike.evaluate(fpmlDataDocument))
				.setUpperStrikeNumberOfOptions(null)
				.build());
			
			return Optional.ofNullable(strikeSpread)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
