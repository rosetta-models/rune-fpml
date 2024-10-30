package fpml.mapping.functions;

import cdm.base.staticdata.party.PersonIdentifier;
import cdm.base.staticdata.party.PersonIdentifier.PersonIdentifierBuilder;
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


@ImplementedBy(MapPersonIdentifierWithSchemeList.MapPersonIdentifierWithSchemeListDefault.class)
public abstract class MapPersonIdentifierWithSchemeList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCountryWithScheme mapCountryWithScheme;
	@Inject protected MapIdentifierWithScheme mapIdentifierWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return personIdentifierList 
	*/
	public List<? extends PersonIdentifier> evaluate(DataDocument fpmlDataDocument) {
		List<PersonIdentifier.PersonIdentifierBuilder> personIdentifierListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends PersonIdentifier> personIdentifierList;
		if (personIdentifierListBuilder == null) {
			personIdentifierList = null;
		} else {
			personIdentifierList = personIdentifierListBuilder.stream().map(PersonIdentifier::build).collect(Collectors.toList());
			objectValidator.validate(PersonIdentifier.class, personIdentifierList);
		}
		
		return personIdentifierList;
	}

	protected abstract List<PersonIdentifier.PersonIdentifierBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPersonIdentifierWithSchemeListDefault extends MapPersonIdentifierWithSchemeList {
		@Override
		protected List<PersonIdentifier.PersonIdentifierBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<PersonIdentifier.PersonIdentifierBuilder> personIdentifierList = new ArrayList<>();
			return assignOutput(personIdentifierList, fpmlDataDocument);
		}
		
		protected List<PersonIdentifier.PersonIdentifierBuilder> assignOutput(List<PersonIdentifier.PersonIdentifierBuilder> personIdentifierList, DataDocument fpmlDataDocument) {
			personIdentifierList.addAll(toBuilder(MapperC.<PersonIdentifier>of(MapperS.of(PersonIdentifier.builder()
				.setIdentifierValue(mapIdentifierWithScheme.evaluate(fpmlDataDocument))
				.setIdentifierType(null)
				.setCountryValue(mapCountryWithScheme.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(personIdentifierList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
