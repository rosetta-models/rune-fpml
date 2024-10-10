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
import fpml.confirmation.FxFixingSchedule;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("FxFixingScheduleChoice")
@ImplementedBy(FxFixingScheduleChoice.Default.class)
public interface FxFixingScheduleChoice extends Validator<FxFixingSchedule> {
	
	String NAME = "FxFixingScheduleChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<FxFixingSchedule> validate(RosettaPath path, FxFixingSchedule fxFixingSchedule);
	
	class Default implements FxFixingScheduleChoice {
	
		@Override
		public ValidationResult<FxFixingSchedule> validate(RosettaPath path, FxFixingSchedule fxFixingSchedule) {
			ComparisonResult result = executeDataRule(fxFixingSchedule);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxFixingSchedule", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxFixingSchedule", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxFixingSchedule fxFixingSchedule) {
			try {
				return choice(MapperS.of(fxFixingSchedule), Arrays.asList("fxFixingScheduleSequence0", "fxFixingScheduleSequence1"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxFixingScheduleChoice {
	
		@Override
		public ValidationResult<FxFixingSchedule> validate(RosettaPath path, FxFixingSchedule fxFixingSchedule) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxFixingSchedule", path, DEFINITION);
		}
	}
}
