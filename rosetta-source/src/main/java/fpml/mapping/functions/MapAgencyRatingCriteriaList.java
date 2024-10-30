package fpml.mapping.functions;

import cdm.product.collateral.AgencyRatingCriteria;
import cdm.product.collateral.AgencyRatingCriteria.AgencyRatingCriteriaBuilder;
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


@ImplementedBy(MapAgencyRatingCriteriaList.MapAgencyRatingCriteriaListDefault.class)
public abstract class MapAgencyRatingCriteriaList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCreditNotationList mapCreditNotationList;

	/**
	* @param fpmlDataDocument 
	* @return agencyRatingCriteriaList 
	*/
	public List<? extends AgencyRatingCriteria> evaluate(DataDocument fpmlDataDocument) {
		List<AgencyRatingCriteria.AgencyRatingCriteriaBuilder> agencyRatingCriteriaListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends AgencyRatingCriteria> agencyRatingCriteriaList;
		if (agencyRatingCriteriaListBuilder == null) {
			agencyRatingCriteriaList = null;
		} else {
			agencyRatingCriteriaList = agencyRatingCriteriaListBuilder.stream().map(AgencyRatingCriteria::build).collect(Collectors.toList());
			objectValidator.validate(AgencyRatingCriteria.class, agencyRatingCriteriaList);
		}
		
		return agencyRatingCriteriaList;
	}

	protected abstract List<AgencyRatingCriteria.AgencyRatingCriteriaBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapAgencyRatingCriteriaListDefault extends MapAgencyRatingCriteriaList {
		@Override
		protected List<AgencyRatingCriteria.AgencyRatingCriteriaBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<AgencyRatingCriteria.AgencyRatingCriteriaBuilder> agencyRatingCriteriaList = new ArrayList<>();
			return assignOutput(agencyRatingCriteriaList, fpmlDataDocument);
		}
		
		protected List<AgencyRatingCriteria.AgencyRatingCriteriaBuilder> assignOutput(List<AgencyRatingCriteria.AgencyRatingCriteriaBuilder> agencyRatingCriteriaList, DataDocument fpmlDataDocument) {
			agencyRatingCriteriaList.addAll(toBuilder(MapperC.<AgencyRatingCriteria>of(MapperS.of(AgencyRatingCriteria.builder()
				.setQualifier(null)
				.setCreditNotation(new ArrayList(mapCreditNotationList.evaluate(fpmlDataDocument)))
				.setMismatchResolution(null)
				.setReferenceAgency(null)
				.setBoundary(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(agencyRatingCriteriaList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
