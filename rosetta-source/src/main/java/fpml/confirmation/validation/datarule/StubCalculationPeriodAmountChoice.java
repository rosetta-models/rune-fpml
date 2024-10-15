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
import fpml.confirmation.StubCalculationPeriodAmount;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("StubCalculationPeriodAmountChoice")
@ImplementedBy(StubCalculationPeriodAmountChoice.Default.class)
public interface StubCalculationPeriodAmountChoice extends Validator<StubCalculationPeriodAmount> {
	
	String NAME = "StubCalculationPeriodAmountChoice";
	String DEFINITION = "required choice stubCalculationPeriodAmountSequence, finalStub";
	
	ValidationResult<StubCalculationPeriodAmount> validate(RosettaPath path, StubCalculationPeriodAmount stubCalculationPeriodAmount);
	
	class Default implements StubCalculationPeriodAmountChoice {
	
		@Override
		public ValidationResult<StubCalculationPeriodAmount> validate(RosettaPath path, StubCalculationPeriodAmount stubCalculationPeriodAmount) {
			ComparisonResult result = executeDataRule(stubCalculationPeriodAmount);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "StubCalculationPeriodAmount", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "StubCalculationPeriodAmount", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(StubCalculationPeriodAmount stubCalculationPeriodAmount) {
			try {
				return choice(MapperS.of(stubCalculationPeriodAmount), Arrays.asList("stubCalculationPeriodAmountSequence", "finalStub"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements StubCalculationPeriodAmountChoice {
	
		@Override
		public ValidationResult<StubCalculationPeriodAmount> validate(RosettaPath path, StubCalculationPeriodAmount stubCalculationPeriodAmount) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "StubCalculationPeriodAmount", path, DEFINITION);
		}
	}
}
