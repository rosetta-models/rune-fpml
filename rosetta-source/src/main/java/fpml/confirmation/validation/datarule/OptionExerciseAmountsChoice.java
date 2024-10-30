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
import fpml.confirmation.OptionExerciseAmounts;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("OptionExerciseAmountsChoice")
@ImplementedBy(OptionExerciseAmountsChoice.Default.class)
public interface OptionExerciseAmountsChoice extends Validator<OptionExerciseAmounts> {
	
	String NAME = "OptionExerciseAmountsChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<OptionExerciseAmounts> validate(RosettaPath path, OptionExerciseAmounts optionExerciseAmounts);
	
	class Default implements OptionExerciseAmountsChoice {
	
		@Override
		public ValidationResult<OptionExerciseAmounts> validate(RosettaPath path, OptionExerciseAmounts optionExerciseAmounts) {
			ComparisonResult result = executeDataRule(optionExerciseAmounts);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionExerciseAmounts", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "OptionExerciseAmounts", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(OptionExerciseAmounts optionExerciseAmounts) {
			try {
				return choice(MapperS.of(optionExerciseAmounts), Arrays.asList("optionExerciseAmountsSequence0", "optionExerciseAmountsSequence1", "optionExerciseAmountsSequence2", "optionExerciseAmountsSequence3"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OptionExerciseAmountsChoice {
	
		@Override
		public ValidationResult<OptionExerciseAmounts> validate(RosettaPath path, OptionExerciseAmounts optionExerciseAmounts) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionExerciseAmounts", path, DEFINITION);
		}
	}
}
