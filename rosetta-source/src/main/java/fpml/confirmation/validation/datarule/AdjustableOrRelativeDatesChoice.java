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
import fpml.confirmation.AdjustableOrRelativeDates;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("AdjustableOrRelativeDatesChoice")
@ImplementedBy(AdjustableOrRelativeDatesChoice.Default.class)
public interface AdjustableOrRelativeDatesChoice extends Validator<AdjustableOrRelativeDates> {
	
	String NAME = "AdjustableOrRelativeDatesChoice";
	String DEFINITION = "required choice adjustableDates, relativeDates";
	
	ValidationResult<AdjustableOrRelativeDates> validate(RosettaPath path, AdjustableOrRelativeDates adjustableOrRelativeDates);
	
	class Default implements AdjustableOrRelativeDatesChoice {
	
		@Override
		public ValidationResult<AdjustableOrRelativeDates> validate(RosettaPath path, AdjustableOrRelativeDates adjustableOrRelativeDates) {
			ComparisonResult result = executeDataRule(adjustableOrRelativeDates);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AdjustableOrRelativeDates", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "AdjustableOrRelativeDates", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(AdjustableOrRelativeDates adjustableOrRelativeDates) {
			try {
				return choice(MapperS.of(adjustableOrRelativeDates), Arrays.asList("adjustableDates", "relativeDates"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AdjustableOrRelativeDatesChoice {
	
		@Override
		public ValidationResult<AdjustableOrRelativeDates> validate(RosettaPath path, AdjustableOrRelativeDates adjustableOrRelativeDates) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AdjustableOrRelativeDates", path, DEFINITION);
		}
	}
}
