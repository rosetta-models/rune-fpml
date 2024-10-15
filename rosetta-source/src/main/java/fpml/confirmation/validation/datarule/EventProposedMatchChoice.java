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
import fpml.confirmation.EventProposedMatch;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("EventProposedMatchChoice")
@ImplementedBy(EventProposedMatchChoice.Default.class)
public interface EventProposedMatchChoice extends Validator<EventProposedMatch> {
	
	String NAME = "EventProposedMatchChoice";
	String DEFINITION = "required choice tradingEventsBaseModel, postTradeEventsBaseModel , changeEventsBaseModel , optionsEventsBaseModel , additionalEvent";
	
	ValidationResult<EventProposedMatch> validate(RosettaPath path, EventProposedMatch eventProposedMatch);
	
	class Default implements EventProposedMatchChoice {
	
		@Override
		public ValidationResult<EventProposedMatch> validate(RosettaPath path, EventProposedMatch eventProposedMatch) {
			ComparisonResult result = executeDataRule(eventProposedMatch);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EventProposedMatch", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "EventProposedMatch", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(EventProposedMatch eventProposedMatch) {
			try {
				return choice(MapperS.of(eventProposedMatch), Arrays.asList("tradingEventsBaseModel", "postTradeEventsBaseModel", "changeEventsBaseModel", "optionsEventsBaseModel", "additionalEvent"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EventProposedMatchChoice {
	
		@Override
		public ValidationResult<EventProposedMatch> validate(RosettaPath path, EventProposedMatch eventProposedMatch) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EventProposedMatch", path, DEFINITION);
		}
	}
}
