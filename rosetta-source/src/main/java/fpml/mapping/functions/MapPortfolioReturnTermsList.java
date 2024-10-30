package fpml.mapping.functions;

import cdm.product.template.PortfolioReturnTerms;
import cdm.product.template.PortfolioReturnTerms.PortfolioReturnTermsBuilder;
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


@ImplementedBy(MapPortfolioReturnTermsList.MapPortfolioReturnTermsListDefault.class)
public abstract class MapPortfolioReturnTermsList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCorrelationReturnTerms mapCorrelationReturnTerms;
	@Inject protected MapDividendReturnTerms mapDividendReturnTerms;
	@Inject protected MapNonNegativeQuantitySchedule mapNonNegativeQuantitySchedule;
	@Inject protected MapObservable mapObservable;
	@Inject protected MapPayerReceiver mapPayerReceiver;
	@Inject protected MapPriceReturnTerms mapPriceReturnTerms;
	@Inject protected MapPriceScheduleList mapPriceScheduleList;
	@Inject protected MapVarianceReturnTerms mapVarianceReturnTerms;
	@Inject protected MapVolatilityReturnTerms mapVolatilityReturnTerms;

	/**
	* @param fpmlDataDocument 
	* @return portfolioReturnTermsList 
	*/
	public List<? extends PortfolioReturnTerms> evaluate(DataDocument fpmlDataDocument) {
		List<PortfolioReturnTerms.PortfolioReturnTermsBuilder> portfolioReturnTermsListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends PortfolioReturnTerms> portfolioReturnTermsList;
		if (portfolioReturnTermsListBuilder == null) {
			portfolioReturnTermsList = null;
		} else {
			portfolioReturnTermsList = portfolioReturnTermsListBuilder.stream().map(PortfolioReturnTerms::build).collect(Collectors.toList());
			objectValidator.validate(PortfolioReturnTerms.class, portfolioReturnTermsList);
		}
		
		return portfolioReturnTermsList;
	}

	protected abstract List<PortfolioReturnTerms.PortfolioReturnTermsBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapPortfolioReturnTermsListDefault extends MapPortfolioReturnTermsList {
		@Override
		protected List<PortfolioReturnTerms.PortfolioReturnTermsBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<PortfolioReturnTerms.PortfolioReturnTermsBuilder> portfolioReturnTermsList = new ArrayList<>();
			return assignOutput(portfolioReturnTermsList, fpmlDataDocument);
		}
		
		protected List<PortfolioReturnTerms.PortfolioReturnTermsBuilder> assignOutput(List<PortfolioReturnTerms.PortfolioReturnTermsBuilder> portfolioReturnTermsList, DataDocument fpmlDataDocument) {
			portfolioReturnTermsList.addAll(toBuilder(MapperC.<PortfolioReturnTerms>of(MapperS.of(PortfolioReturnTerms.builder()
				.setPriceReturnTerms(mapPriceReturnTerms.evaluate(fpmlDataDocument))
				.setDividendReturnTerms(mapDividendReturnTerms.evaluate(fpmlDataDocument))
				.setVarianceReturnTerms(mapVarianceReturnTerms.evaluate(fpmlDataDocument))
				.setVolatilityReturnTerms(mapVolatilityReturnTerms.evaluate(fpmlDataDocument))
				.setCorrelationReturnTerms(mapCorrelationReturnTerms.evaluate(fpmlDataDocument))
				.setPayerReceiver(mapPayerReceiver.evaluate(fpmlDataDocument))
				.setUnderlierValue(mapObservable.evaluate(fpmlDataDocument))
				.setQuantityValue(mapNonNegativeQuantitySchedule.evaluate(fpmlDataDocument))
				.setInitialValuationPriceValue(new ArrayList(mapPriceScheduleList.evaluate(fpmlDataDocument)))
				.setInterimValuationPriceValue(new ArrayList(mapPriceScheduleList.evaluate(fpmlDataDocument)))
				.setFinalValuationPriceValue(new ArrayList(mapPriceScheduleList.evaluate(fpmlDataDocument)))
				.build())).getMulti()));
			
			return Optional.ofNullable(portfolioReturnTermsList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
