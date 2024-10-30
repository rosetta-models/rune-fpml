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
import fpml.confirmation.LoanContract;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("LoanContractChoice")
@ImplementedBy(LoanContractChoice.Default.class)
public interface LoanContractChoice extends Validator<LoanContract> {
	
	String NAME = "LoanContractChoice";
	String DEFINITION = "required choice fixedRateAccrual, floatingRateAccrual";
	
	ValidationResult<LoanContract> validate(RosettaPath path, LoanContract loanContract);
	
	class Default implements LoanContractChoice {
	
		@Override
		public ValidationResult<LoanContract> validate(RosettaPath path, LoanContract loanContract) {
			ComparisonResult result = executeDataRule(loanContract);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanContract", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "LoanContract", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(LoanContract loanContract) {
			try {
				return choice(MapperS.of(loanContract), Arrays.asList("fixedRateAccrual", "floatingRateAccrual"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanContractChoice {
	
		@Override
		public ValidationResult<LoanContract> validate(RosettaPath path, LoanContract loanContract) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanContract", path, DEFINITION);
		}
	}
}
