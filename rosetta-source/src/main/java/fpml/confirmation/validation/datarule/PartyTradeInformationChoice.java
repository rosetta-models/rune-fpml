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
import fpml.confirmation.PartyTradeInformation;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("PartyTradeInformationChoice")
@ImplementedBy(PartyTradeInformationChoice.Default.class)
public interface PartyTradeInformationChoice extends Validator<PartyTradeInformation> {
	
	String NAME = "PartyTradeInformationChoice";
	String DEFINITION = "required choice partyTradeInformationSequence, endUserExceptionDeclaration";
	
	ValidationResult<PartyTradeInformation> validate(RosettaPath path, PartyTradeInformation partyTradeInformation);
	
	class Default implements PartyTradeInformationChoice {
	
		@Override
		public ValidationResult<PartyTradeInformation> validate(RosettaPath path, PartyTradeInformation partyTradeInformation) {
			ComparisonResult result = executeDataRule(partyTradeInformation);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PartyTradeInformation", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "PartyTradeInformation", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(PartyTradeInformation partyTradeInformation) {
			try {
				return choice(MapperS.of(partyTradeInformation), Arrays.asList("partyTradeInformationSequence", "endUserExceptionDeclaration"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PartyTradeInformationChoice {
	
		@Override
		public ValidationResult<PartyTradeInformation> validate(RosettaPath path, PartyTradeInformation partyTradeInformation) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PartyTradeInformation", path, DEFINITION);
		}
	}
}
