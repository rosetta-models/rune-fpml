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
import fpml.confirmation.InstrumentTradeQuantity;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("InstrumentTradeQuantityChoice")
@ImplementedBy(InstrumentTradeQuantityChoice.Default.class)
public interface InstrumentTradeQuantityChoice extends Validator<InstrumentTradeQuantity> {
	
	String NAME = "InstrumentTradeQuantityChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<InstrumentTradeQuantity> validate(RosettaPath path, InstrumentTradeQuantity instrumentTradeQuantity);
	
	class Default implements InstrumentTradeQuantityChoice {
	
		@Override
		public ValidationResult<InstrumentTradeQuantity> validate(RosettaPath path, InstrumentTradeQuantity instrumentTradeQuantity) {
			ComparisonResult result = executeDataRule(instrumentTradeQuantity);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "InstrumentTradeQuantity", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "InstrumentTradeQuantity", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(InstrumentTradeQuantity instrumentTradeQuantity) {
			try {
				return choice(MapperS.of(instrumentTradeQuantity), Arrays.asList("number", "nominal"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements InstrumentTradeQuantityChoice {
	
		@Override
		public ValidationResult<InstrumentTradeQuantity> validate(RosettaPath path, InstrumentTradeQuantity instrumentTradeQuantity) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "InstrumentTradeQuantity", path, DEFINITION);
		}
	}
}
