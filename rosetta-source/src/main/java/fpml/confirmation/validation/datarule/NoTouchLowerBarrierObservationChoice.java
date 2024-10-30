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
import fpml.confirmation.NoTouchLowerBarrierObservation;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("NoTouchLowerBarrierObservationChoice")
@ImplementedBy(NoTouchLowerBarrierObservationChoice.Default.class)
public interface NoTouchLowerBarrierObservationChoice extends Validator<NoTouchLowerBarrierObservation> {
	
	String NAME = "NoTouchLowerBarrierObservationChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<NoTouchLowerBarrierObservation> validate(RosettaPath path, NoTouchLowerBarrierObservation noTouchLowerBarrierObservation);
	
	class Default implements NoTouchLowerBarrierObservationChoice {
	
		@Override
		public ValidationResult<NoTouchLowerBarrierObservation> validate(RosettaPath path, NoTouchLowerBarrierObservation noTouchLowerBarrierObservation) {
			ComparisonResult result = executeDataRule(noTouchLowerBarrierObservation);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "NoTouchLowerBarrierObservation", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "NoTouchLowerBarrierObservation", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(NoTouchLowerBarrierObservation noTouchLowerBarrierObservation) {
			try {
				return choice(MapperS.of(noTouchLowerBarrierObservation), Arrays.asList("noTouchLowerBarrierObservationSequence0", "noTouchLowerBarrierObservationSequence1"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements NoTouchLowerBarrierObservationChoice {
	
		@Override
		public ValidationResult<NoTouchLowerBarrierObservation> validate(RosettaPath path, NoTouchLowerBarrierObservation noTouchLowerBarrierObservation) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "NoTouchLowerBarrierObservation", path, DEFINITION);
		}
	}
}
