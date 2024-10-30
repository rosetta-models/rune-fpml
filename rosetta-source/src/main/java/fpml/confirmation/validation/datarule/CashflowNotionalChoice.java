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
import fpml.confirmation.CashflowNotional;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CashflowNotionalChoice")
@ImplementedBy(CashflowNotionalChoice.Default.class)
public interface CashflowNotionalChoice extends Validator<CashflowNotional> {
	
	String NAME = "CashflowNotionalChoice";
	String DEFINITION = "required choice currency, units";
	
	ValidationResult<CashflowNotional> validate(RosettaPath path, CashflowNotional cashflowNotional);
	
	class Default implements CashflowNotionalChoice {
	
		@Override
		public ValidationResult<CashflowNotional> validate(RosettaPath path, CashflowNotional cashflowNotional) {
			ComparisonResult result = executeDataRule(cashflowNotional);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CashflowNotional", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CashflowNotional", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CashflowNotional cashflowNotional) {
			try {
				return choice(MapperS.of(cashflowNotional), Arrays.asList("currency", "units"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CashflowNotionalChoice {
	
		@Override
		public ValidationResult<CashflowNotional> validate(RosettaPath path, CashflowNotional cashflowNotional) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CashflowNotional", path, DEFINITION);
		}
	}
}
