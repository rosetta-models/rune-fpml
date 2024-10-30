package fpml.mapping.functions;

import cdm.legaldocumentation.common.ContractualDefinitionsEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@ImplementedBy(MapContractualDefinitionsTypeWithSchemeList.MapContractualDefinitionsTypeWithSchemeListDefault.class)
public abstract class MapContractualDefinitionsTypeWithSchemeList implements RosettaFunction {

	/**
	* @param fpmlDataDocument 
	* @return contractualDefinitionsEnumList 
	*/
	public List<ContractualDefinitionsEnum> evaluate(DataDocument fpmlDataDocument) {
		List<ContractualDefinitionsEnum> contractualDefinitionsEnumList = doEvaluate(fpmlDataDocument);
		
		return contractualDefinitionsEnumList;
	}

	protected abstract List<ContractualDefinitionsEnum> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapContractualDefinitionsTypeWithSchemeListDefault extends MapContractualDefinitionsTypeWithSchemeList {
		@Override
		protected List<ContractualDefinitionsEnum> doEvaluate(DataDocument fpmlDataDocument) {
			List<ContractualDefinitionsEnum> contractualDefinitionsEnumList = new ArrayList<>();
			return assignOutput(contractualDefinitionsEnumList, fpmlDataDocument);
		}
		
		protected List<ContractualDefinitionsEnum> assignOutput(List<ContractualDefinitionsEnum> contractualDefinitionsEnumList, DataDocument fpmlDataDocument) {
			contractualDefinitionsEnumList.addAll(Collections.<ContractualDefinitionsEnum>emptyList());
			
			return contractualDefinitionsEnumList;
		}
	}
}
