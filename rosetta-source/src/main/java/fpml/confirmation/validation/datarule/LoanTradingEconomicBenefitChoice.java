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
import fpml.confirmation.LoanTradingEconomicBenefit;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("LoanTradingEconomicBenefitChoice")
@ImplementedBy(LoanTradingEconomicBenefitChoice.Default.class)
public interface LoanTradingEconomicBenefitChoice extends Validator<LoanTradingEconomicBenefit> {
	
	String NAME = "LoanTradingEconomicBenefitChoice";
	String DEFINITION = "optional choice eventIdentifier, commitmentAdjustment";
	
	ValidationResult<LoanTradingEconomicBenefit> validate(RosettaPath path, LoanTradingEconomicBenefit loanTradingEconomicBenefit);
	
	class Default implements LoanTradingEconomicBenefitChoice {
	
		@Override
		public ValidationResult<LoanTradingEconomicBenefit> validate(RosettaPath path, LoanTradingEconomicBenefit loanTradingEconomicBenefit) {
			ComparisonResult result = executeDataRule(loanTradingEconomicBenefit);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanTradingEconomicBenefit", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "LoanTradingEconomicBenefit", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(LoanTradingEconomicBenefit loanTradingEconomicBenefit) {
			try {
				return choice(MapperS.of(loanTradingEconomicBenefit), Arrays.asList("eventIdentifier", "commitmentAdjustment"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanTradingEconomicBenefitChoice {
	
		@Override
		public ValidationResult<LoanTradingEconomicBenefit> validate(RosettaPath path, LoanTradingEconomicBenefit loanTradingEconomicBenefit) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanTradingEconomicBenefit", path, DEFINITION);
		}
	}
}
