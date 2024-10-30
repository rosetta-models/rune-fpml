package fpml.mapping.functions;

import cdm.legaldocumentation.master.MasterAgreementVariableSet;
import cdm.legaldocumentation.master.MasterAgreementVariableSet.MasterAgreementVariableSetBuilder;
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


@ImplementedBy(MapMasterAgreementVariableSetList.MapMasterAgreementVariableSetListDefault.class)
public abstract class MapMasterAgreementVariableSetList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected fpml.mapping.functions.MapMasterAgreementVariableSetList mapMasterAgreementVariableSetList;

	/**
	* @param fpmlDataDocument 
	* @return masterAgreementVariableSetList 
	*/
	public List<? extends MasterAgreementVariableSet> evaluate(DataDocument fpmlDataDocument) {
		List<MasterAgreementVariableSet.MasterAgreementVariableSetBuilder> masterAgreementVariableSetListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends MasterAgreementVariableSet> masterAgreementVariableSetList;
		if (masterAgreementVariableSetListBuilder == null) {
			masterAgreementVariableSetList = null;
		} else {
			masterAgreementVariableSetList = masterAgreementVariableSetListBuilder.stream().map(MasterAgreementVariableSet::build).collect(Collectors.toList());
			objectValidator.validate(MasterAgreementVariableSet.class, masterAgreementVariableSetList);
		}
		
		return masterAgreementVariableSetList;
	}

	protected abstract List<MasterAgreementVariableSet.MasterAgreementVariableSetBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapMasterAgreementVariableSetListDefault extends MapMasterAgreementVariableSetList {
		@Override
		protected List<MasterAgreementVariableSet.MasterAgreementVariableSetBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<MasterAgreementVariableSet.MasterAgreementVariableSetBuilder> masterAgreementVariableSetList = new ArrayList<>();
			return assignOutput(masterAgreementVariableSetList, fpmlDataDocument);
		}
		
		protected List<MasterAgreementVariableSet.MasterAgreementVariableSetBuilder> assignOutput(List<MasterAgreementVariableSet.MasterAgreementVariableSetBuilder> masterAgreementVariableSetList, DataDocument fpmlDataDocument) {
			masterAgreementVariableSetList.addAll(toBuilder(MapperC.<MasterAgreementVariableSet>of(MapperS.of(MasterAgreementVariableSet.builder()
				.setVariableSet(new ArrayList(mapMasterAgreementVariableSetList.evaluate(fpmlDataDocument)))
				.setName(null)
				.setValue(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(masterAgreementVariableSetList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
