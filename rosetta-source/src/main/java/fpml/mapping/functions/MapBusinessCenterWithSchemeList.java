package fpml.mapping.functions;

import cdm.base.datetime.BusinessCenterEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@ImplementedBy(MapBusinessCenterWithSchemeList.MapBusinessCenterWithSchemeListDefault.class)
public abstract class MapBusinessCenterWithSchemeList implements RosettaFunction {

	/**
	* @param fpmlDataDocument 
	* @return businessCenterEnumList 
	*/
	public List<BusinessCenterEnum> evaluate(DataDocument fpmlDataDocument) {
		List<BusinessCenterEnum> businessCenterEnumList = doEvaluate(fpmlDataDocument);
		
		return businessCenterEnumList;
	}

	protected abstract List<BusinessCenterEnum> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapBusinessCenterWithSchemeListDefault extends MapBusinessCenterWithSchemeList {
		@Override
		protected List<BusinessCenterEnum> doEvaluate(DataDocument fpmlDataDocument) {
			List<BusinessCenterEnum> businessCenterEnumList = new ArrayList<>();
			return assignOutput(businessCenterEnumList, fpmlDataDocument);
		}
		
		protected List<BusinessCenterEnum> assignOutput(List<BusinessCenterEnum> businessCenterEnumList, DataDocument fpmlDataDocument) {
			businessCenterEnumList.addAll(Collections.<BusinessCenterEnum>emptyList());
			
			return businessCenterEnumList;
		}
	}
}
