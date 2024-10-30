package fpml.mapping.functions;

import cdm.base.staticdata.identifier.LocationIdentifier;
import cdm.base.staticdata.identifier.LocationIdentifier.LocationIdentifierBuilder;
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


@ImplementedBy(MapLocationIdentifierList.MapLocationIdentifierListDefault.class)
public abstract class MapLocationIdentifierList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssignedIdentifierList mapAssignedIdentifierList;
	@Inject protected MapIssuerWithScheme mapIssuerWithScheme;
	@Inject protected MapParty mapParty;

	/**
	* @param fpmlDataDocument 
	* @return locationIdentifierList 
	*/
	public List<? extends LocationIdentifier> evaluate(DataDocument fpmlDataDocument) {
		List<LocationIdentifier.LocationIdentifierBuilder> locationIdentifierListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends LocationIdentifier> locationIdentifierList;
		if (locationIdentifierListBuilder == null) {
			locationIdentifierList = null;
		} else {
			locationIdentifierList = locationIdentifierListBuilder.stream().map(LocationIdentifier::build).collect(Collectors.toList());
			objectValidator.validate(LocationIdentifier.class, locationIdentifierList);
		}
		
		return locationIdentifierList;
	}

	protected abstract List<LocationIdentifier.LocationIdentifierBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapLocationIdentifierListDefault extends MapLocationIdentifierList {
		@Override
		protected List<LocationIdentifier.LocationIdentifierBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<LocationIdentifier.LocationIdentifierBuilder> locationIdentifierList = new ArrayList<>();
			return assignOutput(locationIdentifierList, fpmlDataDocument);
		}
		
		protected List<LocationIdentifier.LocationIdentifierBuilder> assignOutput(List<LocationIdentifier.LocationIdentifierBuilder> locationIdentifierList, DataDocument fpmlDataDocument) {
			locationIdentifierList.addAll(toBuilder(MapperC.<LocationIdentifier>of(MapperS.of(LocationIdentifier.builder()
				.setIssuerReferenceValue(mapParty.evaluate(fpmlDataDocument))
				.setIssuerValue(mapIssuerWithScheme.evaluate(fpmlDataDocument))
				.setAssignedIdentifier(new ArrayList(mapAssignedIdentifierList.evaluate(fpmlDataDocument)))
				.setLocationIdentifierType(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(locationIdentifierList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
