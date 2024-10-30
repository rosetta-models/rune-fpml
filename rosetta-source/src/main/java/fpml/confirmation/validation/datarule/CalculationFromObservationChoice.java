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
import fpml.confirmation.CalculationFromObservation;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CalculationFromObservationChoice")
@ImplementedBy(CalculationFromObservationChoice.Default.class)
public interface CalculationFromObservationChoice extends Validator<CalculationFromObservation> {
	
	String NAME = "CalculationFromObservationChoice";
	String DEFINITION = "required choice calculationFromObservationChoice, closingLevel , expiringLevel";
	
	ValidationResult<CalculationFromObservation> validate(RosettaPath path, CalculationFromObservation calculationFromObservation);
	
	class Default implements CalculationFromObservationChoice {
	
		@Override
		public ValidationResult<CalculationFromObservation> validate(RosettaPath path, CalculationFromObservation calculationFromObservation) {
			ComparisonResult result = executeDataRule(calculationFromObservation);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CalculationFromObservation", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CalculationFromObservation", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CalculationFromObservation calculationFromObservation) {
			try {
				return choice(MapperS.of(calculationFromObservation), Arrays.asList("calculationFromObservationChoice", "closingLevel", "expiringLevel"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CalculationFromObservationChoice {
	
		@Override
		public ValidationResult<CalculationFromObservation> validate(RosettaPath path, CalculationFromObservation calculationFromObservation) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CalculationFromObservation", path, DEFINITION);
		}
	}
}
