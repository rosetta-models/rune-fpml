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
import fpml.confirmation.LoanIdentifiersModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("LoanIdentifiersModelChoice")
@ImplementedBy(LoanIdentifiersModelChoice.Default.class)
public interface LoanIdentifiersModelChoice extends Validator<LoanIdentifiersModel> {
	
	String NAME = "LoanIdentifiersModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<LoanIdentifiersModel> validate(RosettaPath path, LoanIdentifiersModel loanIdentifiersModel);
	
	class Default implements LoanIdentifiersModelChoice {
	
		@Override
		public ValidationResult<LoanIdentifiersModel> validate(RosettaPath path, LoanIdentifiersModel loanIdentifiersModel) {
			ComparisonResult result = executeDataRule(loanIdentifiersModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanIdentifiersModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "LoanIdentifiersModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(LoanIdentifiersModel loanIdentifiersModel) {
			try {
				return choice(MapperS.of(loanIdentifiersModel), Arrays.asList("eventIdentifier", "overrideIdentifier", "taskIdentifier"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanIdentifiersModelChoice {
	
		@Override
		public ValidationResult<LoanIdentifiersModel> validate(RosettaPath path, LoanIdentifiersModel loanIdentifiersModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanIdentifiersModel", path, DEFINITION);
		}
	}
}
