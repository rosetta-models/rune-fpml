package fpml.mapping.functions;

import cdm.base.staticdata.party.ContactInformation;
import cdm.base.staticdata.party.ContactInformation.ContactInformationBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapContactInformation.MapContactInformationDefault.class)
public abstract class MapContactInformation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAddressList mapAddressList;
	@Inject protected MapTelephoneNumberList mapTelephoneNumberList;

	/**
	* @param fpmlDataDocument 
	* @return contactInformation 
	*/
	public ContactInformation evaluate(DataDocument fpmlDataDocument) {
		ContactInformation.ContactInformationBuilder contactInformationBuilder = doEvaluate(fpmlDataDocument);
		
		final ContactInformation contactInformation;
		if (contactInformationBuilder == null) {
			contactInformation = null;
		} else {
			contactInformation = contactInformationBuilder.build();
			objectValidator.validate(ContactInformation.class, contactInformation);
		}
		
		return contactInformation;
	}

	protected abstract ContactInformation.ContactInformationBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapContactInformationDefault extends MapContactInformation {
		@Override
		protected ContactInformation.ContactInformationBuilder doEvaluate(DataDocument fpmlDataDocument) {
			ContactInformation.ContactInformationBuilder contactInformation = ContactInformation.builder();
			return assignOutput(contactInformation, fpmlDataDocument);
		}
		
		protected ContactInformation.ContactInformationBuilder assignOutput(ContactInformation.ContactInformationBuilder contactInformation, DataDocument fpmlDataDocument) {
			contactInformation = toBuilder(ContactInformation.builder()
				.setTelephone(new ArrayList(mapTelephoneNumberList.evaluate(fpmlDataDocument)))
				.setAddress(new ArrayList(mapAddressList.evaluate(fpmlDataDocument)))
				.setEmail(Collections.<String>emptyList())
				.setWebPage(Collections.<String>emptyList())
				.build());
			
			return Optional.ofNullable(contactInformation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
