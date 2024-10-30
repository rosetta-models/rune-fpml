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
import fpml.confirmation.CashSettlementPaymentDate;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CashSettlementPaymentDateChoice")
@ImplementedBy(CashSettlementPaymentDateChoice.Default.class)
public interface CashSettlementPaymentDateChoice extends Validator<CashSettlementPaymentDate> {
	
	String NAME = "CashSettlementPaymentDateChoice";
	String DEFINITION = "required choice adjustableDates, relativeDate , businessDateRange";
	
	ValidationResult<CashSettlementPaymentDate> validate(RosettaPath path, CashSettlementPaymentDate cashSettlementPaymentDate);
	
	class Default implements CashSettlementPaymentDateChoice {
	
		@Override
		public ValidationResult<CashSettlementPaymentDate> validate(RosettaPath path, CashSettlementPaymentDate cashSettlementPaymentDate) {
			ComparisonResult result = executeDataRule(cashSettlementPaymentDate);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CashSettlementPaymentDate", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CashSettlementPaymentDate", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CashSettlementPaymentDate cashSettlementPaymentDate) {
			try {
				return choice(MapperS.of(cashSettlementPaymentDate), Arrays.asList("adjustableDates", "relativeDate", "businessDateRange"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CashSettlementPaymentDateChoice {
	
		@Override
		public ValidationResult<CashSettlementPaymentDate> validate(RosettaPath path, CashSettlementPaymentDate cashSettlementPaymentDate) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CashSettlementPaymentDate", path, DEFINITION);
		}
	}
}
