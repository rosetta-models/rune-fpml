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
import fpml.confirmation.RequestExecutionRetracted;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("RequestExecutionRetractedChoice")
@ImplementedBy(RequestExecutionRetractedChoice.Default.class)
public interface RequestExecutionRetractedChoice extends Validator<RequestExecutionRetracted> {
	
	String NAME = "RequestExecutionRetractedChoice";
	String DEFINITION = "optional choice tradingEventsModel, optionExercise";
	
	ValidationResult<RequestExecutionRetracted> validate(RosettaPath path, RequestExecutionRetracted requestExecutionRetracted);
	
	class Default implements RequestExecutionRetractedChoice {
	
		@Override
		public ValidationResult<RequestExecutionRetracted> validate(RosettaPath path, RequestExecutionRetracted requestExecutionRetracted) {
			ComparisonResult result = executeDataRule(requestExecutionRetracted);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RequestExecutionRetracted", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "RequestExecutionRetracted", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(RequestExecutionRetracted requestExecutionRetracted) {
			try {
				return choice(MapperS.of(requestExecutionRetracted), Arrays.asList("tradingEventsModel", "optionExercise"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RequestExecutionRetractedChoice {
	
		@Override
		public ValidationResult<RequestExecutionRetracted> validate(RosettaPath path, RequestExecutionRetracted requestExecutionRetracted) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RequestExecutionRetracted", path, DEFINITION);
		}
	}
}
