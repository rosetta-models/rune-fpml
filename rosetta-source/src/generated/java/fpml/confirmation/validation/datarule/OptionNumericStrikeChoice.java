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
import fpml.confirmation.OptionNumericStrike;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("OptionNumericStrikeChoice")
@ImplementedBy(OptionNumericStrikeChoice.Default.class)
public interface OptionNumericStrikeChoice extends Validator<OptionNumericStrike> {
	
	String NAME = "OptionNumericStrikeChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<OptionNumericStrike> validate(RosettaPath path, OptionNumericStrike optionNumericStrike);
	
	class Default implements OptionNumericStrikeChoice {
	
		@Override
		public ValidationResult<OptionNumericStrike> validate(RosettaPath path, OptionNumericStrike optionNumericStrike) {
			ComparisonResult result = executeDataRule(optionNumericStrike);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionNumericStrike", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "OptionNumericStrike", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(OptionNumericStrike optionNumericStrike) {
			try {
				return choice(MapperS.of(optionNumericStrike), Arrays.asList("strikePrice", "strikePercentage"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OptionNumericStrikeChoice {
	
		@Override
		public ValidationResult<OptionNumericStrike> validate(RosettaPath path, OptionNumericStrike optionNumericStrike) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionNumericStrike", path, DEFINITION);
		}
	}
}
