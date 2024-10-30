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
import fpml.confirmation.FxTargetConstantPayoff;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("FxTargetConstantPayoffChoice")
@ImplementedBy(FxTargetConstantPayoffChoice.Default.class)
public interface FxTargetConstantPayoffChoice extends Validator<FxTargetConstantPayoff> {
	
	String NAME = "FxTargetConstantPayoffChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<FxTargetConstantPayoff> validate(RosettaPath path, FxTargetConstantPayoff fxTargetConstantPayoff);
	
	class Default implements FxTargetConstantPayoffChoice {
	
		@Override
		public ValidationResult<FxTargetConstantPayoff> validate(RosettaPath path, FxTargetConstantPayoff fxTargetConstantPayoff) {
			ComparisonResult result = executeDataRule(fxTargetConstantPayoff);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTargetConstantPayoff", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxTargetConstantPayoff", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxTargetConstantPayoff fxTargetConstantPayoff) {
			try {
				return choice(MapperS.of(fxTargetConstantPayoff), Arrays.asList("fxTargetConstantPayoffSequence", "fixingAdjustment"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxTargetConstantPayoffChoice {
	
		@Override
		public ValidationResult<FxTargetConstantPayoff> validate(RosettaPath path, FxTargetConstantPayoff fxTargetConstantPayoff) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTargetConstantPayoff", path, DEFINITION);
		}
	}
}
