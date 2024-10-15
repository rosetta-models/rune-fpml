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
import fpml.confirmation.EventIdentifier;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("EventIdentifierChoice")
@ImplementedBy(EventIdentifierChoice.Default.class)
public interface EventIdentifierChoice extends Validator<EventIdentifier> {
	
	String NAME = "EventIdentifierChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<EventIdentifier> validate(RosettaPath path, EventIdentifier eventIdentifier);
	
	class Default implements EventIdentifierChoice {
	
		@Override
		public ValidationResult<EventIdentifier> validate(RosettaPath path, EventIdentifier eventIdentifier) {
			ComparisonResult result = executeDataRule(eventIdentifier);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EventIdentifier", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "EventIdentifier", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(EventIdentifier eventIdentifier) {
			try {
				return choice(MapperS.of(eventIdentifier), Arrays.asList("eventIdentifierSequence", "tradeIdentifier"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EventIdentifierChoice {
	
		@Override
		public ValidationResult<EventIdentifier> validate(RosettaPath path, EventIdentifier eventIdentifier) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EventIdentifier", path, DEFINITION);
		}
	}
}
