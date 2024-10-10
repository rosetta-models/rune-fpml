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
import fpml.confirmation.FxTargetRegionBoundModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("FxTargetRegionBoundModelChoice")
@ImplementedBy(FxTargetRegionBoundModelChoice.Default.class)
public interface FxTargetRegionBoundModelChoice extends Validator<FxTargetRegionBoundModel> {
	
	String NAME = "FxTargetRegionBoundModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<FxTargetRegionBoundModel> validate(RosettaPath path, FxTargetRegionBoundModel fxTargetRegionBoundModel);
	
	class Default implements FxTargetRegionBoundModelChoice {
	
		@Override
		public ValidationResult<FxTargetRegionBoundModel> validate(RosettaPath path, FxTargetRegionBoundModel fxTargetRegionBoundModel) {
			ComparisonResult result = executeDataRule(fxTargetRegionBoundModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTargetRegionBoundModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxTargetRegionBoundModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxTargetRegionBoundModel fxTargetRegionBoundModel) {
			try {
				return choice(MapperS.of(fxTargetRegionBoundModel), Arrays.asList("upperBound", "fxTargetRegionBoundModelSequence"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxTargetRegionBoundModelChoice {
	
		@Override
		public ValidationResult<FxTargetRegionBoundModel> validate(RosettaPath path, FxTargetRegionBoundModel fxTargetRegionBoundModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTargetRegionBoundModel", path, DEFINITION);
		}
	}
}
