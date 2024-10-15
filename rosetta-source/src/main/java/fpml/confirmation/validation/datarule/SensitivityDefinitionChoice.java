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
import fpml.confirmation.SensitivityDefinition;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("SensitivityDefinitionChoice")
@ImplementedBy(SensitivityDefinitionChoice.Default.class)
public interface SensitivityDefinitionChoice extends Validator<SensitivityDefinition> {
	
	String NAME = "SensitivityDefinitionChoice";
	String DEFINITION = "required choice computedDerivativeModel, sensitivityDescriptionModel";
	
	ValidationResult<SensitivityDefinition> validate(RosettaPath path, SensitivityDefinition sensitivityDefinition);
	
	class Default implements SensitivityDefinitionChoice {
	
		@Override
		public ValidationResult<SensitivityDefinition> validate(RosettaPath path, SensitivityDefinition sensitivityDefinition) {
			ComparisonResult result = executeDataRule(sensitivityDefinition);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SensitivityDefinition", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "SensitivityDefinition", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(SensitivityDefinition sensitivityDefinition) {
			try {
				return choice(MapperS.of(sensitivityDefinition), Arrays.asList("computedDerivativeModel", "sensitivityDescriptionModel"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SensitivityDefinitionChoice {
	
		@Override
		public ValidationResult<SensitivityDefinition> validate(RosettaPath path, SensitivityDefinition sensitivityDefinition) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SensitivityDefinition", path, DEFINITION);
		}
	}
}
