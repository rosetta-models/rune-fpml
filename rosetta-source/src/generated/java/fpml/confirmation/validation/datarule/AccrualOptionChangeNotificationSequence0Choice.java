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
import fpml.confirmation.AccrualOptionChangeNotificationSequence0;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("AccrualOptionChangeNotificationSequence0Choice")
@ImplementedBy(AccrualOptionChangeNotificationSequence0Choice.Default.class)
public interface AccrualOptionChangeNotificationSequence0Choice extends Validator<AccrualOptionChangeNotificationSequence0> {
	
	String NAME = "AccrualOptionChangeNotificationSequence0Choice";
	String DEFINITION = "required choice fixedRateOptionChange, floatingRateOptionChange";
	
	ValidationResult<AccrualOptionChangeNotificationSequence0> validate(RosettaPath path, AccrualOptionChangeNotificationSequence0 accrualOptionChangeNotificationSequence0);
	
	class Default implements AccrualOptionChangeNotificationSequence0Choice {
	
		@Override
		public ValidationResult<AccrualOptionChangeNotificationSequence0> validate(RosettaPath path, AccrualOptionChangeNotificationSequence0 accrualOptionChangeNotificationSequence0) {
			ComparisonResult result = executeDataRule(accrualOptionChangeNotificationSequence0);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AccrualOptionChangeNotificationSequence0", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "AccrualOptionChangeNotificationSequence0", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(AccrualOptionChangeNotificationSequence0 accrualOptionChangeNotificationSequence0) {
			try {
				return choice(MapperS.of(accrualOptionChangeNotificationSequence0), Arrays.asList("fixedRateOptionChange", "floatingRateOptionChange"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AccrualOptionChangeNotificationSequence0Choice {
	
		@Override
		public ValidationResult<AccrualOptionChangeNotificationSequence0> validate(RosettaPath path, AccrualOptionChangeNotificationSequence0 accrualOptionChangeNotificationSequence0) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AccrualOptionChangeNotificationSequence0", path, DEFINITION);
		}
	}
}
