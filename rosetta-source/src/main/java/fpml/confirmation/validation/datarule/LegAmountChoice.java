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
import fpml.confirmation.LegAmount;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("LegAmountChoice")
@ImplementedBy(LegAmountChoice.Default.class)
public interface LegAmountChoice extends Validator<LegAmount> {
	
	String NAME = "LegAmountChoice";
	String DEFINITION = "required choice referenceAmount, formula , encodedDescription";
	
	ValidationResult<LegAmount> validate(RosettaPath path, LegAmount legAmount);
	
	class Default implements LegAmountChoice {
	
		@Override
		public ValidationResult<LegAmount> validate(RosettaPath path, LegAmount legAmount) {
			ComparisonResult result = executeDataRule(legAmount);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LegAmount", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "LegAmount", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(LegAmount legAmount) {
			try {
				return choice(MapperS.of(legAmount), Arrays.asList("referenceAmount", "formula", "encodedDescription"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LegAmountChoice {
	
		@Override
		public ValidationResult<LegAmount> validate(RosettaPath path, LegAmount legAmount) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LegAmount", path, DEFINITION);
		}
	}
}
