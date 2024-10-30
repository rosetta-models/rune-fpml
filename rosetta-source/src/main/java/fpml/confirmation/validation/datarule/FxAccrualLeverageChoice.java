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
import fpml.confirmation.FxAccrualLeverage;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("FxAccrualLeverageChoice")
@ImplementedBy(FxAccrualLeverageChoice.Default.class)
public interface FxAccrualLeverageChoice extends Validator<FxAccrualLeverage> {
	
	String NAME = "FxAccrualLeverageChoice";
	String DEFINITION = "required choice ratio, fxAccrualLeverageSequence";
	
	ValidationResult<FxAccrualLeverage> validate(RosettaPath path, FxAccrualLeverage fxAccrualLeverage);
	
	class Default implements FxAccrualLeverageChoice {
	
		@Override
		public ValidationResult<FxAccrualLeverage> validate(RosettaPath path, FxAccrualLeverage fxAccrualLeverage) {
			ComparisonResult result = executeDataRule(fxAccrualLeverage);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAccrualLeverage", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxAccrualLeverage", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxAccrualLeverage fxAccrualLeverage) {
			try {
				return choice(MapperS.of(fxAccrualLeverage), Arrays.asList("ratio", "fxAccrualLeverageSequence"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxAccrualLeverageChoice {
	
		@Override
		public ValidationResult<FxAccrualLeverage> validate(RosettaPath path, FxAccrualLeverage fxAccrualLeverage) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAccrualLeverage", path, DEFINITION);
		}
	}
}
