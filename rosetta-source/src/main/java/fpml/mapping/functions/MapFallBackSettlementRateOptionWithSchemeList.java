package fpml.mapping.functions;

import cdm.observable.asset.SettlementRateOptionEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@ImplementedBy(MapFallBackSettlementRateOptionWithSchemeList.MapFallBackSettlementRateOptionWithSchemeListDefault.class)
public abstract class MapFallBackSettlementRateOptionWithSchemeList implements RosettaFunction {

	/**
	* @param fpmlDataDocument 
	* @return settlementRateOptionEnumList 
	*/
	public List<SettlementRateOptionEnum> evaluate(DataDocument fpmlDataDocument) {
		List<SettlementRateOptionEnum> settlementRateOptionEnumList = doEvaluate(fpmlDataDocument);
		
		return settlementRateOptionEnumList;
	}

	protected abstract List<SettlementRateOptionEnum> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapFallBackSettlementRateOptionWithSchemeListDefault extends MapFallBackSettlementRateOptionWithSchemeList {
		@Override
		protected List<SettlementRateOptionEnum> doEvaluate(DataDocument fpmlDataDocument) {
			List<SettlementRateOptionEnum> settlementRateOptionEnumList = new ArrayList<>();
			return assignOutput(settlementRateOptionEnumList, fpmlDataDocument);
		}
		
		protected List<SettlementRateOptionEnum> assignOutput(List<SettlementRateOptionEnum> settlementRateOptionEnumList, DataDocument fpmlDataDocument) {
			settlementRateOptionEnumList.addAll(Collections.<SettlementRateOptionEnum>emptyList());
			
			return settlementRateOptionEnumList;
		}
	}
}
