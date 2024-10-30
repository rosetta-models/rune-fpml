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
import fpml.confirmation.ConfirmationStatus;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("ConfirmationStatusChoice")
@ImplementedBy(ConfirmationStatusChoice.Default.class)
public interface ConfirmationStatusChoice extends Validator<ConfirmationStatus> {
	
	String NAME = "ConfirmationStatusChoice";
	String DEFINITION = "required choice confirmationStatusSequence, allegedEvent";
	
	ValidationResult<ConfirmationStatus> validate(RosettaPath path, ConfirmationStatus confirmationStatus);
	
	class Default implements ConfirmationStatusChoice {
	
		@Override
		public ValidationResult<ConfirmationStatus> validate(RosettaPath path, ConfirmationStatus confirmationStatus) {
			ComparisonResult result = executeDataRule(confirmationStatus);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ConfirmationStatus", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "ConfirmationStatus", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(ConfirmationStatus confirmationStatus) {
			try {
				return choice(MapperS.of(confirmationStatus), Arrays.asList("confirmationStatusSequence", "allegedEvent"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ConfirmationStatusChoice {
	
		@Override
		public ValidationResult<ConfirmationStatus> validate(RosettaPath path, ConfirmationStatus confirmationStatus) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ConfirmationStatus", path, DEFINITION);
		}
	}
}
