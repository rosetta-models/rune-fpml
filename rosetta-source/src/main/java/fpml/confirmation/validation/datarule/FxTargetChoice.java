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
import fpml.confirmation.FxTarget;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("FxTargetChoice")
@ImplementedBy(FxTargetChoice.Default.class)
public interface FxTargetChoice extends Validator<FxTarget> {
	
	String NAME = "FxTargetChoice";
	String DEFINITION = "required choice knockoutLevel, knockoutCount";
	
	ValidationResult<FxTarget> validate(RosettaPath path, FxTarget fxTarget);
	
	class Default implements FxTargetChoice {
	
		@Override
		public ValidationResult<FxTarget> validate(RosettaPath path, FxTarget fxTarget) {
			ComparisonResult result = executeDataRule(fxTarget);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTarget", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxTarget", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxTarget fxTarget) {
			try {
				return choice(MapperS.of(fxTarget), Arrays.asList("knockoutLevel", "knockoutCount"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxTargetChoice {
	
		@Override
		public ValidationResult<FxTarget> validate(RosettaPath path, FxTarget fxTarget) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTarget", path, DEFINITION);
		}
	}
}
