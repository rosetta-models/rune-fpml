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
import fpml.confirmation.NoTouchUpperBarrierObservation;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("NoTouchUpperBarrierObservationChoice")
@ImplementedBy(NoTouchUpperBarrierObservationChoice.Default.class)
public interface NoTouchUpperBarrierObservationChoice extends Validator<NoTouchUpperBarrierObservation> {
	
	String NAME = "NoTouchUpperBarrierObservationChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<NoTouchUpperBarrierObservation> validate(RosettaPath path, NoTouchUpperBarrierObservation noTouchUpperBarrierObservation);
	
	class Default implements NoTouchUpperBarrierObservationChoice {
	
		@Override
		public ValidationResult<NoTouchUpperBarrierObservation> validate(RosettaPath path, NoTouchUpperBarrierObservation noTouchUpperBarrierObservation) {
			ComparisonResult result = executeDataRule(noTouchUpperBarrierObservation);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "NoTouchUpperBarrierObservation", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "NoTouchUpperBarrierObservation", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(NoTouchUpperBarrierObservation noTouchUpperBarrierObservation) {
			try {
				return choice(MapperS.of(noTouchUpperBarrierObservation), Arrays.asList("noTouchUpperBarrierObservationSequence0", "noTouchUpperBarrierObservationSequence1"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements NoTouchUpperBarrierObservationChoice {
	
		@Override
		public ValidationResult<NoTouchUpperBarrierObservation> validate(RosettaPath path, NoTouchUpperBarrierObservation noTouchUpperBarrierObservation) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "NoTouchUpperBarrierObservation", path, DEFINITION);
		}
	}
}
