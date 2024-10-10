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
import fpml.confirmation.OptionalEarlyTerminationModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("OptionalEarlyTerminationModelChoice")
@ImplementedBy(OptionalEarlyTerminationModelChoice.Default.class)
public interface OptionalEarlyTerminationModelChoice extends Validator<OptionalEarlyTerminationModel> {
	
	String NAME = "OptionalEarlyTerminationModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<OptionalEarlyTerminationModel> validate(RosettaPath path, OptionalEarlyTerminationModel optionalEarlyTerminationModel);
	
	class Default implements OptionalEarlyTerminationModelChoice {
	
		@Override
		public ValidationResult<OptionalEarlyTerminationModel> validate(RosettaPath path, OptionalEarlyTerminationModel optionalEarlyTerminationModel) {
			ComparisonResult result = executeDataRule(optionalEarlyTerminationModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionalEarlyTerminationModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "OptionalEarlyTerminationModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(OptionalEarlyTerminationModel optionalEarlyTerminationModel) {
			try {
				return choice(MapperS.of(optionalEarlyTerminationModel), Arrays.asList("optionalEarlyTermination", "optionalEarlyTerminationModelSequence"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OptionalEarlyTerminationModelChoice {
	
		@Override
		public ValidationResult<OptionalEarlyTerminationModel> validate(RosettaPath path, OptionalEarlyTerminationModel optionalEarlyTerminationModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionalEarlyTerminationModel", path, DEFINITION);
		}
	}
}
