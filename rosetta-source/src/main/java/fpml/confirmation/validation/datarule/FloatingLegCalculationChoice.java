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
import fpml.confirmation.FloatingLegCalculation;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("FloatingLegCalculationChoice")
@ImplementedBy(FloatingLegCalculationChoice.Default.class)
public interface FloatingLegCalculationChoice extends Validator<FloatingLegCalculation> {
	
	String NAME = "FloatingLegCalculationChoice";
	String DEFINITION = "optional choice spread, spreadSchedule , spreadPercentage";
	
	ValidationResult<FloatingLegCalculation> validate(RosettaPath path, FloatingLegCalculation floatingLegCalculation);
	
	class Default implements FloatingLegCalculationChoice {
	
		@Override
		public ValidationResult<FloatingLegCalculation> validate(RosettaPath path, FloatingLegCalculation floatingLegCalculation) {
			ComparisonResult result = executeDataRule(floatingLegCalculation);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FloatingLegCalculation", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FloatingLegCalculation", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FloatingLegCalculation floatingLegCalculation) {
			try {
				return choice(MapperS.of(floatingLegCalculation), Arrays.asList("spread", "spreadSchedule", "spreadPercentage"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FloatingLegCalculationChoice {
	
		@Override
		public ValidationResult<FloatingLegCalculation> validate(RosettaPath path, FloatingLegCalculation floatingLegCalculation) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FloatingLegCalculation", path, DEFINITION);
		}
	}
}
