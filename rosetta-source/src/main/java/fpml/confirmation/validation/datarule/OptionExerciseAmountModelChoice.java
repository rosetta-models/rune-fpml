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
import fpml.confirmation.OptionExerciseAmountModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("OptionExerciseAmountModelChoice")
@ImplementedBy(OptionExerciseAmountModelChoice.Default.class)
public interface OptionExerciseAmountModelChoice extends Validator<OptionExerciseAmountModel> {
	
	String NAME = "OptionExerciseAmountModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<OptionExerciseAmountModel> validate(RosettaPath path, OptionExerciseAmountModel optionExerciseAmountModel);
	
	class Default implements OptionExerciseAmountModelChoice {
	
		@Override
		public ValidationResult<OptionExerciseAmountModel> validate(RosettaPath path, OptionExerciseAmountModel optionExerciseAmountModel) {
			ComparisonResult result = executeDataRule(optionExerciseAmountModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionExerciseAmountModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "OptionExerciseAmountModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(OptionExerciseAmountModel optionExerciseAmountModel) {
			try {
				return choice(MapperS.of(optionExerciseAmountModel), Arrays.asList("exerciseAction", "expiry", "fullExercise", "optionExerciseAmountModelSequence0", "optionExerciseAmountModelSequence1", "optionExerciseAmountModelSequence2", "specifiedExercise"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OptionExerciseAmountModelChoice {
	
		@Override
		public ValidationResult<OptionExerciseAmountModel> validate(RosettaPath path, OptionExerciseAmountModel optionExerciseAmountModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionExerciseAmountModel", path, DEFINITION);
		}
	}
}
