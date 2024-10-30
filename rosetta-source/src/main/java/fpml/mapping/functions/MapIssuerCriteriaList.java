package fpml.mapping.functions;

import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import cdm.product.collateral.IssuerCriteria;
import cdm.product.collateral.IssuerCriteria.IssuerCriteriaBuilder;
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


@ImplementedBy(MapIssuerCriteriaList.MapIssuerCriteriaListDefault.class)
public abstract class MapIssuerCriteriaList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAgencyRatingCriteriaList mapAgencyRatingCriteriaList;
	@Inject protected MapCollateralIssuerTypeList mapCollateralIssuerTypeList;
	@Inject protected MapLegalEntityList mapLegalEntityList;

	/**
	* @param fpmlDataDocument 
	* @return issuerCriteriaList 
	*/
	public List<? extends IssuerCriteria> evaluate(DataDocument fpmlDataDocument) {
		List<IssuerCriteria.IssuerCriteriaBuilder> issuerCriteriaListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends IssuerCriteria> issuerCriteriaList;
		if (issuerCriteriaListBuilder == null) {
			issuerCriteriaList = null;
		} else {
			issuerCriteriaList = issuerCriteriaListBuilder.stream().map(IssuerCriteria::build).collect(Collectors.toList());
			objectValidator.validate(IssuerCriteria.class, issuerCriteriaList);
		}
		
		return issuerCriteriaList;
	}

	protected abstract List<IssuerCriteria.IssuerCriteriaBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapIssuerCriteriaListDefault extends MapIssuerCriteriaList {
		@Override
		protected List<IssuerCriteria.IssuerCriteriaBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<IssuerCriteria.IssuerCriteriaBuilder> issuerCriteriaList = new ArrayList<>();
			return assignOutput(issuerCriteriaList, fpmlDataDocument);
		}
		
		protected List<IssuerCriteria.IssuerCriteriaBuilder> assignOutput(List<IssuerCriteria.IssuerCriteriaBuilder> issuerCriteriaList, DataDocument fpmlDataDocument) {
			issuerCriteriaList.addAll(toBuilder(MapperC.<IssuerCriteria>of(MapperS.of(IssuerCriteria.builder()
				.setIssuerType(new ArrayList(mapCollateralIssuerTypeList.evaluate(fpmlDataDocument)))
				.setIssuerCountryOfOrigin(Collections.<ISOCountryCodeEnum>emptyList())
				.setIssuerName(new ArrayList(mapLegalEntityList.evaluate(fpmlDataDocument)))
				.setIssuerAgencyRating(new ArrayList(mapAgencyRatingCriteriaList.evaluate(fpmlDataDocument)))
				.setSovereignAgencyRating(new ArrayList(mapAgencyRatingCriteriaList.evaluate(fpmlDataDocument)))
				.setCounterpartyOwnIssuePermitted(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(issuerCriteriaList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
