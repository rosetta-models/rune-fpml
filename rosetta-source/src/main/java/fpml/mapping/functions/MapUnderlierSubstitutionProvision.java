package fpml.mapping.functions;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.master.UnderlierSubstitutionProvision;
import cdm.legaldocumentation.master.UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapUnderlierSubstitutionProvision.MapUnderlierSubstitutionProvisionDefault.class)
public abstract class MapUnderlierSubstitutionProvision implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapClauseList mapClauseList;
	@Inject protected MapExtraordinaryEventsList mapExtraordinaryEventsList;

	/**
	* @param fpmlDataDocument 
	* @return underlierSubstitutionProvision 
	*/
	public UnderlierSubstitutionProvision evaluate(DataDocument fpmlDataDocument) {
		UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder underlierSubstitutionProvisionBuilder = doEvaluate(fpmlDataDocument);
		
		final UnderlierSubstitutionProvision underlierSubstitutionProvision;
		if (underlierSubstitutionProvisionBuilder == null) {
			underlierSubstitutionProvision = null;
		} else {
			underlierSubstitutionProvision = underlierSubstitutionProvisionBuilder.build();
			objectValidator.validate(UnderlierSubstitutionProvision.class, underlierSubstitutionProvision);
		}
		
		return underlierSubstitutionProvision;
	}

	protected abstract UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapUnderlierSubstitutionProvisionDefault extends MapUnderlierSubstitutionProvision {
		@Override
		protected UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder doEvaluate(DataDocument fpmlDataDocument) {
			UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder underlierSubstitutionProvision = UnderlierSubstitutionProvision.builder();
			return assignOutput(underlierSubstitutionProvision, fpmlDataDocument);
		}
		
		protected UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder assignOutput(UnderlierSubstitutionProvision.UnderlierSubstitutionProvisionBuilder underlierSubstitutionProvision, DataDocument fpmlDataDocument) {
			underlierSubstitutionProvision = toBuilder(UnderlierSubstitutionProvision.builder()
				.setWhoMaySubstitute(Collections.<CounterpartyRoleEnum>emptyList())
				.setSubstitutionBeSpokeTerms(new ArrayList(mapClauseList.evaluate(fpmlDataDocument)))
				.setSubstitutionTriggerEvents(new ArrayList(mapExtraordinaryEventsList.evaluate(fpmlDataDocument)))
				.setDisputingParty(null)
				.build());
			
			return Optional.ofNullable(underlierSubstitutionProvision)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
