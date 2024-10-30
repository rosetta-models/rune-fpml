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
import fpml.confirmation.CreditLimitUtilizationPosition;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CreditLimitUtilizationPositionChoice")
@ImplementedBy(CreditLimitUtilizationPositionChoice.Default.class)
public interface CreditLimitUtilizationPositionChoice extends Validator<CreditLimitUtilizationPosition> {
	
	String NAME = "CreditLimitUtilizationPositionChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<CreditLimitUtilizationPosition> validate(RosettaPath path, CreditLimitUtilizationPosition creditLimitUtilizationPosition);
	
	class Default implements CreditLimitUtilizationPositionChoice {
	
		@Override
		public ValidationResult<CreditLimitUtilizationPosition> validate(RosettaPath path, CreditLimitUtilizationPosition creditLimitUtilizationPosition) {
			ComparisonResult result = executeDataRule(creditLimitUtilizationPosition);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditLimitUtilizationPosition", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CreditLimitUtilizationPosition", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CreditLimitUtilizationPosition creditLimitUtilizationPosition) {
			try {
				return choice(MapperS.of(creditLimitUtilizationPosition), Arrays.asList("creditLimitUtilizationPositionSequence", "global"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CreditLimitUtilizationPositionChoice {
	
		@Override
		public ValidationResult<CreditLimitUtilizationPosition> validate(RosettaPath path, CreditLimitUtilizationPosition creditLimitUtilizationPosition) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditLimitUtilizationPosition", path, DEFINITION);
		}
	}
}
