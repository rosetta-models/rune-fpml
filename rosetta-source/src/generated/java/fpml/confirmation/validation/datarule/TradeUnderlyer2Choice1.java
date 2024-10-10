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
import fpml.confirmation.TradeUnderlyer2;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("TradeUnderlyer2Choice1")
@ImplementedBy(TradeUnderlyer2Choice1.Default.class)
public interface TradeUnderlyer2Choice1 extends Validator<TradeUnderlyer2> {
	
	String NAME = "TradeUnderlyer2Choice1";
	String DEFINITION = "optional choice payerReceiverModel, buyerSellerModel";
	
	ValidationResult<TradeUnderlyer2> validate(RosettaPath path, TradeUnderlyer2 tradeUnderlyer2);
	
	class Default implements TradeUnderlyer2Choice1 {
	
		@Override
		public ValidationResult<TradeUnderlyer2> validate(RosettaPath path, TradeUnderlyer2 tradeUnderlyer2) {
			ComparisonResult result = executeDataRule(tradeUnderlyer2);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeUnderlyer2", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "TradeUnderlyer2", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(TradeUnderlyer2 tradeUnderlyer2) {
			try {
				return choice(MapperS.of(tradeUnderlyer2), Arrays.asList("payerReceiverModel", "buyerSellerModel"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeUnderlyer2Choice1 {
	
		@Override
		public ValidationResult<TradeUnderlyer2> validate(RosettaPath path, TradeUnderlyer2 tradeUnderlyer2) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeUnderlyer2", path, DEFINITION);
		}
	}
}
