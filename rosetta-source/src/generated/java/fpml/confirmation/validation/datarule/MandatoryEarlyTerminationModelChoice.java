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
import fpml.confirmation.MandatoryEarlyTerminationModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("MandatoryEarlyTerminationModelChoice")
@ImplementedBy(MandatoryEarlyTerminationModelChoice.Default.class)
public interface MandatoryEarlyTerminationModelChoice extends Validator<MandatoryEarlyTerminationModel> {
	
	String NAME = "MandatoryEarlyTerminationModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<MandatoryEarlyTerminationModel> validate(RosettaPath path, MandatoryEarlyTerminationModel mandatoryEarlyTerminationModel);
	
	class Default implements MandatoryEarlyTerminationModelChoice {
	
		@Override
		public ValidationResult<MandatoryEarlyTerminationModel> validate(RosettaPath path, MandatoryEarlyTerminationModel mandatoryEarlyTerminationModel) {
			ComparisonResult result = executeDataRule(mandatoryEarlyTerminationModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MandatoryEarlyTerminationModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "MandatoryEarlyTerminationModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(MandatoryEarlyTerminationModel mandatoryEarlyTerminationModel) {
			try {
				return choice(MapperS.of(mandatoryEarlyTerminationModel), Arrays.asList("mandatoryEarlyTermination", "mandatoryEarlyTerminationModelSequence"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MandatoryEarlyTerminationModelChoice {
	
		@Override
		public ValidationResult<MandatoryEarlyTerminationModel> validate(RosettaPath path, MandatoryEarlyTerminationModel mandatoryEarlyTerminationModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MandatoryEarlyTerminationModel", path, DEFINITION);
		}
	}
}
