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
import fpml.confirmation.TradeIdentifier;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("TradeIdentifierChoice")
@ImplementedBy(TradeIdentifierChoice.Default.class)
public interface TradeIdentifierChoice extends Validator<TradeIdentifier> {
	
	String NAME = "TradeIdentifierChoice";
	String DEFINITION = "required choice issuerTradeIdModel, tradeIdentifierSequence";
	
	ValidationResult<TradeIdentifier> validate(RosettaPath path, TradeIdentifier tradeIdentifier);
	
	class Default implements TradeIdentifierChoice {
	
		@Override
		public ValidationResult<TradeIdentifier> validate(RosettaPath path, TradeIdentifier tradeIdentifier) {
			ComparisonResult result = executeDataRule(tradeIdentifier);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeIdentifier", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "TradeIdentifier", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(TradeIdentifier tradeIdentifier) {
			try {
				return choice(MapperS.of(tradeIdentifier), Arrays.asList("issuerTradeIdModel", "tradeIdentifierSequence"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeIdentifierChoice {
	
		@Override
		public ValidationResult<TradeIdentifier> validate(RosettaPath path, TradeIdentifier tradeIdentifier) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeIdentifier", path, DEFINITION);
		}
	}
}
