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
import fpml.confirmation.TouchRateObservation;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("TouchRateObservationChoice")
@ImplementedBy(TouchRateObservationChoice.Default.class)
public interface TouchRateObservationChoice extends Validator<TouchRateObservation> {
	
	String NAME = "TouchRateObservationChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<TouchRateObservation> validate(RosettaPath path, TouchRateObservation touchRateObservation);
	
	class Default implements TouchRateObservationChoice {
	
		@Override
		public ValidationResult<TouchRateObservation> validate(RosettaPath path, TouchRateObservation touchRateObservation) {
			ComparisonResult result = executeDataRule(touchRateObservation);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TouchRateObservation", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "TouchRateObservation", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(TouchRateObservation touchRateObservation) {
			try {
				return choice(MapperS.of(touchRateObservation), Arrays.asList("observationDate", "observationTime", "informationSource", "triggerRateObservationSequence0", "triggerRateObservationSequence1", "triggerCondition", "touchRateObservationSequence", "isExercisable"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TouchRateObservationChoice {
	
		@Override
		public ValidationResult<TouchRateObservation> validate(RosettaPath path, TouchRateObservation touchRateObservation) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TouchRateObservation", path, DEFINITION);
		}
	}
}
