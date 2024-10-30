package fpml.mapping.functions;

import cdm.base.staticdata.party.LegalEntity;
import cdm.base.staticdata.party.LegalEntity.LegalEntityBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapLegalEntity.MapLegalEntityDefault.class)
public abstract class MapLegalEntity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapEntityIdWithSchemeList mapEntityIdWithSchemeList;
	@Inject protected MapNameWithScheme mapNameWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return legalEntity 
	*/
	public LegalEntity evaluate(DataDocument fpmlDataDocument) {
		LegalEntity.LegalEntityBuilder legalEntityBuilder = doEvaluate(fpmlDataDocument);
		
		final LegalEntity legalEntity;
		if (legalEntityBuilder == null) {
			legalEntity = null;
		} else {
			legalEntity = legalEntityBuilder.build();
			objectValidator.validate(LegalEntity.class, legalEntity);
		}
		
		return legalEntity;
	}

	protected abstract LegalEntity.LegalEntityBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapLegalEntityDefault extends MapLegalEntity {
		@Override
		protected LegalEntity.LegalEntityBuilder doEvaluate(DataDocument fpmlDataDocument) {
			LegalEntity.LegalEntityBuilder legalEntity = LegalEntity.builder();
			return assignOutput(legalEntity, fpmlDataDocument);
		}
		
		protected LegalEntity.LegalEntityBuilder assignOutput(LegalEntity.LegalEntityBuilder legalEntity, DataDocument fpmlDataDocument) {
			legalEntity = toBuilder(LegalEntity.builder()
				.setEntityIdValue(mapEntityIdWithSchemeList.evaluate(fpmlDataDocument))
				.setNameValue(mapNameWithScheme.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(legalEntity)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
