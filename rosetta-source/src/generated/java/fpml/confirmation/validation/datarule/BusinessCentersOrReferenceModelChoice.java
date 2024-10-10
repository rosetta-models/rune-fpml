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
import fpml.confirmation.BusinessCentersOrReferenceModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("BusinessCentersOrReferenceModelChoice")
@ImplementedBy(BusinessCentersOrReferenceModelChoice.Default.class)
public interface BusinessCentersOrReferenceModelChoice extends Validator<BusinessCentersOrReferenceModel> {
	
	String NAME = "BusinessCentersOrReferenceModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<BusinessCentersOrReferenceModel> validate(RosettaPath path, BusinessCentersOrReferenceModel businessCentersOrReferenceModel);
	
	class Default implements BusinessCentersOrReferenceModelChoice {
	
		@Override
		public ValidationResult<BusinessCentersOrReferenceModel> validate(RosettaPath path, BusinessCentersOrReferenceModel businessCentersOrReferenceModel) {
			ComparisonResult result = executeDataRule(businessCentersOrReferenceModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "BusinessCentersOrReferenceModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "BusinessCentersOrReferenceModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(BusinessCentersOrReferenceModel businessCentersOrReferenceModel) {
			try {
				return choice(MapperS.of(businessCentersOrReferenceModel), Arrays.asList("businessCentersReference", "businessCenters"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements BusinessCentersOrReferenceModelChoice {
	
		@Override
		public ValidationResult<BusinessCentersOrReferenceModel> validate(RosettaPath path, BusinessCentersOrReferenceModel businessCentersOrReferenceModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "BusinessCentersOrReferenceModel", path, DEFINITION);
		}
	}
}
