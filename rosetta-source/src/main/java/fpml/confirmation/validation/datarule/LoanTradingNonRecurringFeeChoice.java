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
import fpml.confirmation.LoanTradingNonRecurringFee;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("LoanTradingNonRecurringFeeChoice")
@ImplementedBy(LoanTradingNonRecurringFeeChoice.Default.class)
public interface LoanTradingNonRecurringFeeChoice extends Validator<LoanTradingNonRecurringFee> {
	
	String NAME = "LoanTradingNonRecurringFeeChoice";
	String DEFINITION = "required choice feeType, miscFeeType";
	
	ValidationResult<LoanTradingNonRecurringFee> validate(RosettaPath path, LoanTradingNonRecurringFee loanTradingNonRecurringFee);
	
	class Default implements LoanTradingNonRecurringFeeChoice {
	
		@Override
		public ValidationResult<LoanTradingNonRecurringFee> validate(RosettaPath path, LoanTradingNonRecurringFee loanTradingNonRecurringFee) {
			ComparisonResult result = executeDataRule(loanTradingNonRecurringFee);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanTradingNonRecurringFee", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "LoanTradingNonRecurringFee", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(LoanTradingNonRecurringFee loanTradingNonRecurringFee) {
			try {
				return choice(MapperS.of(loanTradingNonRecurringFee), Arrays.asList("feeType", "miscFeeType"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanTradingNonRecurringFeeChoice {
	
		@Override
		public ValidationResult<LoanTradingNonRecurringFee> validate(RosettaPath path, LoanTradingNonRecurringFee loanTradingNonRecurringFee) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanTradingNonRecurringFee", path, DEFINITION);
		}
	}
}
