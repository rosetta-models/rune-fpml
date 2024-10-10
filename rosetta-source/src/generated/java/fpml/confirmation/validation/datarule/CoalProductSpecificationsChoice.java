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
import fpml.confirmation.CoalProductSpecifications;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CoalProductSpecificationsChoice")
@ImplementedBy(CoalProductSpecificationsChoice.Default.class)
public interface CoalProductSpecificationsChoice extends Validator<CoalProductSpecifications> {
	
	String NAME = "CoalProductSpecificationsChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<CoalProductSpecifications> validate(RosettaPath path, CoalProductSpecifications coalProductSpecifications);
	
	class Default implements CoalProductSpecificationsChoice {
	
		@Override
		public ValidationResult<CoalProductSpecifications> validate(RosettaPath path, CoalProductSpecifications coalProductSpecifications) {
			ComparisonResult result = executeDataRule(coalProductSpecifications);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CoalProductSpecifications", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CoalProductSpecifications", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CoalProductSpecifications coalProductSpecifications) {
			try {
				return choice(MapperS.of(coalProductSpecifications), Arrays.asList("standardQuality", "standardQualitySchedule"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CoalProductSpecificationsChoice {
	
		@Override
		public ValidationResult<CoalProductSpecifications> validate(RosettaPath path, CoalProductSpecifications coalProductSpecifications) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CoalProductSpecifications", path, DEFINITION);
		}
	}
}
