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
import fpml.confirmation.EventsChoice;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("EventsChoiceChoice")
@ImplementedBy(EventsChoiceChoice.Default.class)
public interface EventsChoiceChoice extends Validator<EventsChoice> {
	
	String NAME = "EventsChoiceChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<EventsChoice> validate(RosettaPath path, EventsChoice eventsChoice);
	
	class Default implements EventsChoiceChoice {
	
		@Override
		public ValidationResult<EventsChoice> validate(RosettaPath path, EventsChoice eventsChoice) {
			ComparisonResult result = executeDataRule(eventsChoice);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EventsChoice", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "EventsChoice", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(EventsChoice eventsChoice) {
			try {
				return choice(MapperS.of(eventsChoice), Arrays.asList("tradingEventsBaseModel", "postTradeEventsBaseModel", "changeEventsBaseModel", "optionsEventsBaseModel", "additionalEvent"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EventsChoiceChoice {
	
		@Override
		public ValidationResult<EventsChoice> validate(RosettaPath path, EventsChoice eventsChoice) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EventsChoice", path, DEFINITION);
		}
	}
}
