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
import fpml.confirmation.Withdrawal;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("WithdrawalChoice")
@ImplementedBy(WithdrawalChoice.Default.class)
public interface WithdrawalChoice extends Validator<Withdrawal> {
	
	String NAME = "WithdrawalChoice";
	String DEFINITION = "required choice withdrawalSequence, trade";
	
	ValidationResult<Withdrawal> validate(RosettaPath path, Withdrawal withdrawal);
	
	class Default implements WithdrawalChoice {
	
		@Override
		public ValidationResult<Withdrawal> validate(RosettaPath path, Withdrawal withdrawal) {
			ComparisonResult result = executeDataRule(withdrawal);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Withdrawal", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "Withdrawal", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(Withdrawal withdrawal) {
			try {
				return choice(MapperS.of(withdrawal), Arrays.asList("withdrawalSequence", "trade"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements WithdrawalChoice {
	
		@Override
		public ValidationResult<Withdrawal> validate(RosettaPath path, Withdrawal withdrawal) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Withdrawal", path, DEFINITION);
		}
	}
}
