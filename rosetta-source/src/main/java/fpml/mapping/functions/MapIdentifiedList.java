package fpml.mapping.functions;

import cdm.base.staticdata.identifier.IdentifiedList;
import cdm.base.staticdata.identifier.IdentifiedList.IdentifiedListBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapIdentifiedList.MapIdentifiedListDefault.class)
public abstract class MapIdentifiedList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapIdentifier mapIdentifier;
	@Inject protected MapIdentifierList mapIdentifierList;
	@Inject protected MapPrice mapPrice;

	/**
	* @param fpmlDataDocument 
	* @return identifiedList 
	*/
	public IdentifiedList evaluate(DataDocument fpmlDataDocument) {
		IdentifiedList.IdentifiedListBuilder identifiedListBuilder = doEvaluate(fpmlDataDocument);
		
		final IdentifiedList identifiedList;
		if (identifiedListBuilder == null) {
			identifiedList = null;
		} else {
			identifiedList = identifiedListBuilder.build();
			objectValidator.validate(IdentifiedList.class, identifiedList);
		}
		
		return identifiedList;
	}

	protected abstract IdentifiedList.IdentifiedListBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapIdentifiedListDefault extends MapIdentifiedList {
		@Override
		protected IdentifiedList.IdentifiedListBuilder doEvaluate(DataDocument fpmlDataDocument) {
			IdentifiedList.IdentifiedListBuilder identifiedList = IdentifiedList.builder();
			return assignOutput(identifiedList, fpmlDataDocument);
		}
		
		protected IdentifiedList.IdentifiedListBuilder assignOutput(IdentifiedList.IdentifiedListBuilder identifiedList, DataDocument fpmlDataDocument) {
			identifiedList = toBuilder(IdentifiedList.builder()
				.setListId(mapIdentifier.evaluate(fpmlDataDocument))
				.setComponentId(new ArrayList(mapIdentifierList.evaluate(fpmlDataDocument)))
				.setPrice(mapPrice.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(identifiedList)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
