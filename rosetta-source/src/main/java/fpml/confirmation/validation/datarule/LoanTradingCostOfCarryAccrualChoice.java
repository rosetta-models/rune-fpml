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
import fpml.confirmation.LoanTradingCostOfCarryAccrual;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("LoanTradingCostOfCarryAccrualChoice")
@ImplementedBy(LoanTradingCostOfCarryAccrualChoice.Default.class)
public interface LoanTradingCostOfCarryAccrualChoice extends Validator<LoanTradingCostOfCarryAccrual> {
	
	String NAME = "LoanTradingCostOfCarryAccrualChoice";
	String DEFINITION = "required choice commencementAccrual, settlementPeriodAccrual";
	
	ValidationResult<LoanTradingCostOfCarryAccrual> validate(RosettaPath path, LoanTradingCostOfCarryAccrual loanTradingCostOfCarryAccrual);
	
	class Default implements LoanTradingCostOfCarryAccrualChoice {
	
		@Override
		public ValidationResult<LoanTradingCostOfCarryAccrual> validate(RosettaPath path, LoanTradingCostOfCarryAccrual loanTradingCostOfCarryAccrual) {
			ComparisonResult result = executeDataRule(loanTradingCostOfCarryAccrual);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanTradingCostOfCarryAccrual", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "LoanTradingCostOfCarryAccrual", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(LoanTradingCostOfCarryAccrual loanTradingCostOfCarryAccrual) {
			try {
				return choice(MapperS.of(loanTradingCostOfCarryAccrual), Arrays.asList("commencementAccrual", "settlementPeriodAccrual"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanTradingCostOfCarryAccrualChoice {
	
		@Override
		public ValidationResult<LoanTradingCostOfCarryAccrual> validate(RosettaPath path, LoanTradingCostOfCarryAccrual loanTradingCostOfCarryAccrual) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanTradingCostOfCarryAccrual", path, DEFINITION);
		}
	}
}
