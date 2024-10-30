package fpml.mapping.functions;

import cdm.product.template.PassThroughItem;
import cdm.product.template.PassThroughItem.PassThroughItemBuilder;
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


@ImplementedBy(MapPassThroughItemList.MapPassThroughItemListDefault.class)
public abstract class MapPassThroughItemList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPayerReceiver mapPayerReceiver;

	/**
	* @param fpmlDataDocument 
	* @return passThroughItemList 
	*/
	public List<? extends PassThroughItem> evaluate(DataDocument fpmlDataDocument) {
		List<PassThroughItem.PassThroughItemBuilder> passThroughItemListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends PassThroughItem> passThroughItemList;
		if (passThroughItemListBuilder == null) {
			passThroughItemList = null;
		} else {
			passThroughItemList = passThroughItemListBuilder.stream().map(PassThroughItem::build).collect(Collectors.toList());
			objectValidator.validate(PassThroughItem.class, passThroughItemList);
		}
		
		return passThroughItemList;
	}

	protected abstract List<PassThroughItem.PassThroughItemBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPassThroughItemListDefault extends MapPassThroughItemList {
		@Override
		protected List<PassThroughItem.PassThroughItemBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<PassThroughItem.PassThroughItemBuilder> passThroughItemList = new ArrayList<>();
			return assignOutput(passThroughItemList, fpmlDataDocument);
		}
		
		protected List<PassThroughItem.PassThroughItemBuilder> assignOutput(List<PassThroughItem.PassThroughItemBuilder> passThroughItemList, DataDocument fpmlDataDocument) {
			passThroughItemList.addAll(toBuilder(MapperC.<PassThroughItem>of(MapperS.of(PassThroughItem.builder()
				.setPayerReceiver(mapPayerReceiver.evaluate(fpmlDataDocument))
				.setPassThroughPercentage(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(passThroughItemList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
