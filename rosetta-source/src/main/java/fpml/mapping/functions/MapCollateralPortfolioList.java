package fpml.mapping.functions;

import cdm.event.common.CollateralPortfolio;
import cdm.event.common.CollateralPortfolio.CollateralPortfolioBuilder;
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


@ImplementedBy(MapCollateralPortfolioList.MapCollateralPortfolioListDefault.class)
public abstract class MapCollateralPortfolioList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCollateralBalanceList mapCollateralBalanceList;
	@Inject protected MapCollateralPositionList mapCollateralPositionList;
	@Inject protected MapIdentifier mapIdentifier;
	@Inject protected MapLegalAgreement mapLegalAgreement;

	/**
	* @param fpmlDataDocument 
	* @return collateralPortfolioList 
	*/
	public List<? extends CollateralPortfolio> evaluate(DataDocument fpmlDataDocument) {
		List<CollateralPortfolio.CollateralPortfolioBuilder> collateralPortfolioListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends CollateralPortfolio> collateralPortfolioList;
		if (collateralPortfolioListBuilder == null) {
			collateralPortfolioList = null;
		} else {
			collateralPortfolioList = collateralPortfolioListBuilder.stream().map(CollateralPortfolio::build).collect(Collectors.toList());
			objectValidator.validate(CollateralPortfolio.class, collateralPortfolioList);
		}
		
		return collateralPortfolioList;
	}

	protected abstract List<CollateralPortfolio.CollateralPortfolioBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapCollateralPortfolioListDefault extends MapCollateralPortfolioList {
		@Override
		protected List<CollateralPortfolio.CollateralPortfolioBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<CollateralPortfolio.CollateralPortfolioBuilder> collateralPortfolioList = new ArrayList<>();
			return assignOutput(collateralPortfolioList, fpmlDataDocument);
		}
		
		protected List<CollateralPortfolio.CollateralPortfolioBuilder> assignOutput(List<CollateralPortfolio.CollateralPortfolioBuilder> collateralPortfolioList, DataDocument fpmlDataDocument) {
			collateralPortfolioList.addAll(toBuilder(MapperC.<CollateralPortfolio>of(MapperS.of(CollateralPortfolio.builder()
				.setPortfolioIdentifier(mapIdentifier.evaluate(fpmlDataDocument))
				.setCollateralPosition(new ArrayList(mapCollateralPositionList.evaluate(fpmlDataDocument)))
				.setCollateralBalance(new ArrayList(mapCollateralBalanceList.evaluate(fpmlDataDocument)))
				.setLegalAgreementValue(mapLegalAgreement.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(collateralPortfolioList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
