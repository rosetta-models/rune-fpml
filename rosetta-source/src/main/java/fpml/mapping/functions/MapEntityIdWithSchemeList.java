package fpml.mapping.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@ImplementedBy(MapEntityIdWithSchemeList.MapEntityIdWithSchemeListDefault.class)
public abstract class MapEntityIdWithSchemeList implements RosettaFunction {

	/**
	* @param fpmlDataDocument 
	* @return stringList 
	*/
	public List<String> evaluate(DataDocument fpmlDataDocument) {
		List<String> stringList = doEvaluate(fpmlDataDocument);
		
		return stringList;
	}

	protected abstract List<String> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapEntityIdWithSchemeListDefault extends MapEntityIdWithSchemeList {
		@Override
		protected List<String> doEvaluate(DataDocument fpmlDataDocument) {
			List<String> stringList = new ArrayList<>();
			return assignOutput(stringList, fpmlDataDocument);
		}
		
		protected List<String> assignOutput(List<String> stringList, DataDocument fpmlDataDocument) {
			stringList.addAll(Collections.<String>emptyList());
			
			return stringList;
		}
	}
}
