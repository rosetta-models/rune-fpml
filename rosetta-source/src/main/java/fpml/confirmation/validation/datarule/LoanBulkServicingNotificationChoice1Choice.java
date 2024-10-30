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
import fpml.confirmation.LoanBulkServicingNotificationChoice1;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("LoanBulkServicingNotificationChoice1Choice")
@ImplementedBy(LoanBulkServicingNotificationChoice1Choice.Default.class)
public interface LoanBulkServicingNotificationChoice1Choice extends Validator<LoanBulkServicingNotificationChoice1> {
	
	String NAME = "LoanBulkServicingNotificationChoice1Choice";
	String DEFINITION = "optional choice facilityDetailsModel, loanBulkServicingNotificationChoiceChoice";
	
	ValidationResult<LoanBulkServicingNotificationChoice1> validate(RosettaPath path, LoanBulkServicingNotificationChoice1 loanBulkServicingNotificationChoice1);
	
	class Default implements LoanBulkServicingNotificationChoice1Choice {
	
		@Override
		public ValidationResult<LoanBulkServicingNotificationChoice1> validate(RosettaPath path, LoanBulkServicingNotificationChoice1 loanBulkServicingNotificationChoice1) {
			ComparisonResult result = executeDataRule(loanBulkServicingNotificationChoice1);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanBulkServicingNotificationChoice1", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "LoanBulkServicingNotificationChoice1", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(LoanBulkServicingNotificationChoice1 loanBulkServicingNotificationChoice1) {
			try {
				return choice(MapperS.of(loanBulkServicingNotificationChoice1), Arrays.asList("facilityDetailsModel", "loanBulkServicingNotificationChoiceChoice"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanBulkServicingNotificationChoice1Choice {
	
		@Override
		public ValidationResult<LoanBulkServicingNotificationChoice1> validate(RosettaPath path, LoanBulkServicingNotificationChoice1 loanBulkServicingNotificationChoice1) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanBulkServicingNotificationChoice1", path, DEFINITION);
		}
	}
}
