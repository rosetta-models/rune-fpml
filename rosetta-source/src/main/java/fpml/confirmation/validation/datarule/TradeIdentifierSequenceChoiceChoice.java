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
import fpml.confirmation.TradeIdentifierSequenceChoice;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("TradeIdentifierSequenceChoiceChoice")
@ImplementedBy(TradeIdentifierSequenceChoiceChoice.Default.class)
public interface TradeIdentifierSequenceChoiceChoice extends Validator<TradeIdentifierSequenceChoice> {
	
	String NAME = "TradeIdentifierSequenceChoiceChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<TradeIdentifierSequenceChoice> validate(RosettaPath path, TradeIdentifierSequenceChoice tradeIdentifierSequenceChoice);
	
	class Default implements TradeIdentifierSequenceChoiceChoice {
	
		@Override
		public ValidationResult<TradeIdentifierSequenceChoice> validate(RosettaPath path, TradeIdentifierSequenceChoice tradeIdentifierSequenceChoice) {
			ComparisonResult result = executeDataRule(tradeIdentifierSequenceChoice);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeIdentifierSequenceChoice", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "TradeIdentifierSequenceChoice", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(TradeIdentifierSequenceChoice tradeIdentifierSequenceChoice) {
			try {
				return choice(MapperS.of(tradeIdentifierSequenceChoice), Arrays.asList("tradeId", "versionedTradeId"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeIdentifierSequenceChoiceChoice {
	
		@Override
		public ValidationResult<TradeIdentifierSequenceChoice> validate(RosettaPath path, TradeIdentifierSequenceChoice tradeIdentifierSequenceChoice) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeIdentifierSequenceChoice", path, DEFINITION);
		}
	}
}
