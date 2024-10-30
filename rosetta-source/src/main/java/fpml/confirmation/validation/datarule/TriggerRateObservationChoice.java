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
import fpml.confirmation.TriggerRateObservation;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("TriggerRateObservationChoice")
@ImplementedBy(TriggerRateObservationChoice.Default.class)
public interface TriggerRateObservationChoice extends Validator<TriggerRateObservation> {
	
	String NAME = "TriggerRateObservationChoice";
	String DEFINITION = "required choice triggerRateObservationSequence0, triggerRateObservationSequence1";
	
	ValidationResult<TriggerRateObservation> validate(RosettaPath path, TriggerRateObservation triggerRateObservation);
	
	class Default implements TriggerRateObservationChoice {
	
		@Override
		public ValidationResult<TriggerRateObservation> validate(RosettaPath path, TriggerRateObservation triggerRateObservation) {
			ComparisonResult result = executeDataRule(triggerRateObservation);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TriggerRateObservation", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "TriggerRateObservation", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(TriggerRateObservation triggerRateObservation) {
			try {
				return choice(MapperS.of(triggerRateObservation), Arrays.asList("triggerRateObservationSequence0", "triggerRateObservationSequence1"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TriggerRateObservationChoice {
	
		@Override
		public ValidationResult<TriggerRateObservation> validate(RosettaPath path, TriggerRateObservation triggerRateObservation) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TriggerRateObservation", path, DEFINITION);
		}
	}
}
