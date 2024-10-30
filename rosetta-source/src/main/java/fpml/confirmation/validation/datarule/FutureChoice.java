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
import fpml.confirmation.Future;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("FutureChoice")
@ImplementedBy(FutureChoice.Default.class)
public interface FutureChoice extends Validator<Future> {
	
	String NAME = "FutureChoice";
	String DEFINITION = "optional choice maturity, contractYearMonth";
	
	ValidationResult<Future> validate(RosettaPath path, Future future);
	
	class Default implements FutureChoice {
	
		@Override
		public ValidationResult<Future> validate(RosettaPath path, Future future) {
			ComparisonResult result = executeDataRule(future);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Future", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "Future", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(Future future) {
			try {
				return choice(MapperS.of(future), Arrays.asList("maturity", "contractYearMonth"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FutureChoice {
	
		@Override
		public ValidationResult<Future> validate(RosettaPath path, Future future) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Future", path, DEFINITION);
		}
	}
}
