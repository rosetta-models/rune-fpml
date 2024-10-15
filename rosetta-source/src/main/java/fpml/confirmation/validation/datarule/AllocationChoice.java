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
import fpml.confirmation.Allocation;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("AllocationChoice")
@ImplementedBy(AllocationChoice.Default.class)
public interface AllocationChoice extends Validator<Allocation> {
	
	String NAME = "AllocationChoice";
	String DEFINITION = "required choice allocatedFraction, allocatedNotional";
	
	ValidationResult<Allocation> validate(RosettaPath path, Allocation allocation);
	
	class Default implements AllocationChoice {
	
		@Override
		public ValidationResult<Allocation> validate(RosettaPath path, Allocation allocation) {
			ComparisonResult result = executeDataRule(allocation);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Allocation", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "Allocation", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(Allocation allocation) {
			try {
				return choice(MapperS.of(allocation), Arrays.asList("allocatedFraction", "allocatedNotional"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AllocationChoice {
	
		@Override
		public ValidationResult<Allocation> validate(RosettaPath path, Allocation allocation) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Allocation", path, DEFINITION);
		}
	}
}
