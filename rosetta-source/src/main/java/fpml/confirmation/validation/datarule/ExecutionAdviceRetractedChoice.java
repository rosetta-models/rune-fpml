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
import fpml.confirmation.ExecutionAdviceRetracted;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("ExecutionAdviceRetractedChoice")
@ImplementedBy(ExecutionAdviceRetractedChoice.Default.class)
public interface ExecutionAdviceRetractedChoice extends Validator<ExecutionAdviceRetracted> {
	
	String NAME = "ExecutionAdviceRetractedChoice";
	String DEFINITION = "optional choice tradingEventsBaseModel, postTradeEventsBaseModel , changeEventsBaseModel , optionsEventsBaseModel , additionalEvent";
	
	ValidationResult<ExecutionAdviceRetracted> validate(RosettaPath path, ExecutionAdviceRetracted executionAdviceRetracted);
	
	class Default implements ExecutionAdviceRetractedChoice {
	
		@Override
		public ValidationResult<ExecutionAdviceRetracted> validate(RosettaPath path, ExecutionAdviceRetracted executionAdviceRetracted) {
			ComparisonResult result = executeDataRule(executionAdviceRetracted);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ExecutionAdviceRetracted", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "ExecutionAdviceRetracted", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(ExecutionAdviceRetracted executionAdviceRetracted) {
			try {
				return choice(MapperS.of(executionAdviceRetracted), Arrays.asList("tradingEventsBaseModel", "postTradeEventsBaseModel", "changeEventsBaseModel", "optionsEventsBaseModel", "additionalEvent"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ExecutionAdviceRetractedChoice {
	
		@Override
		public ValidationResult<ExecutionAdviceRetracted> validate(RosettaPath path, ExecutionAdviceRetracted executionAdviceRetracted) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ExecutionAdviceRetracted", path, DEFINITION);
		}
	}
}
