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
import fpml.confirmation.Trigger;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("TriggerChoice")
@ImplementedBy(TriggerChoice.Default.class)
public interface TriggerChoice extends Validator<Trigger> {
	
	String NAME = "TriggerChoice";
	String DEFINITION = "required choice level, levelPercentage , triggerChoice";
	
	ValidationResult<Trigger> validate(RosettaPath path, Trigger trigger);
	
	class Default implements TriggerChoice {
	
		@Override
		public ValidationResult<Trigger> validate(RosettaPath path, Trigger trigger) {
			ComparisonResult result = executeDataRule(trigger);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Trigger", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "Trigger", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(Trigger trigger) {
			try {
				return choice(MapperS.of(trigger), Arrays.asList("level", "levelPercentage", "triggerChoice"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TriggerChoice {
	
		@Override
		public ValidationResult<Trigger> validate(RosettaPath path, Trigger trigger) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Trigger", path, DEFINITION);
		}
	}
}
