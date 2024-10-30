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
import fpml.confirmation.RecoveryRateModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("RecoveryRateModelChoice")
@ImplementedBy(RecoveryRateModelChoice.Default.class)
public interface RecoveryRateModelChoice extends Validator<RecoveryRateModel> {
	
	String NAME = "RecoveryRateModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<RecoveryRateModel> validate(RosettaPath path, RecoveryRateModel recoveryRateModel);
	
	class Default implements RecoveryRateModelChoice {
	
		@Override
		public ValidationResult<RecoveryRateModel> validate(RosettaPath path, RecoveryRateModel recoveryRateModel) {
			ComparisonResult result = executeDataRule(recoveryRateModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RecoveryRateModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "RecoveryRateModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(RecoveryRateModel recoveryRateModel) {
			try {
				return choice(MapperS.of(recoveryRateModel), Arrays.asList("recoveryRate", "recoveryRateCurve"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RecoveryRateModelChoice {
	
		@Override
		public ValidationResult<RecoveryRateModel> validate(RosettaPath path, RecoveryRateModel recoveryRateModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RecoveryRateModel", path, DEFINITION);
		}
	}
}
