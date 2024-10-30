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
import fpml.confirmation.StubCalculationPeriod;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("StubCalculationPeriodChoice")
@ImplementedBy(StubCalculationPeriodChoice.Default.class)
public interface StubCalculationPeriodChoice extends Validator<StubCalculationPeriod> {
	
	String NAME = "StubCalculationPeriodChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<StubCalculationPeriod> validate(RosettaPath path, StubCalculationPeriod stubCalculationPeriod);
	
	class Default implements StubCalculationPeriodChoice {
	
		@Override
		public ValidationResult<StubCalculationPeriod> validate(RosettaPath path, StubCalculationPeriod stubCalculationPeriod) {
			ComparisonResult result = executeDataRule(stubCalculationPeriod);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "StubCalculationPeriod", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "StubCalculationPeriod", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(StubCalculationPeriod stubCalculationPeriod) {
			try {
				return choice(MapperS.of(stubCalculationPeriod), Arrays.asList("stubCalculationPeriodSequence", "finalStub"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements StubCalculationPeriodChoice {
	
		@Override
		public ValidationResult<StubCalculationPeriod> validate(RosettaPath path, StubCalculationPeriod stubCalculationPeriod) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "StubCalculationPeriod", path, DEFINITION);
		}
	}
}
