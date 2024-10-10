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
import fpml.confirmation.TradingEventsModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("TradingEventsModelChoice")
@ImplementedBy(TradingEventsModelChoice.Default.class)
public interface TradingEventsModelChoice extends Validator<TradingEventsModel> {
	
	String NAME = "TradingEventsModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<TradingEventsModel> validate(RosettaPath path, TradingEventsModel tradingEventsModel);
	
	class Default implements TradingEventsModelChoice {
	
		@Override
		public ValidationResult<TradingEventsModel> validate(RosettaPath path, TradingEventsModel tradingEventsModel) {
			ComparisonResult result = executeDataRule(tradingEventsModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradingEventsModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "TradingEventsModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(TradingEventsModel tradingEventsModel) {
			try {
				return choice(MapperS.of(tradingEventsModel), Arrays.asList("tradingEventsBaseModel", "additionalEvent"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradingEventsModelChoice {
	
		@Override
		public ValidationResult<TradingEventsModel> validate(RosettaPath path, TradingEventsModel tradingEventsModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradingEventsModel", path, DEFINITION);
		}
	}
}
