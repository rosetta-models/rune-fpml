package fpml.mapping.functions;

import cdm.base.staticdata.identifier.Identifier;
import cdm.base.staticdata.identifier.Identifier.IdentifierBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapIdentifier.MapIdentifierDefault.class)
public abstract class MapIdentifier implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssignedIdentifierList mapAssignedIdentifierList;
	@Inject protected MapIssuerWithScheme mapIssuerWithScheme;
	@Inject protected MapParty mapParty;

	/**
	* @param fpmlDataDocument 
	* @return identifier 
	*/
	public Identifier evaluate(DataDocument fpmlDataDocument) {
		Identifier.IdentifierBuilder identifierBuilder = doEvaluate(fpmlDataDocument);
		
		final Identifier identifier;
		if (identifierBuilder == null) {
			identifier = null;
		} else {
			identifier = identifierBuilder.build();
			objectValidator.validate(Identifier.class, identifier);
		}
		
		return identifier;
	}

	protected abstract Identifier.IdentifierBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapIdentifierDefault extends MapIdentifier {
		@Override
		protected Identifier.IdentifierBuilder doEvaluate(DataDocument fpmlDataDocument) {
			Identifier.IdentifierBuilder identifier = Identifier.builder();
			return assignOutput(identifier, fpmlDataDocument);
		}
		
		protected Identifier.IdentifierBuilder assignOutput(Identifier.IdentifierBuilder identifier, DataDocument fpmlDataDocument) {
			identifier = toBuilder(Identifier.builder()
				.setIssuerReferenceValue(mapParty.evaluate(fpmlDataDocument))
				.setIssuerValue(mapIssuerWithScheme.evaluate(fpmlDataDocument))
				.setAssignedIdentifier(new ArrayList(mapAssignedIdentifierList.evaluate(fpmlDataDocument)))
				.build());
			
			return Optional.ofNullable(identifier)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
