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
import fpml.confirmation.PersonSequence;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("PersonSequenceChoice")
@ImplementedBy(PersonSequenceChoice.Default.class)
public interface PersonSequenceChoice extends Validator<PersonSequence> {
	
	String NAME = "PersonSequenceChoice";
	String DEFINITION = "optional choice middleName, initial";
	
	ValidationResult<PersonSequence> validate(RosettaPath path, PersonSequence personSequence);
	
	class Default implements PersonSequenceChoice {
	
		@Override
		public ValidationResult<PersonSequence> validate(RosettaPath path, PersonSequence personSequence) {
			ComparisonResult result = executeDataRule(personSequence);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PersonSequence", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "PersonSequence", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(PersonSequence personSequence) {
			try {
				return choice(MapperS.of(personSequence), Arrays.asList("middleName", "initial"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PersonSequenceChoice {
	
		@Override
		public ValidationResult<PersonSequence> validate(RosettaPath path, PersonSequence personSequence) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PersonSequence", path, DEFINITION);
		}
	}
}
