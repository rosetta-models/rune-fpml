package fpml.mapping.functions;

import cdm.observable.asset.Money;
import cdm.observable.asset.Money.MoneyBuilder;
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


@ImplementedBy(MapMoneyList.MapMoneyListDefault.class)
public abstract class MapMoneyList implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDatedValueList mapDatedValueList;
	@Inject protected MapFrequency mapFrequency;
	@Inject protected MapMeasure mapMeasure;
	@Inject protected MapUnitType mapUnitType;

	/**
	* @param fpmlDataDocument 
	* @return moneyList 
	*/
	public List<? extends Money> evaluate(DataDocument fpmlDataDocument) {
		List<Money.MoneyBuilder> moneyListBuilder = doEvaluate(fpmlDataDocument);
		
		final List<? extends Money> moneyList;
		if (moneyListBuilder == null) {
			moneyList = null;
		} else {
			moneyList = moneyListBuilder.stream().map(Money::build).collect(Collectors.toList());
			objectValidator.validate(Money.class, moneyList);
		}
		
		return moneyList;
	}

	protected abstract List<Money.MoneyBuilder> doEvaluate(DataDocument fpmlDataDocument);

	public static class MapMoneyListDefault extends MapMoneyList {
		@Override
		protected List<Money.MoneyBuilder> doEvaluate(DataDocument fpmlDataDocument) {
			List<Money.MoneyBuilder> moneyList = new ArrayList<>();
			return assignOutput(moneyList, fpmlDataDocument);
		}
		
		protected List<Money.MoneyBuilder> assignOutput(List<Money.MoneyBuilder> moneyList, DataDocument fpmlDataDocument) {
			moneyList.addAll(toBuilder(MapperC.<Money>of(MapperS.of(Money.builder()
				.setValue(null)
				.setUnit(mapUnitType.evaluate(fpmlDataDocument))
				.setDatedValue(new ArrayList(mapDatedValueList.evaluate(fpmlDataDocument)))
				.setMultiplier(mapMeasure.evaluate(fpmlDataDocument))
				.setFrequency(mapFrequency.evaluate(fpmlDataDocument))
				.build())).getMulti()));
			
			return Optional.ofNullable(moneyList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
