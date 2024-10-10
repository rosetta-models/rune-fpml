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
import fpml.confirmation.LoanChoice;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("LoanChoiceChoice")
@ImplementedBy(LoanChoiceChoice.Default.class)
public interface LoanChoiceChoice extends Validator<LoanChoice> {
	
	String NAME = "LoanChoiceChoice";
	String DEFINITION = "optional choice borrower, borrowerReference";
	
	ValidationResult<LoanChoice> validate(RosettaPath path, LoanChoice loanChoice);
	
	class Default implements LoanChoiceChoice {
	
		@Override
		public ValidationResult<LoanChoice> validate(RosettaPath path, LoanChoice loanChoice) {
			ComparisonResult result = executeDataRule(loanChoice);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanChoice", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "LoanChoice", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(LoanChoice loanChoice) {
			try {
				return choice(MapperS.of(loanChoice), Arrays.asList("borrower", "borrowerReference"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanChoiceChoice {
	
		@Override
		public ValidationResult<LoanChoice> validate(RosettaPath path, LoanChoice loanChoice) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanChoice", path, DEFINITION);
		}
	}
}
