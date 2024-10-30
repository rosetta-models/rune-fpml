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
import fpml.confirmation.ExerciseFee;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("ExerciseFeeChoice")
@ImplementedBy(ExerciseFeeChoice.Default.class)
public interface ExerciseFeeChoice extends Validator<ExerciseFee> {
	
	String NAME = "ExerciseFeeChoice";
	String DEFINITION = "required choice feeAmount, feeRate";
	
	ValidationResult<ExerciseFee> validate(RosettaPath path, ExerciseFee exerciseFee);
	
	class Default implements ExerciseFeeChoice {
	
		@Override
		public ValidationResult<ExerciseFee> validate(RosettaPath path, ExerciseFee exerciseFee) {
			ComparisonResult result = executeDataRule(exerciseFee);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ExerciseFee", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "ExerciseFee", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(ExerciseFee exerciseFee) {
			try {
				return choice(MapperS.of(exerciseFee), Arrays.asList("feeAmount", "feeRate"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ExerciseFeeChoice {
	
		@Override
		public ValidationResult<ExerciseFee> validate(RosettaPath path, ExerciseFee exerciseFee) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ExerciseFee", path, DEFINITION);
		}
	}
}
