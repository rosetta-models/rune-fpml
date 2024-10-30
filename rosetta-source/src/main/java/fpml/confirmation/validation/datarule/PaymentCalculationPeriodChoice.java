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
import fpml.confirmation.PaymentCalculationPeriod;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("PaymentCalculationPeriodChoice")
@ImplementedBy(PaymentCalculationPeriodChoice.Default.class)
public interface PaymentCalculationPeriodChoice extends Validator<PaymentCalculationPeriod> {
	
	String NAME = "PaymentCalculationPeriodChoice";
	String DEFINITION = "required choice calculationPeriod, fixedPaymentAmount";
	
	ValidationResult<PaymentCalculationPeriod> validate(RosettaPath path, PaymentCalculationPeriod paymentCalculationPeriod);
	
	class Default implements PaymentCalculationPeriodChoice {
	
		@Override
		public ValidationResult<PaymentCalculationPeriod> validate(RosettaPath path, PaymentCalculationPeriod paymentCalculationPeriod) {
			ComparisonResult result = executeDataRule(paymentCalculationPeriod);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PaymentCalculationPeriod", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "PaymentCalculationPeriod", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(PaymentCalculationPeriod paymentCalculationPeriod) {
			try {
				return choice(MapperS.of(paymentCalculationPeriod), Arrays.asList("calculationPeriod", "fixedPaymentAmount"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PaymentCalculationPeriodChoice {
	
		@Override
		public ValidationResult<PaymentCalculationPeriod> validate(RosettaPath path, PaymentCalculationPeriod paymentCalculationPeriod) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PaymentCalculationPeriod", path, DEFINITION);
		}
	}
}
