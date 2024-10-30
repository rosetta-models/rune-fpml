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
import fpml.confirmation.Account;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("AccountChoice")
@ImplementedBy(AccountChoice.Default.class)
public interface AccountChoice extends Validator<Account> {
	
	String NAME = "AccountChoice";
	String DEFINITION = "required choice accountSequence, servicingParty";
	
	ValidationResult<Account> validate(RosettaPath path, Account account);
	
	class Default implements AccountChoice {
	
		@Override
		public ValidationResult<Account> validate(RosettaPath path, Account account) {
			ComparisonResult result = executeDataRule(account);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Account", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "Account", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(Account account) {
			try {
				return choice(MapperS.of(account), Arrays.asList("accountSequence", "servicingParty"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AccountChoice {
	
		@Override
		public ValidationResult<Account> validate(RosettaPath path, Account account) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Account", path, DEFINITION);
		}
	}
}
