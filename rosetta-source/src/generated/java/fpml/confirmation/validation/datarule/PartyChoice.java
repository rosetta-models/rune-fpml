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
import fpml.confirmation.Party;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("PartyChoice")
@ImplementedBy(PartyChoice.Default.class)
public interface PartyChoice extends Validator<Party> {
	
	String NAME = "PartyChoice";
	String DEFINITION = "required choice partyModel, partySequence";
	
	ValidationResult<Party> validate(RosettaPath path, Party party);
	
	class Default implements PartyChoice {
	
		@Override
		public ValidationResult<Party> validate(RosettaPath path, Party party) {
			ComparisonResult result = executeDataRule(party);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Party", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "Party", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(Party party) {
			try {
				return choice(MapperS.of(party), Arrays.asList("partyModel", "partySequence"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PartyChoice {
	
		@Override
		public ValidationResult<Party> validate(RosettaPath path, Party party) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Party", path, DEFINITION);
		}
	}
}
