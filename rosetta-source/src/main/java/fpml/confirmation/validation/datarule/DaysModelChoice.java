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
import fpml.confirmation.DaysModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("DaysModelChoice")
@ImplementedBy(DaysModelChoice.Default.class)
public interface DaysModelChoice extends Validator<DaysModel> {
	
	String NAME = "DaysModelChoice";
	String DEFINITION = "required choice daysModelSequence0, daysModelSequence1";
	
	ValidationResult<DaysModel> validate(RosettaPath path, DaysModel daysModel);
	
	class Default implements DaysModelChoice {
	
		@Override
		public ValidationResult<DaysModel> validate(RosettaPath path, DaysModel daysModel) {
			ComparisonResult result = executeDataRule(daysModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DaysModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "DaysModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(DaysModel daysModel) {
			try {
				return choice(MapperS.of(daysModel), Arrays.asList("daysModelSequence0", "daysModelSequence1"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements DaysModelChoice {
	
		@Override
		public ValidationResult<DaysModel> validate(RosettaPath path, DaysModel daysModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DaysModel", path, DEFINITION);
		}
	}
}
