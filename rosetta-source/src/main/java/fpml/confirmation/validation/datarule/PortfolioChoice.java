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
import fpml.confirmation.Portfolio;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("PortfolioChoice")
@ImplementedBy(PortfolioChoice.Default.class)
public interface PortfolioChoice extends Validator<Portfolio> {
	
	String NAME = "PortfolioChoice";
	String DEFINITION = "required choice tradeId, partyTradeIdentifier";
	
	ValidationResult<Portfolio> validate(RosettaPath path, Portfolio portfolio);
	
	class Default implements PortfolioChoice {
	
		@Override
		public ValidationResult<Portfolio> validate(RosettaPath path, Portfolio portfolio) {
			ComparisonResult result = executeDataRule(portfolio);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Portfolio", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "Portfolio", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(Portfolio portfolio) {
			try {
				return choice(MapperS.of(portfolio), Arrays.asList("tradeId", "partyTradeIdentifier"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PortfolioChoice {
	
		@Override
		public ValidationResult<Portfolio> validate(RosettaPath path, Portfolio portfolio) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Portfolio", path, DEFINITION);
		}
	}
}
