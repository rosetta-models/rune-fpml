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
import fpml.confirmation.FxAccrualRegion;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("FxAccrualRegionChoice0")
@ImplementedBy(FxAccrualRegionChoice0.Default.class)
public interface FxAccrualRegionChoice0 extends Validator<FxAccrualRegion> {
	
	String NAME = "FxAccrualRegionChoice0";
	String DEFINITION = "optional choice fxAccrualRegionSequence0, endDate";
	
	ValidationResult<FxAccrualRegion> validate(RosettaPath path, FxAccrualRegion fxAccrualRegion);
	
	class Default implements FxAccrualRegionChoice0 {
	
		@Override
		public ValidationResult<FxAccrualRegion> validate(RosettaPath path, FxAccrualRegion fxAccrualRegion) {
			ComparisonResult result = executeDataRule(fxAccrualRegion);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAccrualRegion", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxAccrualRegion", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxAccrualRegion fxAccrualRegion) {
			try {
				return choice(MapperS.of(fxAccrualRegion), Arrays.asList("fxAccrualRegionSequence0", "endDate"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxAccrualRegionChoice0 {
	
		@Override
		public ValidationResult<FxAccrualRegion> validate(RosettaPath path, FxAccrualRegion fxAccrualRegion) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAccrualRegion", path, DEFINITION);
		}
	}
}
