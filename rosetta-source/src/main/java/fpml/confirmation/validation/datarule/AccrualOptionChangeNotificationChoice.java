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
import fpml.confirmation.AccrualOptionChangeNotification;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("AccrualOptionChangeNotificationChoice")
@ImplementedBy(AccrualOptionChangeNotificationChoice.Default.class)
public interface AccrualOptionChangeNotificationChoice extends Validator<AccrualOptionChangeNotification> {
	
	String NAME = "AccrualOptionChangeNotificationChoice";
	String DEFINITION = "required choice accrualOptionChangeNotificationSequence0, accruingPikOptionChange , accrualOptionChangeNotificationSequence1";
	
	ValidationResult<AccrualOptionChangeNotification> validate(RosettaPath path, AccrualOptionChangeNotification accrualOptionChangeNotification);
	
	class Default implements AccrualOptionChangeNotificationChoice {
	
		@Override
		public ValidationResult<AccrualOptionChangeNotification> validate(RosettaPath path, AccrualOptionChangeNotification accrualOptionChangeNotification) {
			ComparisonResult result = executeDataRule(accrualOptionChangeNotification);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AccrualOptionChangeNotification", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "AccrualOptionChangeNotification", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(AccrualOptionChangeNotification accrualOptionChangeNotification) {
			try {
				return choice(MapperS.of(accrualOptionChangeNotification), Arrays.asList("accrualOptionChangeNotificationSequence0", "accruingPikOptionChange", "accrualOptionChangeNotificationSequence1"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AccrualOptionChangeNotificationChoice {
	
		@Override
		public ValidationResult<AccrualOptionChangeNotification> validate(RosettaPath path, AccrualOptionChangeNotification accrualOptionChangeNotification) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AccrualOptionChangeNotification", path, DEFINITION);
		}
	}
}
