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
import fpml.confirmation.FxTargetRebate;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("FxTargetRebateChoice")
@ImplementedBy(FxTargetRebateChoice.Default.class)
public interface FxTargetRebateChoice extends Validator<FxTargetRebate> {
	
	String NAME = "FxTargetRebateChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<FxTargetRebate> validate(RosettaPath path, FxTargetRebate fxTargetRebate);
	
	class Default implements FxTargetRebateChoice {
	
		@Override
		public ValidationResult<FxTargetRebate> validate(RosettaPath path, FxTargetRebate fxTargetRebate) {
			ComparisonResult result = executeDataRule(fxTargetRebate);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTargetRebate", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxTargetRebate", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxTargetRebate fxTargetRebate) {
			try {
				return choice(MapperS.of(fxTargetRebate), Arrays.asList("payment", "outstandingGain"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxTargetRebateChoice {
	
		@Override
		public ValidationResult<FxTargetRebate> validate(RosettaPath path, FxTargetRebate fxTargetRebate) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTargetRebate", path, DEFINITION);
		}
	}
}
