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
import fpml.confirmation.StubValue;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("StubValueChoice")
@ImplementedBy(StubValueChoice.Default.class)
public interface StubValueChoice extends Validator<StubValue> {
	
	String NAME = "StubValueChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<StubValue> validate(RosettaPath path, StubValue stubValue);
	
	class Default implements StubValueChoice {
	
		@Override
		public ValidationResult<StubValue> validate(RosettaPath path, StubValue stubValue) {
			ComparisonResult result = executeDataRule(stubValue);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "StubValue", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "StubValue", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(StubValue stubValue) {
			try {
				return choice(MapperS.of(stubValue), Arrays.asList("floatingRate", "stubRate", "stubAmount"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements StubValueChoice {
	
		@Override
		public ValidationResult<StubValue> validate(RosettaPath path, StubValue stubValue) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "StubValue", path, DEFINITION);
		}
	}
}
