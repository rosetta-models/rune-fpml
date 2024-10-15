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
import fpml.confirmation.ExecutionNotification;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("ExecutionNotificationChoice")
@ImplementedBy(ExecutionNotificationChoice.Default.class)
public interface ExecutionNotificationChoice extends Validator<ExecutionNotification> {
	
	String NAME = "ExecutionNotificationChoice";
	String DEFINITION = "required choice tradingEventsBaseModel, amendment , optionsEventsBaseModel , additionalEvent";
	
	ValidationResult<ExecutionNotification> validate(RosettaPath path, ExecutionNotification executionNotification);
	
	class Default implements ExecutionNotificationChoice {
	
		@Override
		public ValidationResult<ExecutionNotification> validate(RosettaPath path, ExecutionNotification executionNotification) {
			ComparisonResult result = executeDataRule(executionNotification);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ExecutionNotification", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "ExecutionNotification", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(ExecutionNotification executionNotification) {
			try {
				return choice(MapperS.of(executionNotification), Arrays.asList("tradingEventsBaseModel", "amendment", "optionsEventsBaseModel", "additionalEvent"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ExecutionNotificationChoice {
	
		@Override
		public ValidationResult<ExecutionNotification> validate(RosettaPath path, ExecutionNotification executionNotification) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ExecutionNotification", path, DEFINITION);
		}
	}
}
