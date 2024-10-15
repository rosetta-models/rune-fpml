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
import fpml.confirmation.NoTouchRateObservationSequence1;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("NoTouchRateObservationSequence1Choice")
@ImplementedBy(NoTouchRateObservationSequence1Choice.Default.class)
public interface NoTouchRateObservationSequence1Choice extends Validator<NoTouchRateObservationSequence1> {
	
	String NAME = "NoTouchRateObservationSequence1Choice";
	String DEFINITION = "required choice settlementType, cashSettlement , physicalSettlement";
	
	ValidationResult<NoTouchRateObservationSequence1> validate(RosettaPath path, NoTouchRateObservationSequence1 noTouchRateObservationSequence1);
	
	class Default implements NoTouchRateObservationSequence1Choice {
	
		@Override
		public ValidationResult<NoTouchRateObservationSequence1> validate(RosettaPath path, NoTouchRateObservationSequence1 noTouchRateObservationSequence1) {
			ComparisonResult result = executeDataRule(noTouchRateObservationSequence1);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "NoTouchRateObservationSequence1", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "NoTouchRateObservationSequence1", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(NoTouchRateObservationSequence1 noTouchRateObservationSequence1) {
			try {
				return choice(MapperS.of(noTouchRateObservationSequence1), Arrays.asList("settlementType", "cashSettlement", "physicalSettlement"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements NoTouchRateObservationSequence1Choice {
	
		@Override
		public ValidationResult<NoTouchRateObservationSequence1> validate(RosettaPath path, NoTouchRateObservationSequence1 noTouchRateObservationSequence1) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "NoTouchRateObservationSequence1", path, DEFINITION);
		}
	}
}
