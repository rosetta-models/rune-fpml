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
import fpml.confirmation.CreditDefaultSwapChoice;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CreditDefaultSwapChoiceChoice")
@ImplementedBy(CreditDefaultSwapChoiceChoice.Default.class)
public interface CreditDefaultSwapChoiceChoice extends Validator<CreditDefaultSwapChoice> {
	
	String NAME = "CreditDefaultSwapChoiceChoice";
	String DEFINITION = "optional choice cashSettlementTerms, physicalSettlementTerms";
	
	ValidationResult<CreditDefaultSwapChoice> validate(RosettaPath path, CreditDefaultSwapChoice creditDefaultSwapChoice);
	
	class Default implements CreditDefaultSwapChoiceChoice {
	
		@Override
		public ValidationResult<CreditDefaultSwapChoice> validate(RosettaPath path, CreditDefaultSwapChoice creditDefaultSwapChoice) {
			ComparisonResult result = executeDataRule(creditDefaultSwapChoice);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditDefaultSwapChoice", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CreditDefaultSwapChoice", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CreditDefaultSwapChoice creditDefaultSwapChoice) {
			try {
				return choice(MapperS.of(creditDefaultSwapChoice), Arrays.asList("cashSettlementTerms", "physicalSettlementTerms"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CreditDefaultSwapChoiceChoice {
	
		@Override
		public ValidationResult<CreditDefaultSwapChoice> validate(RosettaPath path, CreditDefaultSwapChoice creditDefaultSwapChoice) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditDefaultSwapChoice", path, DEFINITION);
		}
	}
}
