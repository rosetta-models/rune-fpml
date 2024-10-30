package fpml.mapping.functions;

import cdm.legaldocumentation.common.UmbrellaAgreementEntity;
import cdm.legaldocumentation.common.UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder;
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


@ImplementedBy(MapUmbrellaAgreementEntityList.MapUmbrellaAgreementEntityListDefault.class)
public abstract class MapUmbrellaAgreementEntityList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapEntityIdWithSchemeList mapEntityIdWithSchemeList;
	@Inject protected MapNameWithScheme mapNameWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return umbrellaAgreementEntityList 
	*/
	public List<? extends UmbrellaAgreementEntity> evaluate(DataDocument fpmlDataDocument) {
		List<UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder> umbrellaAgreementEntityListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends UmbrellaAgreementEntity> umbrellaAgreementEntityList;
		if (umbrellaAgreementEntityListBuilder == null) {
			umbrellaAgreementEntityList = null;
		} else {
			umbrellaAgreementEntityList = umbrellaAgreementEntityListBuilder.stream().map(UmbrellaAgreementEntity::build).collect(Collectors.toList());
			objectValidator.validate(UmbrellaAgreementEntity.class, umbrellaAgreementEntityList);
		}
		
		return umbrellaAgreementEntityList;
	}

	protected abstract List<UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapUmbrellaAgreementEntityListDefault extends MapUmbrellaAgreementEntityList {
		@Override
		protected List<UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder> umbrellaAgreementEntityList = new ArrayList<>();
			return assignOutput(umbrellaAgreementEntityList, fpmlDataDocument);
		}
		
		protected List<UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder> assignOutput(List<UmbrellaAgreementEntity.UmbrellaAgreementEntityBuilder> umbrellaAgreementEntityList, DataDocument fpmlDataDocument) {
			umbrellaAgreementEntityList.addAll(toBuilder(MapperC.<UmbrellaAgreementEntity>of(MapperS.of(UmbrellaAgreementEntity.builder()
				.setEntityIdValue(mapEntityIdWithSchemeList.evaluate(fpmlDataDocument))
				.setNameValue(mapNameWithScheme.evaluate(fpmlDataDocument))
				.setTerms(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(umbrellaAgreementEntityList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
