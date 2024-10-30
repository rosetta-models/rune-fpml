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
import fpml.confirmation.EventsOrInfoModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("EventsOrInfoModelChoice")
@ImplementedBy(EventsOrInfoModelChoice.Default.class)
public interface EventsOrInfoModelChoice extends Validator<EventsOrInfoModel> {
	
	String NAME = "EventsOrInfoModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<EventsOrInfoModel> validate(RosettaPath path, EventsOrInfoModel eventsOrInfoModel);
	
	class Default implements EventsOrInfoModelChoice {
	
		@Override
		public ValidationResult<EventsOrInfoModel> validate(RosettaPath path, EventsOrInfoModel eventsOrInfoModel) {
			ComparisonResult result = executeDataRule(eventsOrInfoModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EventsOrInfoModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "EventsOrInfoModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(EventsOrInfoModel eventsOrInfoModel) {
			try {
				return choice(MapperS.of(eventsOrInfoModel), Arrays.asList("tradingAndPostTradeEventsModel", "tradeReferenceInformationModel"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EventsOrInfoModelChoice {
	
		@Override
		public ValidationResult<EventsOrInfoModel> validate(RosettaPath path, EventsOrInfoModel eventsOrInfoModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EventsOrInfoModel", path, DEFINITION);
		}
	}
}
