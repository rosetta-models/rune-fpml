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
import fpml.confirmation.PrincipalExchangeAmount;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("PrincipalExchangeAmountChoice")
@ImplementedBy(PrincipalExchangeAmountChoice.Default.class)
public interface PrincipalExchangeAmountChoice extends Validator<PrincipalExchangeAmount> {
	
	String NAME = "PrincipalExchangeAmountChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<PrincipalExchangeAmount> validate(RosettaPath path, PrincipalExchangeAmount principalExchangeAmount);
	
	class Default implements PrincipalExchangeAmountChoice {
	
		@Override
		public ValidationResult<PrincipalExchangeAmount> validate(RosettaPath path, PrincipalExchangeAmount principalExchangeAmount) {
			ComparisonResult result = executeDataRule(principalExchangeAmount);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PrincipalExchangeAmount", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "PrincipalExchangeAmount", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(PrincipalExchangeAmount principalExchangeAmount) {
			try {
				return choice(MapperS.of(principalExchangeAmount), Arrays.asList("amountRelativeTo", "determinationMethod", "principalAmount"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PrincipalExchangeAmountChoice {
	
		@Override
		public ValidationResult<PrincipalExchangeAmount> validate(RosettaPath path, PrincipalExchangeAmount principalExchangeAmount) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PrincipalExchangeAmount", path, DEFINITION);
		}
	}
}
