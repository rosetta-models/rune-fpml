package fpml.confirmation.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.WeatherStation;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("WeatherStationChoice")
@ImplementedBy(WeatherStationChoice.Default.class)
public interface WeatherStationChoice extends Validator<WeatherStation> {
	
	String NAME = "WeatherStationChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<WeatherStation> validate(RosettaPath path, WeatherStation weatherStation);
	
	class Default implements WeatherStationChoice {
	
		@Override
		public ValidationResult<WeatherStation> validate(RosettaPath path, WeatherStation weatherStation) {
			ComparisonResult result = executeDataRule(weatherStation);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "WeatherStation", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "WeatherStation", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(WeatherStation weatherStation) {
			try {
				return choice(MapperS.of(weatherStation), Arrays.asList("weatherStationCity", "weatherStationAirport", "weatherStationWBAN", "weatherStationWMO"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements WeatherStationChoice {
	
		@Override
		public ValidationResult<WeatherStation> validate(RosettaPath path, WeatherStation weatherStation) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "WeatherStation", path, DEFINITION);
		}
	}
}
