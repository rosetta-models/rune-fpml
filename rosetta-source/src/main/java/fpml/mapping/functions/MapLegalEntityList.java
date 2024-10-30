package fpml.mapping.functions;

import cdm.base.staticdata.party.LegalEntity;
import cdm.base.staticdata.party.LegalEntity.LegalEntityBuilder;
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


@ImplementedBy(MapLegalEntityList.MapLegalEntityListDefault.class)
public abstract class MapLegalEntityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapEntityIdWithSchemeList mapEntityIdWithSchemeList;
	@Inject protected MapNameWithScheme mapNameWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return legalEntityList 
	*/
	public List<? extends LegalEntity> evaluate(DataDocument fpmlDataDocument) {
		List<LegalEntity.LegalEntityBuilder> legalEntityListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends LegalEntity> legalEntityList;
		if (legalEntityListBuilder == null) {
			legalEntityList = null;
		} else {
			legalEntityList = legalEntityListBuilder.stream().map(LegalEntity::build).collect(Collectors.toList());
			objectValidator.validate(LegalEntity.class, legalEntityList);
		}
		
		return legalEntityList;
	}

	protected abstract List<LegalEntity.LegalEntityBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapLegalEntityListDefault extends MapLegalEntityList {
		@Override
		protected List<LegalEntity.LegalEntityBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<LegalEntity.LegalEntityBuilder> legalEntityList = new ArrayList<>();
			return assignOutput(legalEntityList, fpmlDataDocument);
		}
		
		protected List<LegalEntity.LegalEntityBuilder> assignOutput(List<LegalEntity.LegalEntityBuilder> legalEntityList, DataDocument fpmlDataDocument) {
			legalEntityList.addAll(toBuilder(MapperC.<LegalEntity>of(MapperS.of(LegalEntity.builder()
				.setEntityIdValue(mapEntityIdWithSchemeList.evaluate(fpmlDataDocument))
				.setNameValue(mapNameWithScheme.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(legalEntityList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
