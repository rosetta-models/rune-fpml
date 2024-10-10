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
import fpml.confirmation.RequestConfirmation;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("RequestConfirmationChoice")
@ImplementedBy(RequestConfirmationChoice.Default.class)
public interface RequestConfirmationChoice extends Validator<RequestConfirmation> {
	
	String NAME = "RequestConfirmationChoice";
	String DEFINITION = "required choice tradingAndPostTradeEventsModel, optionExercise";
	
	ValidationResult<RequestConfirmation> validate(RosettaPath path, RequestConfirmation requestConfirmation);
	
	class Default implements RequestConfirmationChoice {
	
		@Override
		public ValidationResult<RequestConfirmation> validate(RosettaPath path, RequestConfirmation requestConfirmation) {
			ComparisonResult result = executeDataRule(requestConfirmation);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RequestConfirmation", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "RequestConfirmation", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(RequestConfirmation requestConfirmation) {
			try {
				return choice(MapperS.of(requestConfirmation), Arrays.asList("tradingAndPostTradeEventsModel", "optionExercise"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RequestConfirmationChoice {
	
		@Override
		public ValidationResult<RequestConfirmation> validate(RosettaPath path, RequestConfirmation requestConfirmation) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RequestConfirmation", path, DEFINITION);
		}
	}
}
