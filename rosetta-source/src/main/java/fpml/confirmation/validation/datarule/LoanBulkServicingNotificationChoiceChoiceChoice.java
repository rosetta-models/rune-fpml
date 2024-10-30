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
import fpml.confirmation.LoanBulkServicingNotificationChoiceChoice;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("LoanBulkServicingNotificationChoiceChoiceChoice")
@ImplementedBy(LoanBulkServicingNotificationChoiceChoiceChoice.Default.class)
public interface LoanBulkServicingNotificationChoiceChoiceChoice extends Validator<LoanBulkServicingNotificationChoiceChoice> {
	
	String NAME = "LoanBulkServicingNotificationChoiceChoiceChoice";
	String DEFINITION = "optional choice letterOfCreditDetailsModel, loanContractDetailsModel";
	
	ValidationResult<LoanBulkServicingNotificationChoiceChoice> validate(RosettaPath path, LoanBulkServicingNotificationChoiceChoice loanBulkServicingNotificationChoiceChoice);
	
	class Default implements LoanBulkServicingNotificationChoiceChoiceChoice {
	
		@Override
		public ValidationResult<LoanBulkServicingNotificationChoiceChoice> validate(RosettaPath path, LoanBulkServicingNotificationChoiceChoice loanBulkServicingNotificationChoiceChoice) {
			ComparisonResult result = executeDataRule(loanBulkServicingNotificationChoiceChoice);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanBulkServicingNotificationChoiceChoice", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "LoanBulkServicingNotificationChoiceChoice", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(LoanBulkServicingNotificationChoiceChoice loanBulkServicingNotificationChoiceChoice) {
			try {
				return choice(MapperS.of(loanBulkServicingNotificationChoiceChoice), Arrays.asList("letterOfCreditDetailsModel", "loanContractDetailsModel"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanBulkServicingNotificationChoiceChoiceChoice {
	
		@Override
		public ValidationResult<LoanBulkServicingNotificationChoiceChoice> validate(RosettaPath path, LoanBulkServicingNotificationChoiceChoice loanBulkServicingNotificationChoiceChoice) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanBulkServicingNotificationChoiceChoice", path, DEFINITION);
		}
	}
}
