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
import fpml.confirmation.CreditOptionStrike;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CreditOptionStrikeChoice")
@ImplementedBy(CreditOptionStrikeChoice.Default.class)
public interface CreditOptionStrikeChoice extends Validator<CreditOptionStrike> {
	
	String NAME = "CreditOptionStrikeChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<CreditOptionStrike> validate(RosettaPath path, CreditOptionStrike creditOptionStrike);
	
	class Default implements CreditOptionStrikeChoice {
	
		@Override
		public ValidationResult<CreditOptionStrike> validate(RosettaPath path, CreditOptionStrike creditOptionStrike) {
			ComparisonResult result = executeDataRule(creditOptionStrike);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditOptionStrike", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CreditOptionStrike", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CreditOptionStrike creditOptionStrike) {
			try {
				return choice(MapperS.of(creditOptionStrike), Arrays.asList("spread", "price", "strikeReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CreditOptionStrikeChoice {
	
		@Override
		public ValidationResult<CreditOptionStrike> validate(RosettaPath path, CreditOptionStrike creditOptionStrike) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditOptionStrike", path, DEFINITION);
		}
	}
}
