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
import fpml.confirmation.FacilityLoanContractDetailsModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("FacilityLoanContractDetailsModelChoice")
@ImplementedBy(FacilityLoanContractDetailsModelChoice.Default.class)
public interface FacilityLoanContractDetailsModelChoice extends Validator<FacilityLoanContractDetailsModel> {
	
	String NAME = "FacilityLoanContractDetailsModelChoice";
	String DEFINITION = "required choice facilityLoanContractDetailsModelChoice0, facilityLoanContractDetailsModelChoice1";
	
	ValidationResult<FacilityLoanContractDetailsModel> validate(RosettaPath path, FacilityLoanContractDetailsModel facilityLoanContractDetailsModel);
	
	class Default implements FacilityLoanContractDetailsModelChoice {
	
		@Override
		public ValidationResult<FacilityLoanContractDetailsModel> validate(RosettaPath path, FacilityLoanContractDetailsModel facilityLoanContractDetailsModel) {
			ComparisonResult result = executeDataRule(facilityLoanContractDetailsModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FacilityLoanContractDetailsModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FacilityLoanContractDetailsModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FacilityLoanContractDetailsModel facilityLoanContractDetailsModel) {
			try {
				return choice(MapperS.of(facilityLoanContractDetailsModel), Arrays.asList("facilityLoanContractDetailsModelChoice0", "facilityLoanContractDetailsModelChoice1"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FacilityLoanContractDetailsModelChoice {
	
		@Override
		public ValidationResult<FacilityLoanContractDetailsModel> validate(RosettaPath path, FacilityLoanContractDetailsModel facilityLoanContractDetailsModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FacilityLoanContractDetailsModel", path, DEFINITION);
		}
	}
}
