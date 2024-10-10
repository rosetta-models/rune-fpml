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
import fpml.confirmation.FxKnockoutLevel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("FxKnockoutLevelChoice")
@ImplementedBy(FxKnockoutLevelChoice.Default.class)
public interface FxKnockoutLevelChoice extends Validator<FxKnockoutLevel> {
	
	String NAME = "FxKnockoutLevelChoice";
	String DEFINITION = "required choice amount, intrinsicValue";
	
	ValidationResult<FxKnockoutLevel> validate(RosettaPath path, FxKnockoutLevel fxKnockoutLevel);
	
	class Default implements FxKnockoutLevelChoice {
	
		@Override
		public ValidationResult<FxKnockoutLevel> validate(RosettaPath path, FxKnockoutLevel fxKnockoutLevel) {
			ComparisonResult result = executeDataRule(fxKnockoutLevel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxKnockoutLevel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxKnockoutLevel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxKnockoutLevel fxKnockoutLevel) {
			try {
				return choice(MapperS.of(fxKnockoutLevel), Arrays.asList("amount", "intrinsicValue"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxKnockoutLevelChoice {
	
		@Override
		public ValidationResult<FxKnockoutLevel> validate(RosettaPath path, FxKnockoutLevel fxKnockoutLevel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxKnockoutLevel", path, DEFINITION);
		}
	}
}
