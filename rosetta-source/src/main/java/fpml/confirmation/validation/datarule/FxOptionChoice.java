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
import fpml.confirmation.FxOption;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("FxOptionChoice")
@ImplementedBy(FxOptionChoice.Default.class)
public interface FxOptionChoice extends Validator<FxOption> {
	
	String NAME = "FxOptionChoice";
	String DEFINITION = "required choice americanExercise, europeanExercise";
	
	ValidationResult<FxOption> validate(RosettaPath path, FxOption fxOption);
	
	class Default implements FxOptionChoice {
	
		@Override
		public ValidationResult<FxOption> validate(RosettaPath path, FxOption fxOption) {
			ComparisonResult result = executeDataRule(fxOption);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxOption", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxOption", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxOption fxOption) {
			try {
				return choice(MapperS.of(fxOption), Arrays.asList("americanExercise", "europeanExercise"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxOptionChoice {
	
		@Override
		public ValidationResult<FxOption> validate(RosettaPath path, FxOption fxOption) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxOption", path, DEFINITION);
		}
	}
}
