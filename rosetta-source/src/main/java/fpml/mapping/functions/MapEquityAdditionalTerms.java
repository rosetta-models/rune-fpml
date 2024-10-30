package fpml.mapping.functions;

import cdm.legaldocumentation.master.EquityAdditionalTerms;
import cdm.legaldocumentation.master.EquityAdditionalTerms.EquityAdditionalTermsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapEquityAdditionalTerms.MapEquityAdditionalTermsDefault.class)
public abstract class MapEquityAdditionalTerms implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDeterminationRolesAndTermsList mapDeterminationRolesAndTermsList;
	@Inject protected MapExtraordinaryEvents mapExtraordinaryEvents;
	@Inject protected MapUnderlierSubstitutionProvision mapUnderlierSubstitutionProvision;

	/**
	* @param fpmlDataDocument 
	* @return equityAdditionalTerms 
	*/
	public EquityAdditionalTerms evaluate(DataDocument fpmlDataDocument) {
		EquityAdditionalTerms.EquityAdditionalTermsBuilder equityAdditionalTermsBuilder = doEvaluate(fpmlDataDocument);
		
		final EquityAdditionalTerms equityAdditionalTerms;
		if (equityAdditionalTermsBuilder == null) {
			equityAdditionalTerms = null;
		} else {
			equityAdditionalTerms = equityAdditionalTermsBuilder.build();
			objectValidator.validate(EquityAdditionalTerms.class, equityAdditionalTerms);
		}
		
		return equityAdditionalTerms;
	}

	protected abstract EquityAdditionalTerms.EquityAdditionalTermsBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapEquityAdditionalTermsDefault extends MapEquityAdditionalTerms {
		@Override
		protected EquityAdditionalTerms.EquityAdditionalTermsBuilder doEvaluate(DataDocument fpmlDataDocument) {
			EquityAdditionalTerms.EquityAdditionalTermsBuilder equityAdditionalTerms = EquityAdditionalTerms.builder();
			return assignOutput(equityAdditionalTerms, fpmlDataDocument);
		}
		
		protected EquityAdditionalTerms.EquityAdditionalTermsBuilder assignOutput(EquityAdditionalTerms.EquityAdditionalTermsBuilder equityAdditionalTerms, DataDocument fpmlDataDocument) {
			equityAdditionalTerms = toBuilder(EquityAdditionalTerms.builder()
				.setExtraordinaryEvents(mapExtraordinaryEvents.evaluate(fpmlDataDocument))
				.setDeterminationTerms(new ArrayList(mapDeterminationRolesAndTermsList.evaluate(fpmlDataDocument)))
				.setSubstitutionProvision(mapUnderlierSubstitutionProvision.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(equityAdditionalTerms)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
