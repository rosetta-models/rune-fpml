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
import fpml.confirmation.MutualOrOptionalEarlyTerminationModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("MutualOrOptionalEarlyTerminationModelChoice")
@ImplementedBy(MutualOrOptionalEarlyTerminationModelChoice.Default.class)
public interface MutualOrOptionalEarlyTerminationModelChoice extends Validator<MutualOrOptionalEarlyTerminationModel> {
	
	String NAME = "MutualOrOptionalEarlyTerminationModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<MutualOrOptionalEarlyTerminationModel> validate(RosettaPath path, MutualOrOptionalEarlyTerminationModel mutualOrOptionalEarlyTerminationModel);
	
	class Default implements MutualOrOptionalEarlyTerminationModelChoice {
	
		@Override
		public ValidationResult<MutualOrOptionalEarlyTerminationModel> validate(RosettaPath path, MutualOrOptionalEarlyTerminationModel mutualOrOptionalEarlyTerminationModel) {
			ComparisonResult result = executeDataRule(mutualOrOptionalEarlyTerminationModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MutualOrOptionalEarlyTerminationModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "MutualOrOptionalEarlyTerminationModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(MutualOrOptionalEarlyTerminationModel mutualOrOptionalEarlyTerminationModel) {
			try {
				return choice(MapperS.of(mutualOrOptionalEarlyTerminationModel), Arrays.asList("mutualEarlyTermination", "mutualOrOptionalEarlyTerminationModelSequence"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MutualOrOptionalEarlyTerminationModelChoice {
	
		@Override
		public ValidationResult<MutualOrOptionalEarlyTerminationModel> validate(RosettaPath path, MutualOrOptionalEarlyTerminationModel mutualOrOptionalEarlyTerminationModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MutualOrOptionalEarlyTerminationModel", path, DEFINITION);
		}
	}
}
