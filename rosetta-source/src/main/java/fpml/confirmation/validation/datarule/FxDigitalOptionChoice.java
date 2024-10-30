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
import fpml.confirmation.FxDigitalOption;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("FxDigitalOptionChoice")
@ImplementedBy(FxDigitalOptionChoice.Default.class)
public interface FxDigitalOptionChoice extends Validator<FxDigitalOption> {
	
	String NAME = "FxDigitalOptionChoice";
	String DEFINITION = "required choice fxDigitalOptionSequence0, fxDigitalOptionSequence1";
	
	ValidationResult<FxDigitalOption> validate(RosettaPath path, FxDigitalOption fxDigitalOption);
	
	class Default implements FxDigitalOptionChoice {
	
		@Override
		public ValidationResult<FxDigitalOption> validate(RosettaPath path, FxDigitalOption fxDigitalOption) {
			ComparisonResult result = executeDataRule(fxDigitalOption);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxDigitalOption", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxDigitalOption", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxDigitalOption fxDigitalOption) {
			try {
				return choice(MapperS.of(fxDigitalOption), Arrays.asList("fxDigitalOptionSequence0", "fxDigitalOptionSequence1"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxDigitalOptionChoice {
	
		@Override
		public ValidationResult<FxDigitalOption> validate(RosettaPath path, FxDigitalOption fxDigitalOption) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxDigitalOption", path, DEFINITION);
		}
	}
}
