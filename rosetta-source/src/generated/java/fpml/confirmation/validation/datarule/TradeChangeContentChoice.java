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
import fpml.confirmation.TradeChangeContent;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("TradeChangeContentChoice")
@ImplementedBy(TradeChangeContentChoice.Default.class)
public interface TradeChangeContentChoice extends Validator<TradeChangeContent> {
	
	String NAME = "TradeChangeContentChoice";
	String DEFINITION = "optional choice oldTradeIdentifier, oldTrade";
	
	ValidationResult<TradeChangeContent> validate(RosettaPath path, TradeChangeContent tradeChangeContent);
	
	class Default implements TradeChangeContentChoice {
	
		@Override
		public ValidationResult<TradeChangeContent> validate(RosettaPath path, TradeChangeContent tradeChangeContent) {
			ComparisonResult result = executeDataRule(tradeChangeContent);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeChangeContent", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "TradeChangeContent", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(TradeChangeContent tradeChangeContent) {
			try {
				return choice(MapperS.of(tradeChangeContent), Arrays.asList("oldTradeIdentifier", "oldTrade"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeChangeContentChoice {
	
		@Override
		public ValidationResult<TradeChangeContent> validate(RosettaPath path, TradeChangeContent tradeChangeContent) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeChangeContent", path, DEFINITION);
		}
	}
}
