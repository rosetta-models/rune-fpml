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
import fpml.confirmation.CalculationPeriodAmount;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CalculationPeriodAmountChoice")
@ImplementedBy(CalculationPeriodAmountChoice.Default.class)
public interface CalculationPeriodAmountChoice extends Validator<CalculationPeriodAmount> {
	
	String NAME = "CalculationPeriodAmountChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<CalculationPeriodAmount> validate(RosettaPath path, CalculationPeriodAmount calculationPeriodAmount);
	
	class Default implements CalculationPeriodAmountChoice {
	
		@Override
		public ValidationResult<CalculationPeriodAmount> validate(RosettaPath path, CalculationPeriodAmount calculationPeriodAmount) {
			ComparisonResult result = executeDataRule(calculationPeriodAmount);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CalculationPeriodAmount", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CalculationPeriodAmount", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CalculationPeriodAmount calculationPeriodAmount) {
			try {
				return choice(MapperS.of(calculationPeriodAmount), Arrays.asList("calculation", "knownAmountSchedule"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CalculationPeriodAmountChoice {
	
		@Override
		public ValidationResult<CalculationPeriodAmount> validate(RosettaPath path, CalculationPeriodAmount calculationPeriodAmount) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CalculationPeriodAmount", path, DEFINITION);
		}
	}
}
