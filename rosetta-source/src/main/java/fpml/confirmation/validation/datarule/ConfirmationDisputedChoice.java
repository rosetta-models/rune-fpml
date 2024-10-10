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
import fpml.confirmation.ConfirmationDisputed;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("ConfirmationDisputedChoice")
@ImplementedBy(ConfirmationDisputedChoice.Default.class)
public interface ConfirmationDisputedChoice extends Validator<ConfirmationDisputed> {
	
	String NAME = "ConfirmationDisputedChoice";
	String DEFINITION = "optional choice tradingEventsBaseModel, postTradeEventsBaseModel , changeEventsBaseModel , optionsEventsBaseModel , additionalEvent";
	
	ValidationResult<ConfirmationDisputed> validate(RosettaPath path, ConfirmationDisputed confirmationDisputed);
	
	class Default implements ConfirmationDisputedChoice {
	
		@Override
		public ValidationResult<ConfirmationDisputed> validate(RosettaPath path, ConfirmationDisputed confirmationDisputed) {
			ComparisonResult result = executeDataRule(confirmationDisputed);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ConfirmationDisputed", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "ConfirmationDisputed", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(ConfirmationDisputed confirmationDisputed) {
			try {
				return choice(MapperS.of(confirmationDisputed), Arrays.asList("tradingEventsBaseModel", "postTradeEventsBaseModel", "changeEventsBaseModel", "optionsEventsBaseModel", "additionalEvent"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ConfirmationDisputedChoice {
	
		@Override
		public ValidationResult<ConfirmationDisputed> validate(RosettaPath path, ConfirmationDisputed confirmationDisputed) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ConfirmationDisputed", path, DEFINITION);
		}
	}
}
