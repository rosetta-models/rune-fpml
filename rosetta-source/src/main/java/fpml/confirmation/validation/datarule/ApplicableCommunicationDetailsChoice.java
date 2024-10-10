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
import fpml.confirmation.ApplicableCommunicationDetails;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("ApplicableCommunicationDetailsChoice")
@ImplementedBy(ApplicableCommunicationDetailsChoice.Default.class)
public interface ApplicableCommunicationDetailsChoice extends Validator<ApplicableCommunicationDetails> {
	
	String NAME = "ApplicableCommunicationDetailsChoice";
	String DEFINITION = "required choice businessUnitReference, personReference";
	
	ValidationResult<ApplicableCommunicationDetails> validate(RosettaPath path, ApplicableCommunicationDetails applicableCommunicationDetails);
	
	class Default implements ApplicableCommunicationDetailsChoice {
	
		@Override
		public ValidationResult<ApplicableCommunicationDetails> validate(RosettaPath path, ApplicableCommunicationDetails applicableCommunicationDetails) {
			ComparisonResult result = executeDataRule(applicableCommunicationDetails);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ApplicableCommunicationDetails", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "ApplicableCommunicationDetails", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(ApplicableCommunicationDetails applicableCommunicationDetails) {
			try {
				return choice(MapperS.of(applicableCommunicationDetails), Arrays.asList("businessUnitReference", "personReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ApplicableCommunicationDetailsChoice {
	
		@Override
		public ValidationResult<ApplicableCommunicationDetails> validate(RosettaPath path, ApplicableCommunicationDetails applicableCommunicationDetails) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ApplicableCommunicationDetails", path, DEFINITION);
		}
	}
}
