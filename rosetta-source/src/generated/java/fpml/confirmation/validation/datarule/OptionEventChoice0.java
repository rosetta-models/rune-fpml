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
import fpml.confirmation.OptionEvent;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("OptionEventChoice0")
@ImplementedBy(OptionEventChoice0.Default.class)
public interface OptionEventChoice0 extends Validator<OptionEvent> {
	
	String NAME = "OptionEventChoice0";
	String DEFINITION = "required choice originalTrade, tradeIdentifier";
	
	ValidationResult<OptionEvent> validate(RosettaPath path, OptionEvent optionEvent);
	
	class Default implements OptionEventChoice0 {
	
		@Override
		public ValidationResult<OptionEvent> validate(RosettaPath path, OptionEvent optionEvent) {
			ComparisonResult result = executeDataRule(optionEvent);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionEvent", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "OptionEvent", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(OptionEvent optionEvent) {
			try {
				return choice(MapperS.of(optionEvent), Arrays.asList("originalTrade", "tradeIdentifier"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OptionEventChoice0 {
	
		@Override
		public ValidationResult<OptionEvent> validate(RosettaPath path, OptionEvent optionEvent) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionEvent", path, DEFINITION);
		}
	}
}
