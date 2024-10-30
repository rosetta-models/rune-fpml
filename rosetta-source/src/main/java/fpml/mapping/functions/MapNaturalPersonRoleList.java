package fpml.mapping.functions;

import cdm.base.staticdata.party.NaturalPersonRole;
import cdm.base.staticdata.party.NaturalPersonRole.NaturalPersonRoleBuilder;
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


@ImplementedBy(MapNaturalPersonRoleList.MapNaturalPersonRoleListDefault.class)
public abstract class MapNaturalPersonRoleList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapNaturalPerson mapNaturalPerson;
	@Inject protected MapRoleWithSchemeList mapRoleWithSchemeList;

	/**
	* @param fpmlDataDocument 
	* @return naturalPersonRoleList 
	*/
	public List<? extends NaturalPersonRole> evaluate(DataDocument fpmlDataDocument) {
		List<NaturalPersonRole.NaturalPersonRoleBuilder> naturalPersonRoleListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends NaturalPersonRole> naturalPersonRoleList;
		if (naturalPersonRoleListBuilder == null) {
			naturalPersonRoleList = null;
		} else {
			naturalPersonRoleList = naturalPersonRoleListBuilder.stream().map(NaturalPersonRole::build).collect(Collectors.toList());
			objectValidator.validate(NaturalPersonRole.class, naturalPersonRoleList);
		}
		
		return naturalPersonRoleList;
	}

	protected abstract List<NaturalPersonRole.NaturalPersonRoleBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapNaturalPersonRoleListDefault extends MapNaturalPersonRoleList {
		@Override
		protected List<NaturalPersonRole.NaturalPersonRoleBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<NaturalPersonRole.NaturalPersonRoleBuilder> naturalPersonRoleList = new ArrayList<>();
			return assignOutput(naturalPersonRoleList, fpmlDataDocument);
		}
		
		protected List<NaturalPersonRole.NaturalPersonRoleBuilder> assignOutput(List<NaturalPersonRole.NaturalPersonRoleBuilder> naturalPersonRoleList, DataDocument fpmlDataDocument) {
			naturalPersonRoleList.addAll(toBuilder(MapperC.<NaturalPersonRole>of(MapperS.of(NaturalPersonRole.builder()
				.setPersonReferenceValue(mapNaturalPerson.evaluate(fpmlDataDocument))
				.setRoleValue(mapRoleWithSchemeList.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(naturalPersonRoleList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
