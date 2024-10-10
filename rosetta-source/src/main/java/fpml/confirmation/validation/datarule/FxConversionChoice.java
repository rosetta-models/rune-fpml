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
import fpml.confirmation.FxConversion;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("FxConversionChoice")
@ImplementedBy(FxConversionChoice.Default.class)
public interface FxConversionChoice extends Validator<FxConversion> {
	
	String NAME = "FxConversionChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<FxConversion> validate(RosettaPath path, FxConversion fxConversion);
	
	class Default implements FxConversionChoice {
	
		@Override
		public ValidationResult<FxConversion> validate(RosettaPath path, FxConversion fxConversion) {
			ComparisonResult result = executeDataRule(fxConversion);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxConversion", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxConversion", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxConversion fxConversion) {
			try {
				return choice(MapperS.of(fxConversion), Arrays.asList("amountRelativeTo", "fxRate"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxConversionChoice {
	
		@Override
		public ValidationResult<FxConversion> validate(RosettaPath path, FxConversion fxConversion) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxConversion", path, DEFINITION);
		}
	}
}
