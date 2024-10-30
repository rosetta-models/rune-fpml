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
import fpml.confirmation.FxAccrualBarrier;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("FxAccrualBarrierChoice")
@ImplementedBy(FxAccrualBarrierChoice.Default.class)
public interface FxAccrualBarrierChoice extends Validator<FxAccrualBarrier> {
	
	String NAME = "FxAccrualBarrierChoice";
	String DEFINITION = "optional choice observableReference, fxAccrualBarrierSequence";
	
	ValidationResult<FxAccrualBarrier> validate(RosettaPath path, FxAccrualBarrier fxAccrualBarrier);
	
	class Default implements FxAccrualBarrierChoice {
	
		@Override
		public ValidationResult<FxAccrualBarrier> validate(RosettaPath path, FxAccrualBarrier fxAccrualBarrier) {
			ComparisonResult result = executeDataRule(fxAccrualBarrier);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAccrualBarrier", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxAccrualBarrier", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxAccrualBarrier fxAccrualBarrier) {
			try {
				return choice(MapperS.of(fxAccrualBarrier), Arrays.asList("observableReference", "fxAccrualBarrierSequence"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxAccrualBarrierChoice {
	
		@Override
		public ValidationResult<FxAccrualBarrier> validate(RosettaPath path, FxAccrualBarrier fxAccrualBarrier) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAccrualBarrier", path, DEFINITION);
		}
	}
}
