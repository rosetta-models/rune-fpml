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
import fpml.confirmation.VolatilityCap;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("VolatilityCapChoice")
@ImplementedBy(VolatilityCapChoice.Default.class)
public interface VolatilityCapChoice extends Validator<VolatilityCap> {
	
	String NAME = "VolatilityCapChoice";
	String DEFINITION = "optional choice totalVolatilityCap, volatilityCapSequence";
	
	ValidationResult<VolatilityCap> validate(RosettaPath path, VolatilityCap volatilityCap);
	
	class Default implements VolatilityCapChoice {
	
		@Override
		public ValidationResult<VolatilityCap> validate(RosettaPath path, VolatilityCap volatilityCap) {
			ComparisonResult result = executeDataRule(volatilityCap);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "VolatilityCap", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "VolatilityCap", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(VolatilityCap volatilityCap) {
			try {
				return choice(MapperS.of(volatilityCap), Arrays.asList("totalVolatilityCap", "volatilityCapSequence"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements VolatilityCapChoice {
	
		@Override
		public ValidationResult<VolatilityCap> validate(RosettaPath path, VolatilityCap volatilityCap) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "VolatilityCap", path, DEFINITION);
		}
	}
}
