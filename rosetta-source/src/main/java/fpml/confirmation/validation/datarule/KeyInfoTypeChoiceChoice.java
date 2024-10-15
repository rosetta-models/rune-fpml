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
import fpml.confirmation.KeyInfoTypeChoice;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("KeyInfoTypeChoiceChoice")
@ImplementedBy(KeyInfoTypeChoiceChoice.Default.class)
public interface KeyInfoTypeChoiceChoice extends Validator<KeyInfoTypeChoice> {
	
	String NAME = "KeyInfoTypeChoiceChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<KeyInfoTypeChoice> validate(RosettaPath path, KeyInfoTypeChoice keyInfoTypeChoice);
	
	class Default implements KeyInfoTypeChoiceChoice {
	
		@Override
		public ValidationResult<KeyInfoTypeChoice> validate(RosettaPath path, KeyInfoTypeChoice keyInfoTypeChoice) {
			ComparisonResult result = executeDataRule(keyInfoTypeChoice);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "KeyInfoTypeChoice", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "KeyInfoTypeChoice", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(KeyInfoTypeChoice keyInfoTypeChoice) {
			try {
				return choice(MapperS.of(keyInfoTypeChoice), Arrays.asList("keyName", "keyValue", "retrievalMethod", "x509Data", "pgpData", "spkiData", "mgmtData"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements KeyInfoTypeChoiceChoice {
	
		@Override
		public ValidationResult<KeyInfoTypeChoice> validate(RosettaPath path, KeyInfoTypeChoice keyInfoTypeChoice) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "KeyInfoTypeChoice", path, DEFINITION);
		}
	}
}
