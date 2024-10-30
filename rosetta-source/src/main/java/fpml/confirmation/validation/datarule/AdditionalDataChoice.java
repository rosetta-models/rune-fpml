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
import fpml.confirmation.AdditionalData;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("AdditionalDataChoice")
@ImplementedBy(AdditionalDataChoice.Default.class)
public interface AdditionalDataChoice extends Validator<AdditionalData> {
	
	String NAME = "AdditionalDataChoice";
	String DEFINITION = "required choice string, hexadecimalBinary , base64Binary , originalMessage";
	
	ValidationResult<AdditionalData> validate(RosettaPath path, AdditionalData additionalData);
	
	class Default implements AdditionalDataChoice {
	
		@Override
		public ValidationResult<AdditionalData> validate(RosettaPath path, AdditionalData additionalData) {
			ComparisonResult result = executeDataRule(additionalData);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AdditionalData", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "AdditionalData", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(AdditionalData additionalData) {
			try {
				return choice(MapperS.of(additionalData), Arrays.asList("string", "hexadecimalBinary", "base64Binary", "originalMessage"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AdditionalDataChoice {
	
		@Override
		public ValidationResult<AdditionalData> validate(RosettaPath path, AdditionalData additionalData) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AdditionalData", path, DEFINITION);
		}
	}
}
