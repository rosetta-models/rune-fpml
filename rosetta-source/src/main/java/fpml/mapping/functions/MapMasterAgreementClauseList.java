package fpml.mapping.functions;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.base.staticdata.party.PartyRoleEnum;
import cdm.legaldocumentation.master.MasterAgreementClause;
import cdm.legaldocumentation.master.MasterAgreementClause.MasterAgreementClauseBuilder;
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


@ImplementedBy(MapMasterAgreementClauseList.MapMasterAgreementClauseListDefault.class)
public abstract class MapMasterAgreementClauseList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapMasterAgreementClauseVariantList mapMasterAgreementClauseVariantList;

	/**
	* @param fpmlDataDocument 
	* @return masterAgreementClauseList 
	*/
	public List<? extends MasterAgreementClause> evaluate(DataDocument fpmlDataDocument) {
		List<MasterAgreementClause.MasterAgreementClauseBuilder> masterAgreementClauseListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends MasterAgreementClause> masterAgreementClauseList;
		if (masterAgreementClauseListBuilder == null) {
			masterAgreementClauseList = null;
		} else {
			masterAgreementClauseList = masterAgreementClauseListBuilder.stream().map(MasterAgreementClause::build).collect(Collectors.toList());
			objectValidator.validate(MasterAgreementClause.class, masterAgreementClauseList);
		}
		
		return masterAgreementClauseList;
	}

	protected abstract List<MasterAgreementClause.MasterAgreementClauseBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapMasterAgreementClauseListDefault extends MapMasterAgreementClauseList {
		@Override
		protected List<MasterAgreementClause.MasterAgreementClauseBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<MasterAgreementClause.MasterAgreementClauseBuilder> masterAgreementClauseList = new ArrayList<>();
			return assignOutput(masterAgreementClauseList, fpmlDataDocument);
		}
		
		protected List<MasterAgreementClause.MasterAgreementClauseBuilder> assignOutput(List<MasterAgreementClause.MasterAgreementClauseBuilder> masterAgreementClauseList, DataDocument fpmlDataDocument) {
			masterAgreementClauseList.addAll(toBuilder(MapperC.<MasterAgreementClause>of(MapperS.of(MasterAgreementClause.builder()
				.setIdentifer(null)
				.setName(null)
				.setCounterparty(Collections.<CounterpartyRoleEnum>emptyList())
				.setOtherParty(Collections.<PartyRoleEnum>emptyList())
				.setVariant(new ArrayList(mapMasterAgreementClauseVariantList.evaluate(fpmlDataDocument)))
				.build())).getMulti()));
			
			return Optional.ofNullable(masterAgreementClauseList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
