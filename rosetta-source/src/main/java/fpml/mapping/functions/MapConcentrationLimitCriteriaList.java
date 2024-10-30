package fpml.mapping.functions;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.product.collateral.ConcentrationLimitCriteria;
import cdm.product.collateral.ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.confirmation.DataDocument;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;


@ImplementedBy(MapConcentrationLimitCriteriaList.MapConcentrationLimitCriteriaListDefault.class)
public abstract class MapConcentrationLimitCriteriaList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetCriteriaList mapAssetCriteriaList;
	@Inject protected MapAverageTradingVolume mapAverageTradingVolume;
	@Inject protected MapIssuerCriteriaList mapIssuerCriteriaList;

	/**
	* @param fpmlDataDocument 
	* @return concentrationLimitCriteriaList 
	*/
	public List<? extends ConcentrationLimitCriteria> evaluate(DataDocument fpmlDataDocument) {
		List<ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder> concentrationLimitCriteriaListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends ConcentrationLimitCriteria> concentrationLimitCriteriaList;
		if (concentrationLimitCriteriaListBuilder == null) {
			concentrationLimitCriteriaList = null;
		} else {
			concentrationLimitCriteriaList = concentrationLimitCriteriaListBuilder.stream().map(ConcentrationLimitCriteria::build).collect(Collectors.toList());
			objectValidator.validate(ConcentrationLimitCriteria.class, concentrationLimitCriteriaList);
		}
		
		return concentrationLimitCriteriaList;
	}

	protected abstract List<ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapConcentrationLimitCriteriaListDefault extends MapConcentrationLimitCriteriaList {
		@Override
		protected List<ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder> concentrationLimitCriteriaList = new ArrayList<>();
			return assignOutput(concentrationLimitCriteriaList, fpmlDataDocument);
		}
		
		protected List<ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder> assignOutput(List<ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder> concentrationLimitCriteriaList, DataDocument fpmlDataDocument) {
			concentrationLimitCriteriaList.addAll(toBuilder(MapperC.<ConcentrationLimitCriteria>of(MapperS.of(ConcentrationLimitCriteria.builder()
				.setIssuer(new ArrayList(mapIssuerCriteriaList.evaluate(fpmlDataDocument)))
				.setAsset(new ArrayList(mapAssetCriteriaList.evaluate(fpmlDataDocument)))
				.setAppliesTo(Collections.<CounterpartyRoleEnum>emptyList())
				.setRestrictTo(null)
				.setRatingPriorityResolution(null)
				.setConcentrationLimitType(null)
				.setAverageTradingVolume(mapAverageTradingVolume.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(concentrationLimitCriteriaList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
