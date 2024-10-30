package fpml.mapping.functions;

import cdm.base.staticdata.identifier.AssignedIdentifier;
import cdm.base.staticdata.identifier.AssignedIdentifier.AssignedIdentifierBuilder;
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


@ImplementedBy(MapAssignedIdentifierList.MapAssignedIdentifierListDefault.class)
public abstract class MapAssignedIdentifierList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapIdentifierWithScheme mapIdentifierWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return assignedIdentifierList 
	*/
	public List<? extends AssignedIdentifier> evaluate(DataDocument fpmlDataDocument) {
		List<AssignedIdentifier.AssignedIdentifierBuilder> assignedIdentifierListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends AssignedIdentifier> assignedIdentifierList;
		if (assignedIdentifierListBuilder == null) {
			assignedIdentifierList = null;
		} else {
			assignedIdentifierList = assignedIdentifierListBuilder.stream().map(AssignedIdentifier::build).collect(Collectors.toList());
			objectValidator.validate(AssignedIdentifier.class, assignedIdentifierList);
		}
		
		return assignedIdentifierList;
	}

	protected abstract List<AssignedIdentifier.AssignedIdentifierBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAssignedIdentifierListDefault extends MapAssignedIdentifierList {
		@Override
		protected List<AssignedIdentifier.AssignedIdentifierBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<AssignedIdentifier.AssignedIdentifierBuilder> assignedIdentifierList = new ArrayList<>();
			return assignOutput(assignedIdentifierList, fpmlDataDocument);
		}
		
		protected List<AssignedIdentifier.AssignedIdentifierBuilder> assignOutput(List<AssignedIdentifier.AssignedIdentifierBuilder> assignedIdentifierList, DataDocument fpmlDataDocument) {
			assignedIdentifierList.addAll(toBuilder(MapperC.<AssignedIdentifier>of(MapperS.of(AssignedIdentifier.builder()
				.setIdentifierValue(mapIdentifierWithScheme.evaluate(fpmlDataDocument))
				.setVersion(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(assignedIdentifierList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
