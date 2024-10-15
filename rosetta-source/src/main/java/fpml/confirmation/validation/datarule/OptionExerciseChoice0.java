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
import fpml.confirmation.OptionExercise;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("OptionExerciseChoice0")
@ImplementedBy(OptionExerciseChoice0.Default.class)
public interface OptionExerciseChoice0 extends Validator<OptionExercise> {
	
	String NAME = "OptionExerciseChoice0";
	String DEFINITION = "required choice originalTrade, tradeIdentifier";
	
	ValidationResult<OptionExercise> validate(RosettaPath path, OptionExercise optionExercise);
	
	class Default implements OptionExerciseChoice0 {
	
		@Override
		public ValidationResult<OptionExercise> validate(RosettaPath path, OptionExercise optionExercise) {
			ComparisonResult result = executeDataRule(optionExercise);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionExercise", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "OptionExercise", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(OptionExercise optionExercise) {
			try {
				return choice(MapperS.of(optionExercise), Arrays.asList("originalTrade", "tradeIdentifier"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OptionExerciseChoice0 {
	
		@Override
		public ValidationResult<OptionExercise> validate(RosettaPath path, OptionExercise optionExercise) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionExercise", path, DEFINITION);
		}
	}
}
