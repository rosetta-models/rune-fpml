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
import fpml.confirmation.EquityStrike;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("EquityStrikeChoice")
@ImplementedBy(EquityStrikeChoice.Default.class)
public interface EquityStrikeChoice extends Validator<EquityStrike> {
	
	String NAME = "EquityStrikeChoice";
	String DEFINITION = "required choice strikePrice, equityStrikeSequence";
	
	ValidationResult<EquityStrike> validate(RosettaPath path, EquityStrike equityStrike);
	
	class Default implements EquityStrikeChoice {
	
		@Override
		public ValidationResult<EquityStrike> validate(RosettaPath path, EquityStrike equityStrike) {
			ComparisonResult result = executeDataRule(equityStrike);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityStrike", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "EquityStrike", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(EquityStrike equityStrike) {
			try {
				return choice(MapperS.of(equityStrike), Arrays.asList("strikePrice", "equityStrikeSequence"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EquityStrikeChoice {
	
		@Override
		public ValidationResult<EquityStrike> validate(RosettaPath path, EquityStrike equityStrike) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityStrike", path, DEFINITION);
		}
	}
}
