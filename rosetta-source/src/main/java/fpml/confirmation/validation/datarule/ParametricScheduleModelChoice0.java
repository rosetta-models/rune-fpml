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
import fpml.confirmation.ParametricScheduleModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("ParametricScheduleModelChoice0")
@ImplementedBy(ParametricScheduleModelChoice0.Default.class)
public interface ParametricScheduleModelChoice0 extends Validator<ParametricScheduleModel> {
	
	String NAME = "ParametricScheduleModelChoice0";
	String DEFINITION = "required choice parametricScheduleModelSequence0, endDate";
	
	ValidationResult<ParametricScheduleModel> validate(RosettaPath path, ParametricScheduleModel parametricScheduleModel);
	
	class Default implements ParametricScheduleModelChoice0 {
	
		@Override
		public ValidationResult<ParametricScheduleModel> validate(RosettaPath path, ParametricScheduleModel parametricScheduleModel) {
			ComparisonResult result = executeDataRule(parametricScheduleModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ParametricScheduleModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "ParametricScheduleModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(ParametricScheduleModel parametricScheduleModel) {
			try {
				return choice(MapperS.of(parametricScheduleModel), Arrays.asList("parametricScheduleModelSequence0", "endDate"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ParametricScheduleModelChoice0 {
	
		@Override
		public ValidationResult<ParametricScheduleModel> validate(RosettaPath path, ParametricScheduleModel parametricScheduleModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ParametricScheduleModel", path, DEFINITION);
		}
	}
}
