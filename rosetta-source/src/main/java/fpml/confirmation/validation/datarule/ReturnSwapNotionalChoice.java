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
import fpml.confirmation.ReturnSwapNotional;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("ReturnSwapNotionalChoice")
@ImplementedBy(ReturnSwapNotionalChoice.Default.class)
public interface ReturnSwapNotionalChoice extends Validator<ReturnSwapNotional> {
	
	String NAME = "ReturnSwapNotionalChoice";
	String DEFINITION = "required choice relativeNotionalAmount, relativeDeterminationMethod , determinationMethod , notionalAmount";
	
	ValidationResult<ReturnSwapNotional> validate(RosettaPath path, ReturnSwapNotional returnSwapNotional);
	
	class Default implements ReturnSwapNotionalChoice {
	
		@Override
		public ValidationResult<ReturnSwapNotional> validate(RosettaPath path, ReturnSwapNotional returnSwapNotional) {
			ComparisonResult result = executeDataRule(returnSwapNotional);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ReturnSwapNotional", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "ReturnSwapNotional", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(ReturnSwapNotional returnSwapNotional) {
			try {
				return choice(MapperS.of(returnSwapNotional), Arrays.asList("relativeNotionalAmount", "relativeDeterminationMethod", "determinationMethod", "notionalAmount"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ReturnSwapNotionalChoice {
	
		@Override
		public ValidationResult<ReturnSwapNotional> validate(RosettaPath path, ReturnSwapNotional returnSwapNotional) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ReturnSwapNotional", path, DEFINITION);
		}
	}
}
