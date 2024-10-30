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
import fpml.confirmation.CalculationAgent;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CalculationAgentChoice")
@ImplementedBy(CalculationAgentChoice.Default.class)
public interface CalculationAgentChoice extends Validator<CalculationAgent> {
	
	String NAME = "CalculationAgentChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<CalculationAgent> validate(RosettaPath path, CalculationAgent calculationAgent);
	
	class Default implements CalculationAgentChoice {
	
		@Override
		public ValidationResult<CalculationAgent> validate(RosettaPath path, CalculationAgent calculationAgent) {
			ComparisonResult result = executeDataRule(calculationAgent);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CalculationAgent", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CalculationAgent", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CalculationAgent calculationAgent) {
			try {
				return choice(MapperS.of(calculationAgent), Arrays.asList("calculationAgentPartyReference", "calculationAgentParty"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CalculationAgentChoice {
	
		@Override
		public ValidationResult<CalculationAgent> validate(RosettaPath path, CalculationAgent calculationAgent) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CalculationAgent", path, DEFINITION);
		}
	}
}
