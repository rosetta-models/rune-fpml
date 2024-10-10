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
import fpml.confirmation.FxFixingScheduleSimple;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("FxFixingScheduleSimpleChoice")
@ImplementedBy(FxFixingScheduleSimpleChoice.Default.class)
public interface FxFixingScheduleSimpleChoice extends Validator<FxFixingScheduleSimple> {
	
	String NAME = "FxFixingScheduleSimpleChoice";
	String DEFINITION = "required choice fxFixingScheduleSimpleSequence, endDate";
	
	ValidationResult<FxFixingScheduleSimple> validate(RosettaPath path, FxFixingScheduleSimple fxFixingScheduleSimple);
	
	class Default implements FxFixingScheduleSimpleChoice {
	
		@Override
		public ValidationResult<FxFixingScheduleSimple> validate(RosettaPath path, FxFixingScheduleSimple fxFixingScheduleSimple) {
			ComparisonResult result = executeDataRule(fxFixingScheduleSimple);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxFixingScheduleSimple", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxFixingScheduleSimple", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxFixingScheduleSimple fxFixingScheduleSimple) {
			try {
				return choice(MapperS.of(fxFixingScheduleSimple), Arrays.asList("fxFixingScheduleSimpleSequence", "endDate"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxFixingScheduleSimpleChoice {
	
		@Override
		public ValidationResult<FxFixingScheduleSimple> validate(RosettaPath path, FxFixingScheduleSimple fxFixingScheduleSimple) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxFixingScheduleSimple", path, DEFINITION);
		}
	}
}
