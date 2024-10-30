package fpml.mapping.functions;

import cdm.base.staticdata.party.NaturalPersonRoleEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@ImplementedBy(MapRoleWithSchemeList.MapRoleWithSchemeListDefault.class)
public abstract class MapRoleWithSchemeList implements RosettaFunction {

	/**
	* @param fpmlDataDocument 
	* @return naturalPersonRoleEnumList 
	*/
	public List<NaturalPersonRoleEnum> evaluate(DataDocument fpmlDataDocument) {
		List<NaturalPersonRoleEnum> naturalPersonRoleEnumList = doEvaluate(fpmlDataDocument);
		
		return naturalPersonRoleEnumList;
	}

	protected abstract List<NaturalPersonRoleEnum> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapRoleWithSchemeListDefault extends MapRoleWithSchemeList {
		@Override
		protected List<NaturalPersonRoleEnum> doEvaluate(DataDocument fpmlDataDocument) {
			List<NaturalPersonRoleEnum> naturalPersonRoleEnumList = new ArrayList<>();
			return assignOutput(naturalPersonRoleEnumList, fpmlDataDocument);
		}
		
		protected List<NaturalPersonRoleEnum> assignOutput(List<NaturalPersonRoleEnum> naturalPersonRoleEnumList, DataDocument fpmlDataDocument) {
			naturalPersonRoleEnumList.addAll(Collections.<NaturalPersonRoleEnum>emptyList());
			
			return naturalPersonRoleEnumList;
		}
	}
}
