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
import fpml.confirmation.FxAsianFeature;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("FxAsianFeatureChoice")
@ImplementedBy(FxAsianFeatureChoice.Default.class)
public interface FxAsianFeatureChoice extends Validator<FxAsianFeature> {
	
	String NAME = "FxAsianFeatureChoice";
	String DEFINITION = "required choice fxAsianFeatureSequence, fxRateObservationModel";
	
	ValidationResult<FxAsianFeature> validate(RosettaPath path, FxAsianFeature fxAsianFeature);
	
	class Default implements FxAsianFeatureChoice {
	
		@Override
		public ValidationResult<FxAsianFeature> validate(RosettaPath path, FxAsianFeature fxAsianFeature) {
			ComparisonResult result = executeDataRule(fxAsianFeature);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAsianFeature", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxAsianFeature", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxAsianFeature fxAsianFeature) {
			try {
				return choice(MapperS.of(fxAsianFeature), Arrays.asList("fxAsianFeatureSequence", "fxRateObservationModel"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxAsianFeatureChoice {
	
		@Override
		public ValidationResult<FxAsianFeature> validate(RosettaPath path, FxAsianFeature fxAsianFeature) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAsianFeature", path, DEFINITION);
		}
	}
}
