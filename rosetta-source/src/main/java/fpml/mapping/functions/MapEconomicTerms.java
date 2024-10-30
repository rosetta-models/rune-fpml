package fpml.mapping.functions;

import cdm.product.template.EconomicTerms;
import cdm.product.template.EconomicTerms.EconomicTermsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapEconomicTerms.MapEconomicTermsDefault.class)
public abstract class MapEconomicTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAdjustableOrRelativeDate mapAdjustableOrRelativeDate;
	@Inject protected MapBusinessDayAdjustments mapBusinessDayAdjustments;
	@Inject protected MapCalculationAgent mapCalculationAgent;
	@Inject protected MapCollateral mapCollateral;
	@Inject protected MapPayout mapPayout;
	@Inject protected MapTerminationProvision mapTerminationProvision;

	/**
	* @param fpmlDataDocument 
	* @return economicTerms 
	*/
	public EconomicTerms evaluate(DataDocument fpmlDataDocument) {
		EconomicTerms.EconomicTermsBuilder economicTermsBuilder = doEvaluate(fpmlDataDocument);
		
		final EconomicTerms economicTerms;
		if (economicTermsBuilder == null) {
			economicTerms = null;
		} else {
			economicTerms = economicTermsBuilder.build();
			objectValidator.validate(EconomicTerms.class, economicTerms);
		}
		
		return economicTerms;
	}

	protected abstract EconomicTerms.EconomicTermsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapEconomicTermsDefault extends MapEconomicTerms {
		@Override
		protected EconomicTerms.EconomicTermsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			EconomicTerms.EconomicTermsBuilder economicTerms = EconomicTerms.builder();
			return assignOutput(economicTerms, fpmlDataDocument);
		}
		
		protected EconomicTerms.EconomicTermsBuilder assignOutput(EconomicTerms.EconomicTermsBuilder economicTerms, DataDocument fpmlDataDocument) {
			economicTerms = toBuilder(EconomicTerms.builder()
				.setEffectiveDate(mapAdjustableOrRelativeDate.evaluate(fpmlDataDocument))
				.setTerminationDate(mapAdjustableOrRelativeDate.evaluate(fpmlDataDocument))
				.setDateAdjustments(mapBusinessDayAdjustments.evaluate(fpmlDataDocument))
				.setPayout(mapPayout.evaluate(fpmlDataDocument))
				.setTerminationProvision(mapTerminationProvision.evaluate(fpmlDataDocument))
				.setCalculationAgent(mapCalculationAgent.evaluate(fpmlDataDocument))
				.setNonStandardisedTerms(null)
				.setCollateral(mapCollateral.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(economicTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
