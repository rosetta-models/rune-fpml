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
import fpml.confirmation.LoanBulkServicingNotificationChoice0;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("LoanBulkServicingNotificationChoice0Choice")
@ImplementedBy(LoanBulkServicingNotificationChoice0Choice.Default.class)
public interface LoanBulkServicingNotificationChoice0Choice extends Validator<LoanBulkServicingNotificationChoice0> {
	
	String NAME = "LoanBulkServicingNotificationChoice0Choice";
	String DEFINITION = "one-of";
	
	ValidationResult<LoanBulkServicingNotificationChoice0> validate(RosettaPath path, LoanBulkServicingNotificationChoice0 loanBulkServicingNotificationChoice0);
	
	class Default implements LoanBulkServicingNotificationChoice0Choice {
	
		@Override
		public ValidationResult<LoanBulkServicingNotificationChoice0> validate(RosettaPath path, LoanBulkServicingNotificationChoice0 loanBulkServicingNotificationChoice0) {
			ComparisonResult result = executeDataRule(loanBulkServicingNotificationChoice0);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanBulkServicingNotificationChoice0", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "LoanBulkServicingNotificationChoice0", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(LoanBulkServicingNotificationChoice0 loanBulkServicingNotificationChoice0) {
			try {
				return choice(MapperS.of(loanBulkServicingNotificationChoice0), Arrays.asList("facilityFeePaymentGroup", "facilityEventGroup", "accruingFeePayment", "accruingPikPayment", "loanContractEventGroup", "lcEventGroup"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanBulkServicingNotificationChoice0Choice {
	
		@Override
		public ValidationResult<LoanBulkServicingNotificationChoice0> validate(RosettaPath path, LoanBulkServicingNotificationChoice0 loanBulkServicingNotificationChoice0) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanBulkServicingNotificationChoice0", path, DEFINITION);
		}
	}
}
