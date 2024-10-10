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
import fpml.confirmation.PartialExerciseModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("PartialExerciseModelChoice")
@ImplementedBy(PartialExerciseModelChoice.Default.class)
public interface PartialExerciseModelChoice extends Validator<PartialExerciseModel> {
	
	String NAME = "PartialExerciseModelChoice";
	String DEFINITION = "required choice minimumNotionalAmount, minimumNumberOfOptions";
	
	ValidationResult<PartialExerciseModel> validate(RosettaPath path, PartialExerciseModel partialExerciseModel);
	
	class Default implements PartialExerciseModelChoice {
	
		@Override
		public ValidationResult<PartialExerciseModel> validate(RosettaPath path, PartialExerciseModel partialExerciseModel) {
			ComparisonResult result = executeDataRule(partialExerciseModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PartialExerciseModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "PartialExerciseModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(PartialExerciseModel partialExerciseModel) {
			try {
				return choice(MapperS.of(partialExerciseModel), Arrays.asList("minimumNotionalAmount", "minimumNumberOfOptions"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PartialExerciseModelChoice {
	
		@Override
		public ValidationResult<PartialExerciseModel> validate(RosettaPath path, PartialExerciseModel partialExerciseModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PartialExerciseModel", path, DEFINITION);
		}
	}
}
