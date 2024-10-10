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
import fpml.confirmation.TradeNovationContent;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("TradeNovationContentChoice")
@ImplementedBy(TradeNovationContentChoice.Default.class)
public interface TradeNovationContentChoice extends Validator<TradeNovationContent> {
	
	String NAME = "TradeNovationContentChoice";
	String DEFINITION = "required choice newTradeModel, tradeNovationContentSequence0 , tradeNovationContentSequence1";
	
	ValidationResult<TradeNovationContent> validate(RosettaPath path, TradeNovationContent tradeNovationContent);
	
	class Default implements TradeNovationContentChoice {
	
		@Override
		public ValidationResult<TradeNovationContent> validate(RosettaPath path, TradeNovationContent tradeNovationContent) {
			ComparisonResult result = executeDataRule(tradeNovationContent);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeNovationContent", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "TradeNovationContent", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(TradeNovationContent tradeNovationContent) {
			try {
				return choice(MapperS.of(tradeNovationContent), Arrays.asList("newTradeModel", "tradeNovationContentSequence0", "tradeNovationContentSequence1"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeNovationContentChoice {
	
		@Override
		public ValidationResult<TradeNovationContent> validate(RosettaPath path, TradeNovationContent tradeNovationContent) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeNovationContent", path, DEFINITION);
		}
	}
}
