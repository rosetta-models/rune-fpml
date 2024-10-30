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
import fpml.confirmation.TriggerChoice;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("TriggerChoiceChoice")
@ImplementedBy(TriggerChoiceChoice.Default.class)
public interface TriggerChoiceChoice extends Validator<TriggerChoice> {
	
	String NAME = "TriggerChoiceChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<TriggerChoice> validate(RosettaPath path, TriggerChoice triggerChoice);
	
	class Default implements TriggerChoiceChoice {
	
		@Override
		public ValidationResult<TriggerChoice> validate(RosettaPath path, TriggerChoice triggerChoice) {
			ComparisonResult result = executeDataRule(triggerChoice);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TriggerChoice", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "TriggerChoice", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(TriggerChoice triggerChoice) {
			try {
				return choice(MapperS.of(triggerChoice), Arrays.asList("creditEvents", "creditEventsReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TriggerChoiceChoice {
	
		@Override
		public ValidationResult<TriggerChoice> validate(RosettaPath path, TriggerChoice triggerChoice) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TriggerChoice", path, DEFINITION);
		}
	}
}
