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
import fpml.confirmation.ContractIdentifier;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("ContractIdentifierChoice")
@ImplementedBy(ContractIdentifierChoice.Default.class)
public interface ContractIdentifierChoice extends Validator<ContractIdentifier> {
	
	String NAME = "ContractIdentifierChoice";
	String DEFINITION = "required choice contractId, versionedContractId";
	
	ValidationResult<ContractIdentifier> validate(RosettaPath path, ContractIdentifier contractIdentifier);
	
	class Default implements ContractIdentifierChoice {
	
		@Override
		public ValidationResult<ContractIdentifier> validate(RosettaPath path, ContractIdentifier contractIdentifier) {
			ComparisonResult result = executeDataRule(contractIdentifier);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ContractIdentifier", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "ContractIdentifier", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(ContractIdentifier contractIdentifier) {
			try {
				return choice(MapperS.of(contractIdentifier), Arrays.asList("contractId", "versionedContractId"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ContractIdentifierChoice {
	
		@Override
		public ValidationResult<ContractIdentifier> validate(RosettaPath path, ContractIdentifier contractIdentifier) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ContractIdentifier", path, DEFINITION);
		}
	}
}
