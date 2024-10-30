package fpml.mapping.functions;

import cdm.base.staticdata.party.BusinessUnit;
import cdm.base.staticdata.party.BusinessUnit.BusinessUnitBuilder;
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


@ImplementedBy(MapBusinessUnitList.MapBusinessUnitListDefault.class)
public abstract class MapBusinessUnitList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapContactInformation mapContactInformation;
	@Inject protected MapIdentifier mapIdentifier;

	/**
	* @param fpmlDataDocument 
	* @return businessUnitList 
	*/
	public List<? extends BusinessUnit> evaluate(DataDocument fpmlDataDocument) {
		List<BusinessUnit.BusinessUnitBuilder> businessUnitListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends BusinessUnit> businessUnitList;
		if (businessUnitListBuilder == null) {
			businessUnitList = null;
		} else {
			businessUnitList = businessUnitListBuilder.stream().map(BusinessUnit::build).collect(Collectors.toList());
			objectValidator.validate(BusinessUnit.class, businessUnitList);
		}
		
		return businessUnitList;
	}

	protected abstract List<BusinessUnit.BusinessUnitBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapBusinessUnitListDefault extends MapBusinessUnitList {
		@Override
		protected List<BusinessUnit.BusinessUnitBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<BusinessUnit.BusinessUnitBuilder> businessUnitList = new ArrayList<>();
			return assignOutput(businessUnitList, fpmlDataDocument);
		}
		
		protected List<BusinessUnit.BusinessUnitBuilder> assignOutput(List<BusinessUnit.BusinessUnitBuilder> businessUnitList, DataDocument fpmlDataDocument) {
			businessUnitList.addAll(toBuilder(MapperC.<BusinessUnit>of(MapperS.of(BusinessUnit.builder()
				.setName(null)
				.setIdentifier(mapIdentifier.evaluate(fpmlDataDocument))
				.setContactInformation(mapContactInformation.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(businessUnitList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
