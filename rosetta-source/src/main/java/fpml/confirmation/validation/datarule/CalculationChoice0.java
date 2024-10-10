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
import fpml.confirmation.Calculation;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CalculationChoice0")
@ImplementedBy(CalculationChoice0.Default.class)
public interface CalculationChoice0 extends Validator<Calculation> {
	
	String NAME = "CalculationChoice0";
	String DEFINITION = "required choice notionalSchedule, fxLinkedNotionalSchedule";
	
	ValidationResult<Calculation> validate(RosettaPath path, Calculation calculation);
	
	class Default implements CalculationChoice0 {
	
		@Override
		public ValidationResult<Calculation> validate(RosettaPath path, Calculation calculation) {
			ComparisonResult result = executeDataRule(calculation);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Calculation", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "Calculation", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(Calculation calculation) {
			try {
				return choice(MapperS.of(calculation), Arrays.asList("notionalSchedule", "fxLinkedNotionalSchedule"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CalculationChoice0 {
	
		@Override
		public ValidationResult<Calculation> validate(RosettaPath path, Calculation calculation) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Calculation", path, DEFINITION);
		}
	}
}
