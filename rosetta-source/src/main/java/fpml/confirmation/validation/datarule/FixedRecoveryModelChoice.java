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
import fpml.confirmation.FixedRecoveryModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("FixedRecoveryModelChoice")
@ImplementedBy(FixedRecoveryModelChoice.Default.class)
public interface FixedRecoveryModelChoice extends Validator<FixedRecoveryModel> {
	
	String NAME = "FixedRecoveryModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<FixedRecoveryModel> validate(RosettaPath path, FixedRecoveryModel fixedRecoveryModel);
	
	class Default implements FixedRecoveryModelChoice {
	
		@Override
		public ValidationResult<FixedRecoveryModel> validate(RosettaPath path, FixedRecoveryModel fixedRecoveryModel) {
			ComparisonResult result = executeDataRule(fixedRecoveryModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FixedRecoveryModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FixedRecoveryModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FixedRecoveryModel fixedRecoveryModel) {
			try {
				return choice(MapperS.of(fixedRecoveryModel), Arrays.asList("cashSettlementAmount", "recoveryFactor"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FixedRecoveryModelChoice {
	
		@Override
		public ValidationResult<FixedRecoveryModel> validate(RosettaPath path, FixedRecoveryModel fixedRecoveryModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FixedRecoveryModel", path, DEFINITION);
		}
	}
}
