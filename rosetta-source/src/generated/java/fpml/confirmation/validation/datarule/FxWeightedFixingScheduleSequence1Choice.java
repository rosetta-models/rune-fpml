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
import fpml.confirmation.FxWeightedFixingScheduleSequence1;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("FxWeightedFixingScheduleSequence1Choice")
@ImplementedBy(FxWeightedFixingScheduleSequence1Choice.Default.class)
public interface FxWeightedFixingScheduleSequence1Choice extends Validator<FxWeightedFixingScheduleSequence1> {
	
	String NAME = "FxWeightedFixingScheduleSequence1Choice";
	String DEFINITION = "optional choice numberOfFixings, fixing";
	
	ValidationResult<FxWeightedFixingScheduleSequence1> validate(RosettaPath path, FxWeightedFixingScheduleSequence1 fxWeightedFixingScheduleSequence1);
	
	class Default implements FxWeightedFixingScheduleSequence1Choice {
	
		@Override
		public ValidationResult<FxWeightedFixingScheduleSequence1> validate(RosettaPath path, FxWeightedFixingScheduleSequence1 fxWeightedFixingScheduleSequence1) {
			ComparisonResult result = executeDataRule(fxWeightedFixingScheduleSequence1);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxWeightedFixingScheduleSequence1", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxWeightedFixingScheduleSequence1", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxWeightedFixingScheduleSequence1 fxWeightedFixingScheduleSequence1) {
			try {
				return choice(MapperS.of(fxWeightedFixingScheduleSequence1), Arrays.asList("numberOfFixings", "fixing"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxWeightedFixingScheduleSequence1Choice {
	
		@Override
		public ValidationResult<FxWeightedFixingScheduleSequence1> validate(RosettaPath path, FxWeightedFixingScheduleSequence1 fxWeightedFixingScheduleSequence1) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxWeightedFixingScheduleSequence1", path, DEFINITION);
		}
	}
}
