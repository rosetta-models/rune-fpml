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
import fpml.confirmation.RequestExecution;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("RequestExecutionChoice")
@ImplementedBy(RequestExecutionChoice.Default.class)
public interface RequestExecutionChoice extends Validator<RequestExecution> {
	
	String NAME = "RequestExecutionChoice";
	String DEFINITION = "required choice tradingEventsModel, optionExercise";
	
	ValidationResult<RequestExecution> validate(RosettaPath path, RequestExecution requestExecution);
	
	class Default implements RequestExecutionChoice {
	
		@Override
		public ValidationResult<RequestExecution> validate(RosettaPath path, RequestExecution requestExecution) {
			ComparisonResult result = executeDataRule(requestExecution);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RequestExecution", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "RequestExecution", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(RequestExecution requestExecution) {
			try {
				return choice(MapperS.of(requestExecution), Arrays.asList("tradingEventsModel", "optionExercise"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RequestExecutionChoice {
	
		@Override
		public ValidationResult<RequestExecution> validate(RosettaPath path, RequestExecution requestExecution) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RequestExecution", path, DEFINITION);
		}
	}
}
