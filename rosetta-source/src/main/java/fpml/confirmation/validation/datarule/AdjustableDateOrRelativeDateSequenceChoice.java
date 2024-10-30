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
import fpml.confirmation.AdjustableDateOrRelativeDateSequence;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("AdjustableDateOrRelativeDateSequenceChoice")
@ImplementedBy(AdjustableDateOrRelativeDateSequenceChoice.Default.class)
public interface AdjustableDateOrRelativeDateSequenceChoice extends Validator<AdjustableDateOrRelativeDateSequence> {
	
	String NAME = "AdjustableDateOrRelativeDateSequenceChoice";
	String DEFINITION = "required choice adjustableDate, relativeDateSequence";
	
	ValidationResult<AdjustableDateOrRelativeDateSequence> validate(RosettaPath path, AdjustableDateOrRelativeDateSequence adjustableDateOrRelativeDateSequence);
	
	class Default implements AdjustableDateOrRelativeDateSequenceChoice {
	
		@Override
		public ValidationResult<AdjustableDateOrRelativeDateSequence> validate(RosettaPath path, AdjustableDateOrRelativeDateSequence adjustableDateOrRelativeDateSequence) {
			ComparisonResult result = executeDataRule(adjustableDateOrRelativeDateSequence);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AdjustableDateOrRelativeDateSequence", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "AdjustableDateOrRelativeDateSequence", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(AdjustableDateOrRelativeDateSequence adjustableDateOrRelativeDateSequence) {
			try {
				return choice(MapperS.of(adjustableDateOrRelativeDateSequence), Arrays.asList("adjustableDate", "relativeDateSequence"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AdjustableDateOrRelativeDateSequenceChoice {
	
		@Override
		public ValidationResult<AdjustableDateOrRelativeDateSequence> validate(RosettaPath path, AdjustableDateOrRelativeDateSequence adjustableDateOrRelativeDateSequence) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AdjustableDateOrRelativeDateSequence", path, DEFINITION);
		}
	}
}
