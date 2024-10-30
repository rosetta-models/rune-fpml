package fpml.mapping.functions;

import cdm.product.asset.InterestShortFall;
import cdm.product.asset.InterestShortFall.InterestShortFallBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapInterestShortFall.MapInterestShortFallDefault.class)
public abstract class MapInterestShortFall implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapRateSourceWithScheme mapRateSourceWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return interestShortFall 
	*/
	public InterestShortFall evaluate(DataDocument fpmlDataDocument) {
		InterestShortFall.InterestShortFallBuilder interestShortFallBuilder = doEvaluate(fpmlDataDocument);
		
		final InterestShortFall interestShortFall;
		if (interestShortFallBuilder == null) {
			interestShortFall = null;
		} else {
			interestShortFall = interestShortFallBuilder.build();
			objectValidator.validate(InterestShortFall.class, interestShortFall);
		}
		
		return interestShortFall;
	}

	protected abstract InterestShortFall.InterestShortFallBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapInterestShortFallDefault extends MapInterestShortFall {
		@Override
		protected InterestShortFall.InterestShortFallBuilder doEvaluate(DataDocument fpmlDataDocument) {
			InterestShortFall.InterestShortFallBuilder interestShortFall = InterestShortFall.builder();
			return assignOutput(interestShortFall, fpmlDataDocument);
		}
		
		protected InterestShortFall.InterestShortFallBuilder assignOutput(InterestShortFall.InterestShortFallBuilder interestShortFall, DataDocument fpmlDataDocument) {
			interestShortFall = toBuilder(InterestShortFall.builder()
				.setInterestShortfallCap(null)
				.setCompounding(null)
				.setRateSourceValue(mapRateSourceWithScheme.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(interestShortFall)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
