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
import fpml.confirmation.FacilityLoanContractDetailsModelChoice1;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("FacilityLoanContractDetailsModelChoice1Choice")
@ImplementedBy(FacilityLoanContractDetailsModelChoice1Choice.Default.class)
public interface FacilityLoanContractDetailsModelChoice1Choice extends Validator<FacilityLoanContractDetailsModelChoice1> {
	
	String NAME = "FacilityLoanContractDetailsModelChoice1Choice";
	String DEFINITION = "one-of";
	
	ValidationResult<FacilityLoanContractDetailsModelChoice1> validate(RosettaPath path, FacilityLoanContractDetailsModelChoice1 facilityLoanContractDetailsModelChoice1);
	
	class Default implements FacilityLoanContractDetailsModelChoice1Choice {
	
		@Override
		public ValidationResult<FacilityLoanContractDetailsModelChoice1> validate(RosettaPath path, FacilityLoanContractDetailsModelChoice1 facilityLoanContractDetailsModelChoice1) {
			ComparisonResult result = executeDataRule(facilityLoanContractDetailsModelChoice1);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FacilityLoanContractDetailsModelChoice1", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FacilityLoanContractDetailsModelChoice1", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FacilityLoanContractDetailsModelChoice1 facilityLoanContractDetailsModelChoice1) {
			try {
				return choice(MapperS.of(facilityLoanContractDetailsModelChoice1), Arrays.asList("loanContract", "letterOfCredit"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FacilityLoanContractDetailsModelChoice1Choice {
	
		@Override
		public ValidationResult<FacilityLoanContractDetailsModelChoice1> validate(RosettaPath path, FacilityLoanContractDetailsModelChoice1 facilityLoanContractDetailsModelChoice1) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FacilityLoanContractDetailsModelChoice1", path, DEFINITION);
		}
	}
}
