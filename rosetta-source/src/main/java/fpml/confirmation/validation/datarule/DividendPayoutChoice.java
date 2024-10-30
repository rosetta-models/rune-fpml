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
import fpml.confirmation.DividendPayout;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("DividendPayoutChoice")
@ImplementedBy(DividendPayoutChoice.Default.class)
public interface DividendPayoutChoice extends Validator<DividendPayout> {
	
	String NAME = "DividendPayoutChoice";
	String DEFINITION = "required choice dividendPayoutSequence, dividendPayoutConditions";
	
	ValidationResult<DividendPayout> validate(RosettaPath path, DividendPayout dividendPayout);
	
	class Default implements DividendPayoutChoice {
	
		@Override
		public ValidationResult<DividendPayout> validate(RosettaPath path, DividendPayout dividendPayout) {
			ComparisonResult result = executeDataRule(dividendPayout);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DividendPayout", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "DividendPayout", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(DividendPayout dividendPayout) {
			try {
				return choice(MapperS.of(dividendPayout), Arrays.asList("dividendPayoutSequence", "dividendPayoutConditions"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements DividendPayoutChoice {
	
		@Override
		public ValidationResult<DividendPayout> validate(RosettaPath path, DividendPayout dividendPayout) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DividendPayout", path, DEFINITION);
		}
	}
}
