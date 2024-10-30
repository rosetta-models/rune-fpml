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
import fpml.confirmation.Mortgage;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("MortgageChoice")
@ImplementedBy(MortgageChoice.Default.class)
public interface MortgageChoice extends Validator<Mortgage> {
	
	String NAME = "MortgageChoice";
	String DEFINITION = "optional choice insurer, insurerReference";
	
	ValidationResult<Mortgage> validate(RosettaPath path, Mortgage mortgage);
	
	class Default implements MortgageChoice {
	
		@Override
		public ValidationResult<Mortgage> validate(RosettaPath path, Mortgage mortgage) {
			ComparisonResult result = executeDataRule(mortgage);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Mortgage", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "Mortgage", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(Mortgage mortgage) {
			try {
				return choice(MapperS.of(mortgage), Arrays.asList("insurer", "insurerReference"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MortgageChoice {
	
		@Override
		public ValidationResult<Mortgage> validate(RosettaPath path, Mortgage mortgage) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Mortgage", path, DEFINITION);
		}
	}
}
