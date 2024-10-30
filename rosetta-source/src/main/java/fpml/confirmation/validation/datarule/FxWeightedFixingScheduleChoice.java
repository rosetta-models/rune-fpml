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
import fpml.confirmation.FxWeightedFixingSchedule;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("FxWeightedFixingScheduleChoice")
@ImplementedBy(FxWeightedFixingScheduleChoice.Default.class)
public interface FxWeightedFixingScheduleChoice extends Validator<FxWeightedFixingSchedule> {
	
	String NAME = "FxWeightedFixingScheduleChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<FxWeightedFixingSchedule> validate(RosettaPath path, FxWeightedFixingSchedule fxWeightedFixingSchedule);
	
	class Default implements FxWeightedFixingScheduleChoice {
	
		@Override
		public ValidationResult<FxWeightedFixingSchedule> validate(RosettaPath path, FxWeightedFixingSchedule fxWeightedFixingSchedule) {
			ComparisonResult result = executeDataRule(fxWeightedFixingSchedule);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxWeightedFixingSchedule", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxWeightedFixingSchedule", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxWeightedFixingSchedule fxWeightedFixingSchedule) {
			try {
				return choice(MapperS.of(fxWeightedFixingSchedule), Arrays.asList("fxWeightedFixingScheduleSequence0", "fxWeightedFixingScheduleSequence1"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxWeightedFixingScheduleChoice {
	
		@Override
		public ValidationResult<FxWeightedFixingSchedule> validate(RosettaPath path, FxWeightedFixingSchedule fxWeightedFixingSchedule) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxWeightedFixingSchedule", path, DEFINITION);
		}
	}
}
