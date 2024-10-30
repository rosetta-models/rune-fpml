package fpml.mapping.functions;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.product.collateral.EligibleCollateralCriteria;
import cdm.product.collateral.EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder;
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


@ImplementedBy(MapEligibleCollateralCriteriaList.MapEligibleCollateralCriteriaListDefault.class)
public abstract class MapEligibleCollateralCriteriaList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAssetCriteriaList mapAssetCriteriaList;
	@Inject protected MapCollateralTreatment mapCollateralTreatment;
	@Inject protected MapIssuerCriteriaList mapIssuerCriteriaList;

	/**
	* @param fpmlDataDocument 
	* @return eligibleCollateralCriteriaList 
	*/
	public List<? extends EligibleCollateralCriteria> evaluate(DataDocument fpmlDataDocument) {
		List<EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder> eligibleCollateralCriteriaListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends EligibleCollateralCriteria> eligibleCollateralCriteriaList;
		if (eligibleCollateralCriteriaListBuilder == null) {
			eligibleCollateralCriteriaList = null;
		} else {
			eligibleCollateralCriteriaList = eligibleCollateralCriteriaListBuilder.stream().map(EligibleCollateralCriteria::build).collect(Collectors.toList());
			objectValidator.validate(EligibleCollateralCriteria.class, eligibleCollateralCriteriaList);
		}
		
		return eligibleCollateralCriteriaList;
	}

	protected abstract List<EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapEligibleCollateralCriteriaListDefault extends MapEligibleCollateralCriteriaList {
		@Override
		protected List<EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder> eligibleCollateralCriteriaList = new ArrayList<>();
			return assignOutput(eligibleCollateralCriteriaList, fpmlDataDocument);
		}
		
		protected List<EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder> assignOutput(List<EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder> eligibleCollateralCriteriaList, DataDocument fpmlDataDocument) {
			eligibleCollateralCriteriaList.addAll(toBuilder(MapperC.<EligibleCollateralCriteria>of(MapperS.of(EligibleCollateralCriteria.builder()
				.setIssuer(new ArrayList(mapIssuerCriteriaList.evaluate(fpmlDataDocument)))
				.setAsset(new ArrayList(mapAssetCriteriaList.evaluate(fpmlDataDocument)))
				.setAppliesTo(Collections.<CounterpartyRoleEnum>emptyList())
				.setRestrictTo(null)
				.setRatingPriorityResolution(null)
				.setTreatment(mapCollateralTreatment.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(eligibleCollateralCriteriaList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
