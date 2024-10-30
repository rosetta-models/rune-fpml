package fpml.mapping.functions;

import cdm.base.staticdata.party.NaturalPerson;
import cdm.base.staticdata.party.NaturalPerson.NaturalPersonBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapNaturalPerson.MapNaturalPersonDefault.class)
public abstract class MapNaturalPerson implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapContactInformation mapContactInformation;
	@Inject protected MapPersonIdentifierWithSchemeList mapPersonIdentifierWithSchemeList;

	/**
	* @param fpmlDataDocument 
	* @return naturalPerson 
	*/
	public NaturalPerson evaluate(DataDocument fpmlDataDocument) {
		NaturalPerson.NaturalPersonBuilder naturalPersonBuilder = doEvaluate(fpmlDataDocument);
		
		final NaturalPerson naturalPerson;
		if (naturalPersonBuilder == null) {
			naturalPerson = null;
		} else {
			naturalPerson = naturalPersonBuilder.build();
			objectValidator.validate(NaturalPerson.class, naturalPerson);
		}
		
		return naturalPerson;
	}

	protected abstract NaturalPerson.NaturalPersonBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapNaturalPersonDefault extends MapNaturalPerson {
		@Override
		protected NaturalPerson.NaturalPersonBuilder doEvaluate(DataDocument fpmlDataDocument) {
			NaturalPerson.NaturalPersonBuilder naturalPerson = NaturalPerson.builder();
			return assignOutput(naturalPerson, fpmlDataDocument);
		}
		
		protected NaturalPerson.NaturalPersonBuilder assignOutput(NaturalPerson.NaturalPersonBuilder naturalPerson, DataDocument fpmlDataDocument) {
			naturalPerson = toBuilder(NaturalPerson.builder()
				.setPersonIdValue(new ArrayList(mapPersonIdentifierWithSchemeList.evaluate(fpmlDataDocument)))
				.setHonorific(null)
				.setFirstName(null)
				.setMiddleName(Collections.<String>emptyList())
				.setInitial(Collections.<String>emptyList())
				.setSurname(null)
				.setSuffix(null)
				.setDateOfBirth(null)
				.setContactInformation(mapContactInformation.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(naturalPerson)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
