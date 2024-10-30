package fpml.mapping.functions;

import cdm.base.staticdata.asset.common.CollateralIssuerType;
import cdm.base.staticdata.asset.common.CollateralIssuerType.CollateralIssuerTypeBuilder;
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


@ImplementedBy(MapCollateralIssuerTypeList.MapCollateralIssuerTypeListDefault.class)
public abstract class MapCollateralIssuerTypeList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapQuasiGovernmentIssuerType mapQuasiGovernmentIssuerType;
	@Inject protected MapRegionalGovernmentIssuerType mapRegionalGovernmentIssuerType;
	@Inject protected MapSpecialPurposeVehicleIssuerType mapSpecialPurposeVehicleIssuerType;

	/**
	* @param fpmlDataDocument 
	* @return collateralIssuerTypeList 
	*/
	public List<? extends CollateralIssuerType> evaluate(DataDocument fpmlDataDocument) {
		List<CollateralIssuerType.CollateralIssuerTypeBuilder> collateralIssuerTypeListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends CollateralIssuerType> collateralIssuerTypeList;
		if (collateralIssuerTypeListBuilder == null) {
			collateralIssuerTypeList = null;
		} else {
			collateralIssuerTypeList = collateralIssuerTypeListBuilder.stream().map(CollateralIssuerType::build).collect(Collectors.toList());
			objectValidator.validate(CollateralIssuerType.class, collateralIssuerTypeList);
		}
		
		return collateralIssuerTypeList;
	}

	protected abstract List<CollateralIssuerType.CollateralIssuerTypeBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCollateralIssuerTypeListDefault extends MapCollateralIssuerTypeList {
		@Override
		protected List<CollateralIssuerType.CollateralIssuerTypeBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<CollateralIssuerType.CollateralIssuerTypeBuilder> collateralIssuerTypeList = new ArrayList<>();
			return assignOutput(collateralIssuerTypeList, fpmlDataDocument);
		}
		
		protected List<CollateralIssuerType.CollateralIssuerTypeBuilder> assignOutput(List<CollateralIssuerType.CollateralIssuerTypeBuilder> collateralIssuerTypeList, DataDocument fpmlDataDocument) {
			collateralIssuerTypeList.addAll(toBuilder(MapperC.<CollateralIssuerType>of(MapperS.of(CollateralIssuerType.builder()
				.setIssuerType(null)
				.setSupraNationalType(null)
				.setQuasiGovernmentType(mapQuasiGovernmentIssuerType.evaluate(fpmlDataDocument))
				.setRegionalGovernmentType(mapRegionalGovernmentIssuerType.evaluate(fpmlDataDocument))
				.setSpecialPurposeVehicleType(mapSpecialPurposeVehicleIssuerType.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(collateralIssuerTypeList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
