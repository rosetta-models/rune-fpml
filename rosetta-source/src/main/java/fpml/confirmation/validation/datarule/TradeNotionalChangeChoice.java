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
import fpml.confirmation.TradeNotionalChange;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("TradeNotionalChangeChoice")
@ImplementedBy(TradeNotionalChangeChoice.Default.class)
public interface TradeNotionalChangeChoice extends Validator<TradeNotionalChange> {
	
	String NAME = "TradeNotionalChangeChoice";
	String DEFINITION = "required choice tradeNotionalChangeModel, sizeChange";
	
	ValidationResult<TradeNotionalChange> validate(RosettaPath path, TradeNotionalChange tradeNotionalChange);
	
	class Default implements TradeNotionalChangeChoice {
	
		@Override
		public ValidationResult<TradeNotionalChange> validate(RosettaPath path, TradeNotionalChange tradeNotionalChange) {
			ComparisonResult result = executeDataRule(tradeNotionalChange);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeNotionalChange", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "TradeNotionalChange", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(TradeNotionalChange tradeNotionalChange) {
			try {
				return choice(MapperS.of(tradeNotionalChange), Arrays.asList("tradeNotionalChangeModel", "sizeChange"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeNotionalChangeChoice {
	
		@Override
		public ValidationResult<TradeNotionalChange> validate(RosettaPath path, TradeNotionalChange tradeNotionalChange) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeNotionalChange", path, DEFINITION);
		}
	}
}
