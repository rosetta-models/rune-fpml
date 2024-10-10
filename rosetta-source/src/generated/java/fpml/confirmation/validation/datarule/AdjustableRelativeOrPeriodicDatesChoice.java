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
import fpml.confirmation.AdjustableRelativeOrPeriodicDates;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("AdjustableRelativeOrPeriodicDatesChoice")
@ImplementedBy(AdjustableRelativeOrPeriodicDatesChoice.Default.class)
public interface AdjustableRelativeOrPeriodicDatesChoice extends Validator<AdjustableRelativeOrPeriodicDates> {
	
	String NAME = "AdjustableRelativeOrPeriodicDatesChoice";
	String DEFINITION = "required choice adjustableDates, relativeDateSequence , periodicDates";
	
	ValidationResult<AdjustableRelativeOrPeriodicDates> validate(RosettaPath path, AdjustableRelativeOrPeriodicDates adjustableRelativeOrPeriodicDates);
	
	class Default implements AdjustableRelativeOrPeriodicDatesChoice {
	
		@Override
		public ValidationResult<AdjustableRelativeOrPeriodicDates> validate(RosettaPath path, AdjustableRelativeOrPeriodicDates adjustableRelativeOrPeriodicDates) {
			ComparisonResult result = executeDataRule(adjustableRelativeOrPeriodicDates);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AdjustableRelativeOrPeriodicDates", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "AdjustableRelativeOrPeriodicDates", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(AdjustableRelativeOrPeriodicDates adjustableRelativeOrPeriodicDates) {
			try {
				return choice(MapperS.of(adjustableRelativeOrPeriodicDates), Arrays.asList("adjustableDates", "relativeDateSequence", "periodicDates"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AdjustableRelativeOrPeriodicDatesChoice {
	
		@Override
		public ValidationResult<AdjustableRelativeOrPeriodicDates> validate(RosettaPath path, AdjustableRelativeOrPeriodicDates adjustableRelativeOrPeriodicDates) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AdjustableRelativeOrPeriodicDates", path, DEFINITION);
		}
	}
}
