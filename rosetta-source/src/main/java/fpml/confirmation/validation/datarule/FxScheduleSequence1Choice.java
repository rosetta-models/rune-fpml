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
import fpml.confirmation.FxScheduleSequence1;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("FxScheduleSequence1Choice")
@ImplementedBy(FxScheduleSequence1Choice.Default.class)
public interface FxScheduleSequence1Choice extends Validator<FxScheduleSequence1> {
	
	String NAME = "FxScheduleSequence1Choice";
	String DEFINITION = "required choice parametricScheduleModel, dateOffset";
	
	ValidationResult<FxScheduleSequence1> validate(RosettaPath path, FxScheduleSequence1 fxScheduleSequence1);
	
	class Default implements FxScheduleSequence1Choice {
	
		@Override
		public ValidationResult<FxScheduleSequence1> validate(RosettaPath path, FxScheduleSequence1 fxScheduleSequence1) {
			ComparisonResult result = executeDataRule(fxScheduleSequence1);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxScheduleSequence1", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxScheduleSequence1", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxScheduleSequence1 fxScheduleSequence1) {
			try {
				return choice(MapperS.of(fxScheduleSequence1), Arrays.asList("parametricScheduleModel", "dateOffset"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxScheduleSequence1Choice {
	
		@Override
		public ValidationResult<FxScheduleSequence1> validate(RosettaPath path, FxScheduleSequence1 fxScheduleSequence1) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxScheduleSequence1", path, DEFINITION);
		}
	}
}
