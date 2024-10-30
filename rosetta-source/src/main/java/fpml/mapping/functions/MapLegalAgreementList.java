package fpml.mapping.functions;

import cdm.legaldocumentation.common.LegalAgreement;
import cdm.legaldocumentation.common.LegalAgreement.LegalAgreementBuilder;
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


@ImplementedBy(MapLegalAgreementList.MapLegalAgreementListDefault.class)
public abstract class MapLegalAgreementList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAgreementTerms mapAgreementTerms;
	@Inject protected MapIdentifierList mapIdentifierList;
	@Inject protected MapLegalAgreementIdentification mapLegalAgreementIdentification;
	@Inject protected fpml.mapping.functions.MapLegalAgreementList mapLegalAgreementList;
	@Inject protected MapPartyList mapPartyList;
	@Inject protected MapPartyRoleList mapPartyRoleList;
	@Inject protected MapResourceList mapResourceList;
	@Inject protected MapUmbrellaAgreement mapUmbrellaAgreement;

	/**
	* @param fpmlDataDocument 
	* @return legalAgreementList 
	*/
	public List<? extends LegalAgreement> evaluate(DataDocument fpmlDataDocument) {
		List<LegalAgreement.LegalAgreementBuilder> legalAgreementListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends LegalAgreement> legalAgreementList;
		if (legalAgreementListBuilder == null) {
			legalAgreementList = null;
		} else {
			legalAgreementList = legalAgreementListBuilder.stream().map(LegalAgreement::build).collect(Collectors.toList());
			objectValidator.validate(LegalAgreement.class, legalAgreementList);
		}
		
		return legalAgreementList;
	}

	protected abstract List<LegalAgreement.LegalAgreementBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapLegalAgreementListDefault extends MapLegalAgreementList {
		@Override
		protected List<LegalAgreement.LegalAgreementBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<LegalAgreement.LegalAgreementBuilder> legalAgreementList = new ArrayList<>();
			return assignOutput(legalAgreementList, fpmlDataDocument);
		}
		
		protected List<LegalAgreement.LegalAgreementBuilder> assignOutput(List<LegalAgreement.LegalAgreementBuilder> legalAgreementList, DataDocument fpmlDataDocument) {
			legalAgreementList.addAll(toBuilder(MapperC.<LegalAgreement>of(MapperS.of(LegalAgreement.builder()
				.setAgreementDate(null)
				.setEffectiveDate(null)
				.setIdentifier(new ArrayList(mapIdentifierList.evaluate(fpmlDataDocument)))
				.setLegalAgreementIdentification(mapLegalAgreementIdentification.evaluate(fpmlDataDocument))
				.setContractualPartyValue(new ArrayList(mapPartyList.evaluate(fpmlDataDocument)))
				.setOtherParty(new ArrayList(mapPartyRoleList.evaluate(fpmlDataDocument)))
				.setAttachment(new ArrayList(mapResourceList.evaluate(fpmlDataDocument)))
				.setAgreementTerms(mapAgreementTerms.evaluate(fpmlDataDocument))
				.setRelatedAgreements(new ArrayList(mapLegalAgreementList.evaluate(fpmlDataDocument)))
				.setUmbrellaAgreement(mapUmbrellaAgreement.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(legalAgreementList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
