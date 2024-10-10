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
import fpml.confirmation.PeriodicPayment;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("PeriodicPaymentChoice")
@ImplementedBy(PeriodicPaymentChoice.Default.class)
public interface PeriodicPaymentChoice extends Validator<PeriodicPayment> {
	
	String NAME = "PeriodicPaymentChoice";
	String DEFINITION = "required choice fixedAmount, fixedAmountCalculation , floatingAmountCalculation";
	
	ValidationResult<PeriodicPayment> validate(RosettaPath path, PeriodicPayment periodicPayment);
	
	class Default implements PeriodicPaymentChoice {
	
		@Override
		public ValidationResult<PeriodicPayment> validate(RosettaPath path, PeriodicPayment periodicPayment) {
			ComparisonResult result = executeDataRule(periodicPayment);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PeriodicPayment", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "PeriodicPayment", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(PeriodicPayment periodicPayment) {
			try {
				return choice(MapperS.of(periodicPayment), Arrays.asList("fixedAmount", "fixedAmountCalculation", "floatingAmountCalculation"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PeriodicPaymentChoice {
	
		@Override
		public ValidationResult<PeriodicPayment> validate(RosettaPath path, PeriodicPayment periodicPayment) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PeriodicPayment", path, DEFINITION);
		}
	}
}
