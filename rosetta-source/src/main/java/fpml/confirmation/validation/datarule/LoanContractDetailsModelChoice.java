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
import fpml.confirmation.LoanContractDetailsModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("LoanContractDetailsModelChoice")
@ImplementedBy(LoanContractDetailsModelChoice.Default.class)
public interface LoanContractDetailsModelChoice extends Validator<LoanContractDetailsModel> {
	
	String NAME = "LoanContractDetailsModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<LoanContractDetailsModel> validate(RosettaPath path, LoanContractDetailsModel loanContractDetailsModel);
	
	class Default implements LoanContractDetailsModelChoice {
	
		@Override
		public ValidationResult<LoanContractDetailsModel> validate(RosettaPath path, LoanContractDetailsModel loanContractDetailsModel) {
			ComparisonResult result = executeDataRule(loanContractDetailsModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanContractDetailsModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "LoanContractDetailsModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(LoanContractDetailsModel loanContractDetailsModel) {
			try {
				return choice(MapperS.of(loanContractDetailsModel), Arrays.asList("contractIdentifier", "contractSummary", "contract"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanContractDetailsModelChoice {
	
		@Override
		public ValidationResult<LoanContractDetailsModel> validate(RosettaPath path, LoanContractDetailsModel loanContractDetailsModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanContractDetailsModel", path, DEFINITION);
		}
	}
}
