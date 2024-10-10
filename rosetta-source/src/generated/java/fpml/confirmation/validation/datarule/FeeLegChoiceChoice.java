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
import fpml.confirmation.FeeLegChoice;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("FeeLegChoiceChoice")
@ImplementedBy(FeeLegChoiceChoice.Default.class)
public interface FeeLegChoiceChoice extends Validator<FeeLegChoice> {
	
	String NAME = "FeeLegChoiceChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<FeeLegChoice> validate(RosettaPath path, FeeLegChoice feeLegChoice);
	
	class Default implements FeeLegChoiceChoice {
	
		@Override
		public ValidationResult<FeeLegChoice> validate(RosettaPath path, FeeLegChoice feeLegChoice) {
			ComparisonResult result = executeDataRule(feeLegChoice);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FeeLegChoice", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FeeLegChoice", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FeeLegChoice feeLegChoice) {
			try {
				return choice(MapperS.of(feeLegChoice), Arrays.asList("feeLegChoiceSequence0", "feeLegChoiceSequence1"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FeeLegChoiceChoice {
	
		@Override
		public ValidationResult<FeeLegChoice> validate(RosettaPath path, FeeLegChoice feeLegChoice) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FeeLegChoice", path, DEFINITION);
		}
	}
}
