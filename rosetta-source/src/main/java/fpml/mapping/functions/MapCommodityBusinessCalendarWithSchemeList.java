package fpml.mapping.functions;

import cdm.base.datetime.CommodityBusinessCalendarEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@ImplementedBy(MapCommodityBusinessCalendarWithSchemeList.MapCommodityBusinessCalendarWithSchemeListDefault.class)
public abstract class MapCommodityBusinessCalendarWithSchemeList implements RosettaFunction {

	/**
	* @param fpmlDataDocument 
	* @return commodityBusinessCalendarEnumList 
	*/
	public List<CommodityBusinessCalendarEnum> evaluate(DataDocument fpmlDataDocument) {
		List<CommodityBusinessCalendarEnum> commodityBusinessCalendarEnumList = doEvaluate(fpmlDataDocument);
		
		return commodityBusinessCalendarEnumList;
	}

	protected abstract List<CommodityBusinessCalendarEnum> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCommodityBusinessCalendarWithSchemeListDefault extends MapCommodityBusinessCalendarWithSchemeList {
		@Override
		protected List<CommodityBusinessCalendarEnum> doEvaluate(DataDocument fpmlDataDocument) {
			List<CommodityBusinessCalendarEnum> commodityBusinessCalendarEnumList = new ArrayList<>();
			return assignOutput(commodityBusinessCalendarEnumList, fpmlDataDocument);
		}
		
		protected List<CommodityBusinessCalendarEnum> assignOutput(List<CommodityBusinessCalendarEnum> commodityBusinessCalendarEnumList, DataDocument fpmlDataDocument) {
			commodityBusinessCalendarEnumList.addAll(Collections.<CommodityBusinessCalendarEnum>emptyList());
			
			return commodityBusinessCalendarEnumList;
		}
	}
}
