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
import fpml.confirmation.FxSchedule;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("FxScheduleChoice")
@ImplementedBy(FxScheduleChoice.Default.class)
public interface FxScheduleChoice extends Validator<FxSchedule> {
	
	String NAME = "FxScheduleChoice";
	String DEFINITION = "required choice fxScheduleSequence0, fxScheduleSequence1";
	
	ValidationResult<FxSchedule> validate(RosettaPath path, FxSchedule fxSchedule);
	
	class Default implements FxScheduleChoice {
	
		@Override
		public ValidationResult<FxSchedule> validate(RosettaPath path, FxSchedule fxSchedule) {
			ComparisonResult result = executeDataRule(fxSchedule);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxSchedule", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxSchedule", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxSchedule fxSchedule) {
			try {
				return choice(MapperS.of(fxSchedule), Arrays.asList("fxScheduleSequence0", "fxScheduleSequence1"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxScheduleChoice {
	
		@Override
		public ValidationResult<FxSchedule> validate(RosettaPath path, FxSchedule fxSchedule) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxSchedule", path, DEFINITION);
		}
	}
}
