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
import fpml.confirmation.ConfirmationRetracted;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("ConfirmationRetractedChoice")
@ImplementedBy(ConfirmationRetractedChoice.Default.class)
public interface ConfirmationRetractedChoice extends Validator<ConfirmationRetracted> {
	
	String NAME = "ConfirmationRetractedChoice";
	String DEFINITION = "optional choice tradingAndPostTradeEventsModel, optionExercise";
	
	ValidationResult<ConfirmationRetracted> validate(RosettaPath path, ConfirmationRetracted confirmationRetracted);
	
	class Default implements ConfirmationRetractedChoice {
	
		@Override
		public ValidationResult<ConfirmationRetracted> validate(RosettaPath path, ConfirmationRetracted confirmationRetracted) {
			ComparisonResult result = executeDataRule(confirmationRetracted);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ConfirmationRetracted", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "ConfirmationRetracted", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(ConfirmationRetracted confirmationRetracted) {
			try {
				return choice(MapperS.of(confirmationRetracted), Arrays.asList("tradingAndPostTradeEventsModel", "optionExercise"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ConfirmationRetractedChoice {
	
		@Override
		public ValidationResult<ConfirmationRetracted> validate(RosettaPath path, ConfirmationRetracted confirmationRetracted) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ConfirmationRetracted", path, DEFINITION);
		}
	}
}
