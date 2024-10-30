package fpml.mapping.functions;

import cdm.legaldocumentation.master.DeterminationRolesAndTerms;
import cdm.legaldocumentation.master.DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapDeterminationRolesAndTermsList.MapDeterminationRolesAndTermsListDefault.class)
public abstract class MapDeterminationRolesAndTermsList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlDataDocument 
	* @return determinationRolesAndTermsList 
	*/
	public List<? extends DeterminationRolesAndTerms> evaluate(DataDocument fpmlDataDocument) {
		List<DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder> determinationRolesAndTermsListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends DeterminationRolesAndTerms> determinationRolesAndTermsList;
		if (determinationRolesAndTermsListBuilder == null) {
			determinationRolesAndTermsList = null;
		} else {
			determinationRolesAndTermsList = determinationRolesAndTermsListBuilder.stream().map(DeterminationRolesAndTerms::build).collect(Collectors.toList());
			objectValidator.validate(DeterminationRolesAndTerms.class, determinationRolesAndTermsList);
		}
		
		return determinationRolesAndTermsList;
	}

	protected abstract List<DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapDeterminationRolesAndTermsListDefault extends MapDeterminationRolesAndTermsList {
		@Override
		protected List<DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder> determinationRolesAndTermsList = new ArrayList<>();
			return assignOutput(determinationRolesAndTermsList, fpmlDataDocument);
		}
		
		protected List<DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder> assignOutput(List<DeterminationRolesAndTerms.DeterminationRolesAndTermsBuilder> determinationRolesAndTermsList, DataDocument fpmlDataDocument) {
			determinationRolesAndTermsList.addAll(toBuilder(MapperC.<DeterminationRolesAndTerms>of(MapperS.of(DeterminationRolesAndTerms.builder()
				.build())).getMulti()));
			
			return Optional.ofNullable(determinationRolesAndTermsList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
