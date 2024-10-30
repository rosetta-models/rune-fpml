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
import fpml.confirmation.X509DataTypeSequence;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("X509DataTypeSequenceChoice")
@ImplementedBy(X509DataTypeSequenceChoice.Default.class)
public interface X509DataTypeSequenceChoice extends Validator<X509DataTypeSequence> {
	
	String NAME = "X509DataTypeSequenceChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<X509DataTypeSequence> validate(RosettaPath path, X509DataTypeSequence x509DataTypeSequence);
	
	class Default implements X509DataTypeSequenceChoice {
	
		@Override
		public ValidationResult<X509DataTypeSequence> validate(RosettaPath path, X509DataTypeSequence x509DataTypeSequence) {
			ComparisonResult result = executeDataRule(x509DataTypeSequence);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "X509DataTypeSequence", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "X509DataTypeSequence", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(X509DataTypeSequence x509DataTypeSequence) {
			try {
				return choice(MapperS.of(x509DataTypeSequence), Arrays.asList("x509IssuerSerial", "x509SKI", "x509SubjectName", "x509Certificate", "x509CRL"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements X509DataTypeSequenceChoice {
	
		@Override
		public ValidationResult<X509DataTypeSequence> validate(RosettaPath path, X509DataTypeSequence x509DataTypeSequence) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "X509DataTypeSequence", path, DEFINITION);
		}
	}
}
