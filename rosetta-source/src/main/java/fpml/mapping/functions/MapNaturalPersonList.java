package fpml.mapping.functions;

import cdm.base.staticdata.party.NaturalPerson;
import cdm.base.staticdata.party.NaturalPerson.NaturalPersonBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapNaturalPersonList.MapNaturalPersonListDefault.class)
public abstract class MapNaturalPersonList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapContactInformation mapContactInformation;
	@Inject protected MapPersonIdentifierWithSchemeList mapPersonIdentifierWithSchemeList;

	/**
	* @param fpmlDataDocument 
	* @return naturalPersonList 
	*/
	public List<? extends NaturalPerson> evaluate(DataDocument fpmlDataDocument) {
		List<NaturalPerson.NaturalPersonBuilder> naturalPersonListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends NaturalPerson> naturalPersonList;
		if (naturalPersonListBuilder == null) {
			naturalPersonList = null;
		} else {
			naturalPersonList = naturalPersonListBuilder.stream().map(NaturalPerson::build).collect(Collectors.toList());
			objectValidator.validate(NaturalPerson.class, naturalPersonList);
		}
		
		return naturalPersonList;
	}

	protected abstract List<NaturalPerson.NaturalPersonBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapNaturalPersonListDefault extends MapNaturalPersonList {
		@Override
		protected List<NaturalPerson.NaturalPersonBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<NaturalPerson.NaturalPersonBuilder> naturalPersonList = new ArrayList<>();
			return assignOutput(naturalPersonList, fpmlDataDocument);
		}
		
		protected List<NaturalPerson.NaturalPersonBuilder> assignOutput(List<NaturalPerson.NaturalPersonBuilder> naturalPersonList, DataDocument fpmlDataDocument) {
			naturalPersonList.addAll(toBuilder(MapperC.<NaturalPerson>of(MapperS.of(NaturalPerson.builder()
				.setPersonIdValue(new ArrayList(mapPersonIdentifierWithSchemeList.evaluate(fpmlDataDocument)))
				.setHonorific(null)
				.setFirstName(null)
				.setMiddleName(Collections.<String>emptyList())
				.setInitial(Collections.<String>emptyList())
				.setSurname(null)
				.setSuffix(null)
				.setDateOfBirth(null)
				.setContactInformation(mapContactInformation.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(naturalPersonList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
