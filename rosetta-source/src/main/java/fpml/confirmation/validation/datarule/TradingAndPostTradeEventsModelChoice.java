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
import fpml.confirmation.TradingAndPostTradeEventsModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("TradingAndPostTradeEventsModelChoice")
@ImplementedBy(TradingAndPostTradeEventsModelChoice.Default.class)
public interface TradingAndPostTradeEventsModelChoice extends Validator<TradingAndPostTradeEventsModel> {
	
	String NAME = "TradingAndPostTradeEventsModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<TradingAndPostTradeEventsModel> validate(RosettaPath path, TradingAndPostTradeEventsModel tradingAndPostTradeEventsModel);
	
	class Default implements TradingAndPostTradeEventsModelChoice {
	
		@Override
		public ValidationResult<TradingAndPostTradeEventsModel> validate(RosettaPath path, TradingAndPostTradeEventsModel tradingAndPostTradeEventsModel) {
			ComparisonResult result = executeDataRule(tradingAndPostTradeEventsModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradingAndPostTradeEventsModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "TradingAndPostTradeEventsModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(TradingAndPostTradeEventsModel tradingAndPostTradeEventsModel) {
			try {
				return choice(MapperS.of(tradingAndPostTradeEventsModel), Arrays.asList("tradingEventsBaseModel", "postTradeEventsBaseModel", "additionalEvent"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradingAndPostTradeEventsModelChoice {
	
		@Override
		public ValidationResult<TradingAndPostTradeEventsModel> validate(RosettaPath path, TradingAndPostTradeEventsModel tradingAndPostTradeEventsModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradingAndPostTradeEventsModel", path, DEFINITION);
		}
	}
}
