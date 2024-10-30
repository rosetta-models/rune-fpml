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
import fpml.confirmation.FxTargetConditionLevelModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("FxTargetConditionLevelModelChoice")
@ImplementedBy(FxTargetConditionLevelModelChoice.Default.class)
public interface FxTargetConditionLevelModelChoice extends Validator<FxTargetConditionLevelModel> {
	
	String NAME = "FxTargetConditionLevelModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<FxTargetConditionLevelModel> validate(RosettaPath path, FxTargetConditionLevelModel fxTargetConditionLevelModel);
	
	class Default implements FxTargetConditionLevelModelChoice {
	
		@Override
		public ValidationResult<FxTargetConditionLevelModel> validate(RosettaPath path, FxTargetConditionLevelModel fxTargetConditionLevelModel) {
			ComparisonResult result = executeDataRule(fxTargetConditionLevelModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTargetConditionLevelModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxTargetConditionLevelModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxTargetConditionLevelModel fxTargetConditionLevelModel) {
			try {
				return choice(MapperS.of(fxTargetConditionLevelModel), Arrays.asList("level", "strikeReference", "pivotReference", "barrierReference", "levelReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxTargetConditionLevelModelChoice {
	
		@Override
		public ValidationResult<FxTargetConditionLevelModel> validate(RosettaPath path, FxTargetConditionLevelModel fxTargetConditionLevelModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTargetConditionLevelModel", path, DEFINITION);
		}
	}
}
