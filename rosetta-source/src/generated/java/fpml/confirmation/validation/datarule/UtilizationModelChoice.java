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
import fpml.confirmation.UtilizationModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("UtilizationModelChoice")
@ImplementedBy(UtilizationModelChoice.Default.class)
public interface UtilizationModelChoice extends Validator<UtilizationModel> {
	
	String NAME = "UtilizationModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<UtilizationModel> validate(RosettaPath path, UtilizationModel utilizationModel);
	
	class Default implements UtilizationModelChoice {
	
		@Override
		public ValidationResult<UtilizationModel> validate(RosettaPath path, UtilizationModel utilizationModel) {
			ComparisonResult result = executeDataRule(utilizationModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "UtilizationModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "UtilizationModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(UtilizationModel utilizationModel) {
			try {
				return choice(MapperS.of(utilizationModel), Arrays.asList("utilizationModelSequence0", "utilizationModelSequence1"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements UtilizationModelChoice {
	
		@Override
		public ValidationResult<UtilizationModel> validate(RosettaPath path, UtilizationModel utilizationModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "UtilizationModel", path, DEFINITION);
		}
	}
}
