package fpml.mapping.functions;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.PartyRoleEnum;
import cdm.legaldocumentation.master.MasterAgreementClauseVariant;
import cdm.legaldocumentation.master.MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder;
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


@ImplementedBy(MapMasterAgreementClauseVariantList.MapMasterAgreementClauseVariantListDefault.class)
public abstract class MapMasterAgreementClauseVariantList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapMasterAgreementVariableSetList mapMasterAgreementVariableSetList;

	/**
	* @param fpmlDataDocument 
	* @return masterAgreementClauseVariantList 
	*/
	public List<? extends MasterAgreementClauseVariant> evaluate(DataDocument fpmlDataDocument) {
		List<MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder> masterAgreementClauseVariantListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends MasterAgreementClauseVariant> masterAgreementClauseVariantList;
		if (masterAgreementClauseVariantListBuilder == null) {
			masterAgreementClauseVariantList = null;
		} else {
			masterAgreementClauseVariantList = masterAgreementClauseVariantListBuilder.stream().map(MasterAgreementClauseVariant::build).collect(Collectors.toList());
			objectValidator.validate(MasterAgreementClauseVariant.class, masterAgreementClauseVariantList);
		}
		
		return masterAgreementClauseVariantList;
	}

	protected abstract List<MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapMasterAgreementClauseVariantListDefault extends MapMasterAgreementClauseVariantList {
		@Override
		protected List<MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder> masterAgreementClauseVariantList = new ArrayList<>();
			return assignOutput(masterAgreementClauseVariantList, fpmlDataDocument);
		}
		
		protected List<MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder> assignOutput(List<MasterAgreementClauseVariant.MasterAgreementClauseVariantBuilder> masterAgreementClauseVariantList, DataDocument fpmlDataDocument) {
			masterAgreementClauseVariantList.addAll(toBuilder(MapperC.<MasterAgreementClauseVariant>of(MapperS.of(MasterAgreementClauseVariant.builder()
				.setIdentifier(null)
				.setName(null)
				.setCounterparty(Collections.<CounterpartyRoleEnum>emptyList())
				.setOtherParty(Collections.<PartyRoleEnum>emptyList())
				.setVariableSet(new ArrayList(mapMasterAgreementVariableSetList.evaluate(fpmlDataDocument)))
				.build())).getMulti()));
			
			return Optional.ofNullable(masterAgreementClauseVariantList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
