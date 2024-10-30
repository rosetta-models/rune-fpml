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
import fpml.confirmation.TradingEventsBaseModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("TradingEventsBaseModelChoice")
@ImplementedBy(TradingEventsBaseModelChoice.Default.class)
public interface TradingEventsBaseModelChoice extends Validator<TradingEventsBaseModel> {
	
	String NAME = "TradingEventsBaseModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<TradingEventsBaseModel> validate(RosettaPath path, TradingEventsBaseModel tradingEventsBaseModel);
	
	class Default implements TradingEventsBaseModelChoice {
	
		@Override
		public ValidationResult<TradingEventsBaseModel> validate(RosettaPath path, TradingEventsBaseModel tradingEventsBaseModel) {
			ComparisonResult result = executeDataRule(tradingEventsBaseModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradingEventsBaseModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "TradingEventsBaseModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(TradingEventsBaseModel tradingEventsBaseModel) {
			try {
				return choice(MapperS.of(tradingEventsBaseModel), Arrays.asList("tradePackage", "tradingEventsBaseModelSequence"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradingEventsBaseModelChoice {
	
		@Override
		public ValidationResult<TradingEventsBaseModel> validate(RosettaPath path, TradingEventsBaseModel tradingEventsBaseModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradingEventsBaseModel", path, DEFINITION);
		}
	}
}
