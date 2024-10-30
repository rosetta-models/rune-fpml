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
import fpml.confirmation.PartyTradeIdentifier;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("PartyTradeIdentifierChoice")
@ImplementedBy(PartyTradeIdentifierChoice.Default.class)
public interface PartyTradeIdentifierChoice extends Validator<PartyTradeIdentifier> {
	
	String NAME = "PartyTradeIdentifierChoice";
	String DEFINITION = "required choice allocationTradeId, resultingTradeId";
	
	ValidationResult<PartyTradeIdentifier> validate(RosettaPath path, PartyTradeIdentifier partyTradeIdentifier);
	
	class Default implements PartyTradeIdentifierChoice {
	
		@Override
		public ValidationResult<PartyTradeIdentifier> validate(RosettaPath path, PartyTradeIdentifier partyTradeIdentifier) {
			ComparisonResult result = executeDataRule(partyTradeIdentifier);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PartyTradeIdentifier", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "PartyTradeIdentifier", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(PartyTradeIdentifier partyTradeIdentifier) {
			try {
				return choice(MapperS.of(partyTradeIdentifier), Arrays.asList("allocationTradeId", "resultingTradeId"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PartyTradeIdentifierChoice {
	
		@Override
		public ValidationResult<PartyTradeIdentifier> validate(RosettaPath path, PartyTradeIdentifier partyTradeIdentifier) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PartyTradeIdentifier", path, DEFINITION);
		}
	}
}
