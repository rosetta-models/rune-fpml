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
import fpml.confirmation.CalculationPeriodDates;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CalculationPeriodDatesChoice0")
@ImplementedBy(CalculationPeriodDatesChoice0.Default.class)
public interface CalculationPeriodDatesChoice0 extends Validator<CalculationPeriodDates> {
	
	String NAME = "CalculationPeriodDatesChoice0";
	String DEFINITION = "required choice effectiveDate, relativeEffectiveDate";
	
	ValidationResult<CalculationPeriodDates> validate(RosettaPath path, CalculationPeriodDates calculationPeriodDates);
	
	class Default implements CalculationPeriodDatesChoice0 {
	
		@Override
		public ValidationResult<CalculationPeriodDates> validate(RosettaPath path, CalculationPeriodDates calculationPeriodDates) {
			ComparisonResult result = executeDataRule(calculationPeriodDates);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CalculationPeriodDates", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CalculationPeriodDates", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CalculationPeriodDates calculationPeriodDates) {
			try {
				return choice(MapperS.of(calculationPeriodDates), Arrays.asList("effectiveDate", "relativeEffectiveDate"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CalculationPeriodDatesChoice0 {
	
		@Override
		public ValidationResult<CalculationPeriodDates> validate(RosettaPath path, CalculationPeriodDates calculationPeriodDates) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CalculationPeriodDates", path, DEFINITION);
		}
	}
}
