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
import fpml.confirmation.TouchRateObservationSequence;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("TouchRateObservationSequenceChoice")
@ImplementedBy(TouchRateObservationSequenceChoice.Default.class)
public interface TouchRateObservationSequenceChoice extends Validator<TouchRateObservationSequence> {
	
	String NAME = "TouchRateObservationSequenceChoice";
	String DEFINITION = "required choice settlementType, cashSettlement , physicalSettlement";
	
	ValidationResult<TouchRateObservationSequence> validate(RosettaPath path, TouchRateObservationSequence touchRateObservationSequence);
	
	class Default implements TouchRateObservationSequenceChoice {
	
		@Override
		public ValidationResult<TouchRateObservationSequence> validate(RosettaPath path, TouchRateObservationSequence touchRateObservationSequence) {
			ComparisonResult result = executeDataRule(touchRateObservationSequence);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TouchRateObservationSequence", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "TouchRateObservationSequence", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(TouchRateObservationSequence touchRateObservationSequence) {
			try {
				return choice(MapperS.of(touchRateObservationSequence), Arrays.asList("settlementType", "cashSettlement", "physicalSettlement"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TouchRateObservationSequenceChoice {
	
		@Override
		public ValidationResult<TouchRateObservationSequence> validate(RosettaPath path, TouchRateObservationSequence touchRateObservationSequence) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TouchRateObservationSequence", path, DEFINITION);
		}
	}
}
