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
import fpml.confirmation.SensitivityDescriptionModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("SensitivityDescriptionModelChoice")
@ImplementedBy(SensitivityDescriptionModelChoice.Default.class)
public interface SensitivityDescriptionModelChoice extends Validator<SensitivityDescriptionModel> {
	
	String NAME = "SensitivityDescriptionModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<SensitivityDescriptionModel> validate(RosettaPath path, SensitivityDescriptionModel sensitivityDescriptionModel);
	
	class Default implements SensitivityDescriptionModelChoice {
	
		@Override
		public ValidationResult<SensitivityDescriptionModel> validate(RosettaPath path, SensitivityDescriptionModel sensitivityDescriptionModel) {
			ComparisonResult result = executeDataRule(sensitivityDescriptionModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SensitivityDescriptionModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "SensitivityDescriptionModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(SensitivityDescriptionModel sensitivityDescriptionModel) {
			try {
				return choice(MapperS.of(sensitivityDescriptionModel), Arrays.asList("term", "pricingCoordinateOrReferenceModel"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SensitivityDescriptionModelChoice {
	
		@Override
		public ValidationResult<SensitivityDescriptionModel> validate(RosettaPath path, SensitivityDescriptionModel sensitivityDescriptionModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SensitivityDescriptionModel", path, DEFINITION);
		}
	}
}
