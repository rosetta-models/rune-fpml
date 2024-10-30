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
import fpml.confirmation.FxTargetLeverage;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("FxTargetLeverageChoice")
@ImplementedBy(FxTargetLeverageChoice.Default.class)
public interface FxTargetLeverageChoice extends Validator<FxTargetLeverage> {
	
	String NAME = "FxTargetLeverageChoice";
	String DEFINITION = "required choice ratio, fxTargetLeverageSequence";
	
	ValidationResult<FxTargetLeverage> validate(RosettaPath path, FxTargetLeverage fxTargetLeverage);
	
	class Default implements FxTargetLeverageChoice {
	
		@Override
		public ValidationResult<FxTargetLeverage> validate(RosettaPath path, FxTargetLeverage fxTargetLeverage) {
			ComparisonResult result = executeDataRule(fxTargetLeverage);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTargetLeverage", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxTargetLeverage", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxTargetLeverage fxTargetLeverage) {
			try {
				return choice(MapperS.of(fxTargetLeverage), Arrays.asList("ratio", "fxTargetLeverageSequence"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxTargetLeverageChoice {
	
		@Override
		public ValidationResult<FxTargetLeverage> validate(RosettaPath path, FxTargetLeverage fxTargetLeverage) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTargetLeverage", path, DEFINITION);
		}
	}
}
