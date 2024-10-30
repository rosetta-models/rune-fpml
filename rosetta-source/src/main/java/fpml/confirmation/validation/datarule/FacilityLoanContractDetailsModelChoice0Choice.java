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
import fpml.confirmation.FacilityLoanContractDetailsModelChoice0;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("FacilityLoanContractDetailsModelChoice0Choice")
@ImplementedBy(FacilityLoanContractDetailsModelChoice0Choice.Default.class)
public interface FacilityLoanContractDetailsModelChoice0Choice extends Validator<FacilityLoanContractDetailsModelChoice0> {
	
	String NAME = "FacilityLoanContractDetailsModelChoice0Choice";
	String DEFINITION = "one-of";
	
	ValidationResult<FacilityLoanContractDetailsModelChoice0> validate(RosettaPath path, FacilityLoanContractDetailsModelChoice0 facilityLoanContractDetailsModelChoice0);
	
	class Default implements FacilityLoanContractDetailsModelChoice0Choice {
	
		@Override
		public ValidationResult<FacilityLoanContractDetailsModelChoice0> validate(RosettaPath path, FacilityLoanContractDetailsModelChoice0 facilityLoanContractDetailsModelChoice0) {
			ComparisonResult result = executeDataRule(facilityLoanContractDetailsModelChoice0);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FacilityLoanContractDetailsModelChoice0", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FacilityLoanContractDetailsModelChoice0", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FacilityLoanContractDetailsModelChoice0 facilityLoanContractDetailsModelChoice0) {
			try {
				return choice(MapperS.of(facilityLoanContractDetailsModelChoice0), Arrays.asList("loanContractIdentifier", "letterOfCreditIdentifier"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FacilityLoanContractDetailsModelChoice0Choice {
	
		@Override
		public ValidationResult<FacilityLoanContractDetailsModelChoice0> validate(RosettaPath path, FacilityLoanContractDetailsModelChoice0 facilityLoanContractDetailsModelChoice0) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FacilityLoanContractDetailsModelChoice0", path, DEFINITION);
		}
	}
}
