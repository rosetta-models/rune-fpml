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
import fpml.confirmation.RolloverChoice;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("RolloverChoiceChoice")
@ImplementedBy(RolloverChoiceChoice.Default.class)
public interface RolloverChoiceChoice extends Validator<RolloverChoice> {
	
	String NAME = "RolloverChoiceChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<RolloverChoice> validate(RosettaPath path, RolloverChoice rolloverChoice);
	
	class Default implements RolloverChoiceChoice {
	
		@Override
		public ValidationResult<RolloverChoice> validate(RosettaPath path, RolloverChoice rolloverChoice) {
			ComparisonResult result = executeDataRule(rolloverChoice);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RolloverChoice", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "RolloverChoice", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(RolloverChoice rolloverChoice) {
			try {
				return choice(MapperS.of(rolloverChoice), Arrays.asList("baseRateSet", "borrowing", "commitmentAdjustment", "interestCapitalization", "interestPayment", "repayment"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RolloverChoiceChoice {
	
		@Override
		public ValidationResult<RolloverChoice> validate(RosettaPath path, RolloverChoice rolloverChoice) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RolloverChoice", path, DEFINITION);
		}
	}
}
