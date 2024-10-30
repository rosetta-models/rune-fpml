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
import fpml.confirmation.GenericFrequency;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("GenericFrequencyChoice")
@ImplementedBy(GenericFrequencyChoice.Default.class)
public interface GenericFrequencyChoice extends Validator<GenericFrequency> {
	
	String NAME = "GenericFrequencyChoice";
	String DEFINITION = "optional choice payerPartyReference, underlyerReference";
	
	ValidationResult<GenericFrequency> validate(RosettaPath path, GenericFrequency genericFrequency);
	
	class Default implements GenericFrequencyChoice {
	
		@Override
		public ValidationResult<GenericFrequency> validate(RosettaPath path, GenericFrequency genericFrequency) {
			ComparisonResult result = executeDataRule(genericFrequency);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "GenericFrequency", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "GenericFrequency", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(GenericFrequency genericFrequency) {
			try {
				return choice(MapperS.of(genericFrequency), Arrays.asList("payerPartyReference", "underlyerReference"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements GenericFrequencyChoice {
	
		@Override
		public ValidationResult<GenericFrequency> validate(RosettaPath path, GenericFrequency genericFrequency) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "GenericFrequency", path, DEFINITION);
		}
	}
}
