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
import fpml.confirmation.StartingDate;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("StartingDateChoice")
@ImplementedBy(StartingDateChoice.Default.class)
public interface StartingDateChoice extends Validator<StartingDate> {
	
	String NAME = "StartingDateChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<StartingDate> validate(RosettaPath path, StartingDate startingDate);
	
	class Default implements StartingDateChoice {
	
		@Override
		public ValidationResult<StartingDate> validate(RosettaPath path, StartingDate startingDate) {
			ComparisonResult result = executeDataRule(startingDate);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "StartingDate", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "StartingDate", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(StartingDate startingDate) {
			try {
				return choice(MapperS.of(startingDate), Arrays.asList("dateRelativeTo", "adjustableDate"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements StartingDateChoice {
	
		@Override
		public ValidationResult<StartingDate> validate(RosettaPath path, StartingDate startingDate) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "StartingDate", path, DEFINITION);
		}
	}
}
