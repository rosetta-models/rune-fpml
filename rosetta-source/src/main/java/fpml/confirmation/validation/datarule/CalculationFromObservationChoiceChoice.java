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
import fpml.confirmation.CalculationFromObservationChoice;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CalculationFromObservationChoiceChoice")
@ImplementedBy(CalculationFromObservationChoiceChoice.Default.class)
public interface CalculationFromObservationChoiceChoice extends Validator<CalculationFromObservationChoice> {
	
	String NAME = "CalculationFromObservationChoiceChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<CalculationFromObservationChoice> validate(RosettaPath path, CalculationFromObservationChoice calculationFromObservationChoice);
	
	class Default implements CalculationFromObservationChoiceChoice {
	
		@Override
		public ValidationResult<CalculationFromObservationChoice> validate(RosettaPath path, CalculationFromObservationChoice calculationFromObservationChoice) {
			ComparisonResult result = executeDataRule(calculationFromObservationChoice);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CalculationFromObservationChoice", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CalculationFromObservationChoice", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CalculationFromObservationChoice calculationFromObservationChoice) {
			try {
				return choice(MapperS.of(calculationFromObservationChoice), Arrays.asList("calculationFromObservationChoiceSequence", "initialLevelSource"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CalculationFromObservationChoiceChoice {
	
		@Override
		public ValidationResult<CalculationFromObservationChoice> validate(RosettaPath path, CalculationFromObservationChoice calculationFromObservationChoice) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CalculationFromObservationChoice", path, DEFINITION);
		}
	}
}
