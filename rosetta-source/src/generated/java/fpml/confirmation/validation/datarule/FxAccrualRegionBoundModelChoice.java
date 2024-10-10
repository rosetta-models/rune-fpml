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
import fpml.confirmation.FxAccrualRegionBoundModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("FxAccrualRegionBoundModelChoice")
@ImplementedBy(FxAccrualRegionBoundModelChoice.Default.class)
public interface FxAccrualRegionBoundModelChoice extends Validator<FxAccrualRegionBoundModel> {
	
	String NAME = "FxAccrualRegionBoundModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<FxAccrualRegionBoundModel> validate(RosettaPath path, FxAccrualRegionBoundModel fxAccrualRegionBoundModel);
	
	class Default implements FxAccrualRegionBoundModelChoice {
	
		@Override
		public ValidationResult<FxAccrualRegionBoundModel> validate(RosettaPath path, FxAccrualRegionBoundModel fxAccrualRegionBoundModel) {
			ComparisonResult result = executeDataRule(fxAccrualRegionBoundModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAccrualRegionBoundModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxAccrualRegionBoundModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxAccrualRegionBoundModel fxAccrualRegionBoundModel) {
			try {
				return choice(MapperS.of(fxAccrualRegionBoundModel), Arrays.asList("upperBound", "fxAccrualRegionBoundModelSequence"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxAccrualRegionBoundModelChoice {
	
		@Override
		public ValidationResult<FxAccrualRegionBoundModel> validate(RosettaPath path, FxAccrualRegionBoundModel fxAccrualRegionBoundModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAccrualRegionBoundModel", path, DEFINITION);
		}
	}
}
