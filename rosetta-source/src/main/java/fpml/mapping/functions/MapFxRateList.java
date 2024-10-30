package fpml.mapping.functions;

import cdm.observable.asset.FxRate;
import cdm.observable.asset.FxRate.FxRateBuilder;
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


@ImplementedBy(MapFxRateList.MapFxRateListDefault.class)
public abstract class MapFxRateList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapQuotedCurrencyPair mapQuotedCurrencyPair;

	/**
	* @param fpmlDataDocument 
	* @return fxRateList 
	*/
	public List<? extends FxRate> evaluate(DataDocument fpmlDataDocument) {
		List<FxRate.FxRateBuilder> fxRateListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends FxRate> fxRateList;
		if (fxRateListBuilder == null) {
			fxRateList = null;
		} else {
			fxRateList = fxRateListBuilder.stream().map(FxRate::build).collect(Collectors.toList());
			objectValidator.validate(FxRate.class, fxRateList);
		}
		
		return fxRateList;
	}

	protected abstract List<FxRate.FxRateBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapFxRateListDefault extends MapFxRateList {
		@Override
		protected List<FxRate.FxRateBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<FxRate.FxRateBuilder> fxRateList = new ArrayList<>();
			return assignOutput(fxRateList, fpmlDataDocument);
		}
		
		protected List<FxRate.FxRateBuilder> assignOutput(List<FxRate.FxRateBuilder> fxRateList, DataDocument fpmlDataDocument) {
			fxRateList.addAll(toBuilder(MapperC.<FxRate>of(MapperS.of(FxRate.builder()
				.setQuotedCurrencyPair(mapQuotedCurrencyPair.evaluate(fpmlDataDocument))
				.setRate(null)
				.build())).getMulti()));
			
			return Optional.ofNullable(fxRateList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
