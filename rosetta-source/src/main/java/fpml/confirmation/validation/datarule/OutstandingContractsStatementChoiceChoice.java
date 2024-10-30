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
import fpml.confirmation.OutstandingContractsStatementChoice;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("OutstandingContractsStatementChoiceChoice")
@ImplementedBy(OutstandingContractsStatementChoiceChoice.Default.class)
public interface OutstandingContractsStatementChoiceChoice extends Validator<OutstandingContractsStatementChoice> {
	
	String NAME = "OutstandingContractsStatementChoiceChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<OutstandingContractsStatementChoice> validate(RosettaPath path, OutstandingContractsStatementChoice outstandingContractsStatementChoice);
	
	class Default implements OutstandingContractsStatementChoiceChoice {
	
		@Override
		public ValidationResult<OutstandingContractsStatementChoice> validate(RosettaPath path, OutstandingContractsStatementChoice outstandingContractsStatementChoice) {
			ComparisonResult result = executeDataRule(outstandingContractsStatementChoice);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OutstandingContractsStatementChoice", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "OutstandingContractsStatementChoice", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(OutstandingContractsStatementChoice outstandingContractsStatementChoice) {
			try {
				return choice(MapperS.of(outstandingContractsStatementChoice), Arrays.asList("loanContract", "letterOfCredit"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OutstandingContractsStatementChoiceChoice {
	
		@Override
		public ValidationResult<OutstandingContractsStatementChoice> validate(RosettaPath path, OutstandingContractsStatementChoice outstandingContractsStatementChoice) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OutstandingContractsStatementChoice", path, DEFINITION);
		}
	}
}
