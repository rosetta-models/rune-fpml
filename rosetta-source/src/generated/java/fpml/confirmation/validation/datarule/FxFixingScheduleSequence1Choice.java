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
import fpml.confirmation.FxFixingScheduleSequence1;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("FxFixingScheduleSequence1Choice")
@ImplementedBy(FxFixingScheduleSequence1Choice.Default.class)
public interface FxFixingScheduleSequence1Choice extends Validator<FxFixingScheduleSequence1> {
	
	String NAME = "FxFixingScheduleSequence1Choice";
	String DEFINITION = "optional choice numberOfFixings, fixingDate";
	
	ValidationResult<FxFixingScheduleSequence1> validate(RosettaPath path, FxFixingScheduleSequence1 fxFixingScheduleSequence1);
	
	class Default implements FxFixingScheduleSequence1Choice {
	
		@Override
		public ValidationResult<FxFixingScheduleSequence1> validate(RosettaPath path, FxFixingScheduleSequence1 fxFixingScheduleSequence1) {
			ComparisonResult result = executeDataRule(fxFixingScheduleSequence1);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxFixingScheduleSequence1", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxFixingScheduleSequence1", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxFixingScheduleSequence1 fxFixingScheduleSequence1) {
			try {
				return choice(MapperS.of(fxFixingScheduleSequence1), Arrays.asList("numberOfFixings", "fixingDate"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxFixingScheduleSequence1Choice {
	
		@Override
		public ValidationResult<FxFixingScheduleSequence1> validate(RosettaPath path, FxFixingScheduleSequence1 fxFixingScheduleSequence1) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxFixingScheduleSequence1", path, DEFINITION);
		}
	}
}
