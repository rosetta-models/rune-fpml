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
import fpml.confirmation.TradeOrTradeReferenceModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("TradeOrTradeReferenceModelChoice")
@ImplementedBy(TradeOrTradeReferenceModelChoice.Default.class)
public interface TradeOrTradeReferenceModelChoice extends Validator<TradeOrTradeReferenceModel> {
	
	String NAME = "TradeOrTradeReferenceModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<TradeOrTradeReferenceModel> validate(RosettaPath path, TradeOrTradeReferenceModel tradeOrTradeReferenceModel);
	
	class Default implements TradeOrTradeReferenceModelChoice {
	
		@Override
		public ValidationResult<TradeOrTradeReferenceModel> validate(RosettaPath path, TradeOrTradeReferenceModel tradeOrTradeReferenceModel) {
			ComparisonResult result = executeDataRule(tradeOrTradeReferenceModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeOrTradeReferenceModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "TradeOrTradeReferenceModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(TradeOrTradeReferenceModel tradeOrTradeReferenceModel) {
			try {
				return choice(MapperS.of(tradeOrTradeReferenceModel), Arrays.asList("trade", "tradeReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeOrTradeReferenceModelChoice {
	
		@Override
		public ValidationResult<TradeOrTradeReferenceModel> validate(RosettaPath path, TradeOrTradeReferenceModel tradeOrTradeReferenceModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeOrTradeReferenceModel", path, DEFINITION);
		}
	}
}
