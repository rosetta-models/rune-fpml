package fpml.mapping.functions;

import cdm.base.math.UnitType;
import cdm.base.math.UnitType.UnitTypeBuilder;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import fpml.confirmation.DataDocument;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapUnitType.MapUnitTypeDefault.class)
public abstract class MapUnitType implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCurrencyWithScheme mapCurrencyWithScheme;

	/**
	* @param fpmlDataDocument 
	* @return unitType 
	*/
	public UnitType evaluate(DataDocument fpmlDataDocument) {
		UnitType.UnitTypeBuilder unitTypeBuilder = doEvaluate(fpmlDataDocument);
		
		final UnitType unitType;
		if (unitTypeBuilder == null) {
			unitType = null;
		} else {
			unitType = unitTypeBuilder.build();
			objectValidator.validate(UnitType.class, unitType);
		}
		
		return unitType;
	}

	protected abstract UnitType.UnitTypeBuilder doEvaluate(DataDocument fpmlDataDocument);

	public static class MapUnitTypeDefault extends MapUnitType {
		@Override
		protected UnitType.UnitTypeBuilder doEvaluate(DataDocument fpmlDataDocument) {
			UnitType.UnitTypeBuilder unitType = UnitType.builder();
			return assignOutput(unitType, fpmlDataDocument);
		}
		
		protected UnitType.UnitTypeBuilder assignOutput(UnitType.UnitTypeBuilder unitType, DataDocument fpmlDataDocument) {
			unitType = toBuilder(UnitType.builder()
				.setCapacityUnit(null)
				.setWeatherUnit(null)
				.setFinancialUnit(null)
				.setCurrencyValue(mapCurrencyWithScheme.evaluate(fpmlDataDocument))
				.build());
			
			return Optional.ofNullable(unitType)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
