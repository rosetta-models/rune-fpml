package fpml.mapping.functions;

import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.identifier.Identifier.IdentifierBuilder;
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


@ImplementedBy(MapIdentifierWithSchemeList.MapIdentifierWithSchemeListDefault.class)
public abstract class MapIdentifierWithSchemeList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssignedIdentifierList mapAssignedIdentifierList;
	@Inject protected MapIssuerWithScheme mapIssuerWithScheme;
	@Inject protected MapParty mapParty;

	/**
	* @param fpmlDataDocument 
	* @return identifierList 
	*/
	public List<? extends Identifier> evaluate(DataDocument fpmlDataDocument) {
		List<Identifier.IdentifierBuilder> identifierListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends Identifier> identifierList;
		if (identifierListBuilder == null) {
			identifierList = null;
		} else {
			identifierList = identifierListBuilder.stream().map(Identifier::build).collect(Collectors.toList());
			objectValidator.validate(Identifier.class, identifierList);
		}
		
		return identifierList;
	}

	protected abstract List<Identifier.IdentifierBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapIdentifierWithSchemeListDefault extends MapIdentifierWithSchemeList {
		@Override
		protected List<Identifier.IdentifierBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<Identifier.IdentifierBuilder> identifierList = new ArrayList<>();
			return assignOutput(identifierList, fpmlDataDocument);
		}
		
		protected List<Identifier.IdentifierBuilder> assignOutput(List<Identifier.IdentifierBuilder> identifierList, DataDocument fpmlDataDocument) {
			identifierList.addAll(toBuilder(MapperC.<Identifier>of(MapperS.of(Identifier.builder()
				.setIssuerReferenceValue(mapParty.evaluate(fpmlDataDocument))
				.setIssuerValue(mapIssuerWithScheme.evaluate(fpmlDataDocument))
				.setAssignedIdentifier(new ArrayList(mapAssignedIdentifierList.evaluate(fpmlDataDocument)))
				.build())).getMulti()));
			
			return Optional.ofNullable(identifierList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
