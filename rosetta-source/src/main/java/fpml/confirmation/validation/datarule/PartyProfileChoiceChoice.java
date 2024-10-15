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
import fpml.confirmation.PartyProfileChoice;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("PartyProfileChoiceChoice")
@ImplementedBy(PartyProfileChoiceChoice.Default.class)
public interface PartyProfileChoiceChoice extends Validator<PartyProfileChoice> {
	
	String NAME = "PartyProfileChoiceChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<PartyProfileChoice> validate(RosettaPath path, PartyProfileChoice partyProfileChoice);
	
	class Default implements PartyProfileChoiceChoice {
	
		@Override
		public ValidationResult<PartyProfileChoice> validate(RosettaPath path, PartyProfileChoice partyProfileChoice) {
			ComparisonResult result = executeDataRule(partyProfileChoice);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PartyProfileChoice", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "PartyProfileChoice", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(PartyProfileChoice partyProfileChoice) {
			try {
				return choice(MapperS.of(partyProfileChoice), Arrays.asList("communicationDetails", "settlementInstructionDetails"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PartyProfileChoiceChoice {
	
		@Override
		public ValidationResult<PartyProfileChoice> validate(RosettaPath path, PartyProfileChoice partyProfileChoice) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PartyProfileChoice", path, DEFINITION);
		}
	}
}
