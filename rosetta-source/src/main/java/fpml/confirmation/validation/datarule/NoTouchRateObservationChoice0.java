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
import fpml.confirmation.NoTouchRateObservation;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("NoTouchRateObservationChoice0")
@ImplementedBy(NoTouchRateObservationChoice0.Default.class)
public interface NoTouchRateObservationChoice0 extends Validator<NoTouchRateObservation> {
	
	String NAME = "NoTouchRateObservationChoice0";
	String DEFINITION = "required choice noTouchRateObservationSequence0, upperBarrier";
	
	ValidationResult<NoTouchRateObservation> validate(RosettaPath path, NoTouchRateObservation noTouchRateObservation);
	
	class Default implements NoTouchRateObservationChoice0 {
	
		@Override
		public ValidationResult<NoTouchRateObservation> validate(RosettaPath path, NoTouchRateObservation noTouchRateObservation) {
			ComparisonResult result = executeDataRule(noTouchRateObservation);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "NoTouchRateObservation", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "NoTouchRateObservation", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(NoTouchRateObservation noTouchRateObservation) {
			try {
				return choice(MapperS.of(noTouchRateObservation), Arrays.asList("noTouchRateObservationSequence0", "upperBarrier"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements NoTouchRateObservationChoice0 {
	
		@Override
		public ValidationResult<NoTouchRateObservation> validate(RosettaPath path, NoTouchRateObservation noTouchRateObservation) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "NoTouchRateObservation", path, DEFINITION);
		}
	}
}
