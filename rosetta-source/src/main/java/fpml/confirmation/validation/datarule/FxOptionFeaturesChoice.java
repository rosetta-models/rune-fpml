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
import fpml.confirmation.FxOptionFeatures;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("FxOptionFeaturesChoice")
@ImplementedBy(FxOptionFeaturesChoice.Default.class)
public interface FxOptionFeaturesChoice extends Validator<FxOptionFeatures> {
	
	String NAME = "FxOptionFeaturesChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<FxOptionFeatures> validate(RosettaPath path, FxOptionFeatures fxOptionFeatures);
	
	class Default implements FxOptionFeaturesChoice {
	
		@Override
		public ValidationResult<FxOptionFeatures> validate(RosettaPath path, FxOptionFeatures fxOptionFeatures) {
			ComparisonResult result = executeDataRule(fxOptionFeatures);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxOptionFeatures", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxOptionFeatures", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxOptionFeatures fxOptionFeatures) {
			try {
				return choice(MapperS.of(fxOptionFeatures), Arrays.asList("fxOptionFeaturesSequence", "barrier"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxOptionFeaturesChoice {
	
		@Override
		public ValidationResult<FxOptionFeatures> validate(RosettaPath path, FxOptionFeatures fxOptionFeatures) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxOptionFeatures", path, DEFINITION);
		}
	}
}
