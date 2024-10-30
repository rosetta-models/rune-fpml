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
import fpml.confirmation.DividendConditions;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("DividendConditionsChoice")
@ImplementedBy(DividendConditionsChoice.Default.class)
public interface DividendConditionsChoice extends Validator<DividendConditions> {
	
	String NAME = "DividendConditionsChoice";
	String DEFINITION = "required choice dividendConditionsSequence, dividendPeriod";
	
	ValidationResult<DividendConditions> validate(RosettaPath path, DividendConditions dividendConditions);
	
	class Default implements DividendConditionsChoice {
	
		@Override
		public ValidationResult<DividendConditions> validate(RosettaPath path, DividendConditions dividendConditions) {
			ComparisonResult result = executeDataRule(dividendConditions);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DividendConditions", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "DividendConditions", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(DividendConditions dividendConditions) {
			try {
				return choice(MapperS.of(dividendConditions), Arrays.asList("dividendConditionsSequence", "dividendPeriod"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements DividendConditionsChoice {
	
		@Override
		public ValidationResult<DividendConditions> validate(RosettaPath path, DividendConditions dividendConditions) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DividendConditions", path, DEFINITION);
		}
	}
}
