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
import fpml.confirmation.ExecutionAdvice;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("ExecutionAdviceChoice")
@ImplementedBy(ExecutionAdviceChoice.Default.class)
public interface ExecutionAdviceChoice extends Validator<ExecutionAdvice> {
	
	String NAME = "ExecutionAdviceChoice";
	String DEFINITION = "required choice tradingEventsBaseModel, postTradeEventsBaseModel , changeEventsBaseModel , optionsEventsBaseModel , additionalEvent";
	
	ValidationResult<ExecutionAdvice> validate(RosettaPath path, ExecutionAdvice executionAdvice);
	
	class Default implements ExecutionAdviceChoice {
	
		@Override
		public ValidationResult<ExecutionAdvice> validate(RosettaPath path, ExecutionAdvice executionAdvice) {
			ComparisonResult result = executeDataRule(executionAdvice);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ExecutionAdvice", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "ExecutionAdvice", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(ExecutionAdvice executionAdvice) {
			try {
				return choice(MapperS.of(executionAdvice), Arrays.asList("tradingEventsBaseModel", "postTradeEventsBaseModel", "changeEventsBaseModel", "optionsEventsBaseModel", "additionalEvent"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ExecutionAdviceChoice {
	
		@Override
		public ValidationResult<ExecutionAdvice> validate(RosettaPath path, ExecutionAdvice executionAdvice) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ExecutionAdvice", path, DEFINITION);
		}
	}
}
