package fpml.mapping.functions;

import cdm.base.staticdata.party.AncillaryEntity;
import cdm.base.staticdata.party.AncillaryEntity.AncillaryEntityBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapAncillaryEntity.MapAncillaryEntityDefault.class)
public abstract class MapAncillaryEntity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapLegalEntity mapLegalEntity;

	/**
	* @param fpmlDataDocument 
	* @return ancillaryEntity 
	*/
	public AncillaryEntity evaluate(DataDocument fpmlDataDocument) {
		AncillaryEntity.AncillaryEntityBuilder ancillaryEntityBuilder = doEvaluate(fpmlDataDocument);
		
		final AncillaryEntity ancillaryEntity;
		if (ancillaryEntityBuilder == null) {
			ancillaryEntity = null;
		} else {
			ancillaryEntity = ancillaryEntityBuilder.build();
			objectValidator.validate(AncillaryEntity.class, ancillaryEntity);
		}
		
		return ancillaryEntity;
	}

	protected abstract AncillaryEntity.AncillaryEntityBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAncillaryEntityDefault extends MapAncillaryEntity {
		@Override
		protected AncillaryEntity.AncillaryEntityBuilder doEvaluate(DataDocument fpmlDataDocument) {
			AncillaryEntity.AncillaryEntityBuilder ancillaryEntity = AncillaryEntity.builder();
			return assignOutput(ancillaryEntity, fpmlDataDocument);
		}
		
		protected AncillaryEntity.AncillaryEntityBuilder assignOutput(AncillaryEntity.AncillaryEntityBuilder ancillaryEntity, DataDocument fpmlDataDocument) {
			ancillaryEntity = toBuilder(AncillaryEntity.builder()
				.setAncillaryParty(null)
				.setLegalEntity(mapLegalEntity.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(ancillaryEntity)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
