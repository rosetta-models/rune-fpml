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
import fpml.confirmation.TradingInstructionOverride;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("TradingInstructionOverrideChoice")
@ImplementedBy(TradingInstructionOverrideChoice.Default.class)
public interface TradingInstructionOverrideChoice extends Validator<TradingInstructionOverride> {
	
	String NAME = "TradingInstructionOverrideChoice";
	String DEFINITION = "required choice allocationIdentifier, loanTradeReference";
	
	ValidationResult<TradingInstructionOverride> validate(RosettaPath path, TradingInstructionOverride tradingInstructionOverride);
	
	class Default implements TradingInstructionOverrideChoice {
	
		@Override
		public ValidationResult<TradingInstructionOverride> validate(RosettaPath path, TradingInstructionOverride tradingInstructionOverride) {
			ComparisonResult result = executeDataRule(tradingInstructionOverride);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradingInstructionOverride", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "TradingInstructionOverride", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(TradingInstructionOverride tradingInstructionOverride) {
			try {
				return choice(MapperS.of(tradingInstructionOverride), Arrays.asList("allocationIdentifier", "loanTradeReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradingInstructionOverrideChoice {
	
		@Override
		public ValidationResult<TradingInstructionOverride> validate(RosettaPath path, TradingInstructionOverride tradingInstructionOverride) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradingInstructionOverride", path, DEFINITION);
		}
	}
}
