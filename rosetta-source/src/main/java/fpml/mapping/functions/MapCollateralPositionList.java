package fpml.mapping.functions;

import cdm.event.common.CollateralPosition;
import cdm.event.common.CollateralPosition.CollateralPositionBuilder;
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


@ImplementedBy(MapCollateralPositionList.MapCollateralPositionListDefault.class)
public abstract class MapCollateralPositionList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCollateralTreatment mapCollateralTreatment;
	@Inject protected MapMoney mapMoney;
	@Inject protected MapPriceQuantityList mapPriceQuantityList;
	@Inject protected MapProduct mapProduct;
	@Inject protected MapTradeState mapTradeState;

	/**
	* @param fpmlDataDocument 
	* @return collateralPositionList 
	*/
	public List<? extends CollateralPosition> evaluate(DataDocument fpmlDataDocument) {
		List<CollateralPosition.CollateralPositionBuilder> collateralPositionListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends CollateralPosition> collateralPositionList;
		if (collateralPositionListBuilder == null) {
			collateralPositionList = null;
		} else {
			collateralPositionList = collateralPositionListBuilder.stream().map(CollateralPosition::build).collect(Collectors.toList());
			objectValidator.validate(CollateralPosition.class, collateralPositionList);
		}
		
		return collateralPositionList;
	}

	protected abstract List<CollateralPosition.CollateralPositionBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCollateralPositionListDefault extends MapCollateralPositionList {
		@Override
		protected List<CollateralPosition.CollateralPositionBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<CollateralPosition.CollateralPositionBuilder> collateralPositionList = new ArrayList<>();
			return assignOutput(collateralPositionList, fpmlDataDocument);
		}
		
		protected List<CollateralPosition.CollateralPositionBuilder> assignOutput(List<CollateralPosition.CollateralPositionBuilder> collateralPositionList, DataDocument fpmlDataDocument) {
			collateralPositionList.addAll(toBuilder(MapperC.<CollateralPosition>of(MapperS.of(CollateralPosition.builder()
				.setPriceQuantity(new ArrayList(mapPriceQuantityList.evaluate(fpmlDataDocument)))
				.setProduct(mapProduct.evaluate(fpmlDataDocument))
				.setCashBalance(mapMoney.evaluate(fpmlDataDocument))
				.setTradeReferenceValue(mapTradeState.evaluate(fpmlDataDocument))
				.setTreatment(mapCollateralTreatment.evaluate(fpmlDataDocument))
				.setCollateralPositionStatus(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(collateralPositionList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
