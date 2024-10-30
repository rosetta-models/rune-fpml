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
import fpml.confirmation.ExerciseProcedure;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("ExerciseProcedureChoice")
@ImplementedBy(ExerciseProcedureChoice.Default.class)
public interface ExerciseProcedureChoice extends Validator<ExerciseProcedure> {
	
	String NAME = "ExerciseProcedureChoice";
	String DEFINITION = "required choice manualExercise, automaticExercise";
	
	ValidationResult<ExerciseProcedure> validate(RosettaPath path, ExerciseProcedure exerciseProcedure);
	
	class Default implements ExerciseProcedureChoice {
	
		@Override
		public ValidationResult<ExerciseProcedure> validate(RosettaPath path, ExerciseProcedure exerciseProcedure) {
			ComparisonResult result = executeDataRule(exerciseProcedure);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ExerciseProcedure", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "ExerciseProcedure", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(ExerciseProcedure exerciseProcedure) {
			try {
				return choice(MapperS.of(exerciseProcedure), Arrays.asList("manualExercise", "automaticExercise"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ExerciseProcedureChoice {
	
		@Override
		public ValidationResult<ExerciseProcedure> validate(RosettaPath path, ExerciseProcedure exerciseProcedure) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ExerciseProcedure", path, DEFINITION);
		}
	}
}
