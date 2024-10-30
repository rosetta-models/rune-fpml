package fpml.mapping.functions;

import cdm.product.template.ConstituentWeight;
import cdm.product.template.ConstituentWeight.ConstituentWeightBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapConstituentWeight.MapConstituentWeightDefault.class)
public abstract class MapConstituentWeight implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return constituentWeight 
	*/
	public ConstituentWeight evaluate(DataDocument fpmlDataDocument) {
		ConstituentWeight.ConstituentWeightBuilder constituentWeightBuilder = doEvaluate(fpmlDataDocument);
		
		final ConstituentWeight constituentWeight;
		if (constituentWeightBuilder == null) {
			constituentWeight = null;
		} else {
			constituentWeight = constituentWeightBuilder.build();
			objectValidator.validate(ConstituentWeight.class, constituentWeight);
		}
		
		return constituentWeight;
	}

	protected abstract ConstituentWeight.ConstituentWeightBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapConstituentWeightDefault extends MapConstituentWeight {
		@Override
		protected ConstituentWeight.ConstituentWeightBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ConstituentWeight.ConstituentWeightBuilder constituentWeight = ConstituentWeight.builder();
			return assignOutput(constituentWeight, fpmlDataDocument);
		}
		
		protected ConstituentWeight.ConstituentWeightBuilder assignOutput(ConstituentWeight.ConstituentWeightBuilder constituentWeight, DataDocument fpmlDataDocument) {
			constituentWeight = toBuilder(ConstituentWeight.builder()
				.setOpenUnits(null)
				.setBasketPercentage(null)
				.build());
			
			return Optional.ofNullable(constituentWeight)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
