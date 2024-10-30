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
import fpml.confirmation.TradeChangeBase;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("TradeChangeBaseChoice")
@ImplementedBy(TradeChangeBaseChoice.Default.class)
public interface TradeChangeBaseChoice extends Validator<TradeChangeBase> {
	
	String NAME = "TradeChangeBaseChoice";
	String DEFINITION = "required choice tradeIdentifier, originalTrade";
	
	ValidationResult<TradeChangeBase> validate(RosettaPath path, TradeChangeBase tradeChangeBase);
	
	class Default implements TradeChangeBaseChoice {
	
		@Override
		public ValidationResult<TradeChangeBase> validate(RosettaPath path, TradeChangeBase tradeChangeBase) {
			ComparisonResult result = executeDataRule(tradeChangeBase);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeChangeBase", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "TradeChangeBase", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(TradeChangeBase tradeChangeBase) {
			try {
				return choice(MapperS.of(tradeChangeBase), Arrays.asList("tradeIdentifier", "originalTrade"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeChangeBaseChoice {
	
		@Override
		public ValidationResult<TradeChangeBase> validate(RosettaPath path, TradeChangeBase tradeChangeBase) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeChangeBase", path, DEFINITION);
		}
	}
}
