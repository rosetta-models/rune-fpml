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
import fpml.confirmation.FxBarrierFeature;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("FxBarrierFeatureChoice")
@ImplementedBy(FxBarrierFeatureChoice.Default.class)
public interface FxBarrierFeatureChoice extends Validator<FxBarrierFeature> {
	
	String NAME = "FxBarrierFeatureChoice";
	String DEFINITION = "optional choice fxBarrierFeatureSequence, observationPoint";
	
	ValidationResult<FxBarrierFeature> validate(RosettaPath path, FxBarrierFeature fxBarrierFeature);
	
	class Default implements FxBarrierFeatureChoice {
	
		@Override
		public ValidationResult<FxBarrierFeature> validate(RosettaPath path, FxBarrierFeature fxBarrierFeature) {
			ComparisonResult result = executeDataRule(fxBarrierFeature);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxBarrierFeature", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxBarrierFeature", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxBarrierFeature fxBarrierFeature) {
			try {
				return choice(MapperS.of(fxBarrierFeature), Arrays.asList("fxBarrierFeatureSequence", "observationPoint"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxBarrierFeatureChoice {
	
		@Override
		public ValidationResult<FxBarrierFeature> validate(RosettaPath path, FxBarrierFeature fxBarrierFeature) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxBarrierFeature", path, DEFINITION);
		}
	}
}
