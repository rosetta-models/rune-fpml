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
import fpml.confirmation.FxAccrualConditionLevelModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("FxAccrualConditionLevelModelChoice")
@ImplementedBy(FxAccrualConditionLevelModelChoice.Default.class)
public interface FxAccrualConditionLevelModelChoice extends Validator<FxAccrualConditionLevelModel> {
	
	String NAME = "FxAccrualConditionLevelModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<FxAccrualConditionLevelModel> validate(RosettaPath path, FxAccrualConditionLevelModel fxAccrualConditionLevelModel);
	
	class Default implements FxAccrualConditionLevelModelChoice {
	
		@Override
		public ValidationResult<FxAccrualConditionLevelModel> validate(RosettaPath path, FxAccrualConditionLevelModel fxAccrualConditionLevelModel) {
			ComparisonResult result = executeDataRule(fxAccrualConditionLevelModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAccrualConditionLevelModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxAccrualConditionLevelModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxAccrualConditionLevelModel fxAccrualConditionLevelModel) {
			try {
				return choice(MapperS.of(fxAccrualConditionLevelModel), Arrays.asList("fxAccrualConditionLevelModelSequence", "strikeReference", "averageStrikeReference", "triggerReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxAccrualConditionLevelModelChoice {
	
		@Override
		public ValidationResult<FxAccrualConditionLevelModel> validate(RosettaPath path, FxAccrualConditionLevelModel fxAccrualConditionLevelModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAccrualConditionLevelModel", path, DEFINITION);
		}
	}
}
