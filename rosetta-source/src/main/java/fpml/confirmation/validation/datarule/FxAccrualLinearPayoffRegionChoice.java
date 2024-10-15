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
import fpml.confirmation.FxAccrualLinearPayoffRegion;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("FxAccrualLinearPayoffRegionChoice")
@ImplementedBy(FxAccrualLinearPayoffRegionChoice.Default.class)
public interface FxAccrualLinearPayoffRegionChoice extends Validator<FxAccrualLinearPayoffRegion> {
	
	String NAME = "FxAccrualLinearPayoffRegionChoice";
	String DEFINITION = "required choice fxAccrualLinearPayoffRegionSequence, averageStrike";
	
	ValidationResult<FxAccrualLinearPayoffRegion> validate(RosettaPath path, FxAccrualLinearPayoffRegion fxAccrualLinearPayoffRegion);
	
	class Default implements FxAccrualLinearPayoffRegionChoice {
	
		@Override
		public ValidationResult<FxAccrualLinearPayoffRegion> validate(RosettaPath path, FxAccrualLinearPayoffRegion fxAccrualLinearPayoffRegion) {
			ComparisonResult result = executeDataRule(fxAccrualLinearPayoffRegion);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAccrualLinearPayoffRegion", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxAccrualLinearPayoffRegion", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxAccrualLinearPayoffRegion fxAccrualLinearPayoffRegion) {
			try {
				return choice(MapperS.of(fxAccrualLinearPayoffRegion), Arrays.asList("fxAccrualLinearPayoffRegionSequence", "averageStrike"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxAccrualLinearPayoffRegionChoice {
	
		@Override
		public ValidationResult<FxAccrualLinearPayoffRegion> validate(RosettaPath path, FxAccrualLinearPayoffRegion fxAccrualLinearPayoffRegion) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAccrualLinearPayoffRegion", path, DEFINITION);
		}
	}
}
