package fpml.mapping.functions;

import cdm.product.asset.ReferencePoolItem;
import cdm.product.asset.ReferencePoolItem.ReferencePoolItemBuilder;
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


@ImplementedBy(MapReferencePoolItemList.MapReferencePoolItemListDefault.class)
public abstract class MapReferencePoolItemList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCashSettlementTerms mapCashSettlementTerms;
	@Inject protected MapConstituentWeight mapConstituentWeight;
	@Inject protected MapPhysicalSettlementTerms mapPhysicalSettlementTerms;
	@Inject protected MapProtectionTerms mapProtectionTerms;
	@Inject protected MapReferencePair mapReferencePair;

	/**
	* @param fpmlDataDocument 
	* @return referencePoolItemList 
	*/
	public List<? extends ReferencePoolItem> evaluate(DataDocument fpmlDataDocument) {
		List<ReferencePoolItem.ReferencePoolItemBuilder> referencePoolItemListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends ReferencePoolItem> referencePoolItemList;
		if (referencePoolItemListBuilder == null) {
			referencePoolItemList = null;
		} else {
			referencePoolItemList = referencePoolItemListBuilder.stream().map(ReferencePoolItem::build).collect(Collectors.toList());
			objectValidator.validate(ReferencePoolItem.class, referencePoolItemList);
		}
		
		return referencePoolItemList;
	}

	protected abstract List<ReferencePoolItem.ReferencePoolItemBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapReferencePoolItemListDefault extends MapReferencePoolItemList {
		@Override
		protected List<ReferencePoolItem.ReferencePoolItemBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<ReferencePoolItem.ReferencePoolItemBuilder> referencePoolItemList = new ArrayList<>();
			return assignOutput(referencePoolItemList, fpmlDataDocument);
		}
		
		protected List<ReferencePoolItem.ReferencePoolItemBuilder> assignOutput(List<ReferencePoolItem.ReferencePoolItemBuilder> referencePoolItemList, DataDocument fpmlDataDocument) {
			referencePoolItemList.addAll(toBuilder(MapperC.<ReferencePoolItem>of(MapperS.of(ReferencePoolItem.builder()
				.setConstituentWeight(mapConstituentWeight.evaluate(fpmlDataDocument))
				.setReferencePair(mapReferencePair.evaluate(fpmlDataDocument))
				.setProtectionTermsReferenceValue(mapProtectionTerms.evaluate(fpmlDataDocument))
				.setCashSettlementTermsReferenceValue(mapCashSettlementTerms.evaluate(fpmlDataDocument))
				.setPhysicalSettlementTermsReferenceValue(mapPhysicalSettlementTerms.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(referencePoolItemList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
