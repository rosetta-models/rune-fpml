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
import fpml.confirmation.EarlyTerminationProvision;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("EarlyTerminationProvisionChoice")
@ImplementedBy(EarlyTerminationProvisionChoice.Default.class)
public interface EarlyTerminationProvisionChoice extends Validator<EarlyTerminationProvision> {
	
	String NAME = "EarlyTerminationProvisionChoice";
	String DEFINITION = "required choice earlyTerminationProvisionSequence, optionalEarlyTerminationModel";
	
	ValidationResult<EarlyTerminationProvision> validate(RosettaPath path, EarlyTerminationProvision earlyTerminationProvision);
	
	class Default implements EarlyTerminationProvisionChoice {
	
		@Override
		public ValidationResult<EarlyTerminationProvision> validate(RosettaPath path, EarlyTerminationProvision earlyTerminationProvision) {
			ComparisonResult result = executeDataRule(earlyTerminationProvision);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EarlyTerminationProvision", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "EarlyTerminationProvision", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(EarlyTerminationProvision earlyTerminationProvision) {
			try {
				return choice(MapperS.of(earlyTerminationProvision), Arrays.asList("earlyTerminationProvisionSequence", "optionalEarlyTerminationModel"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EarlyTerminationProvisionChoice {
	
		@Override
		public ValidationResult<EarlyTerminationProvision> validate(RosettaPath path, EarlyTerminationProvision earlyTerminationProvision) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EarlyTerminationProvision", path, DEFINITION);
		}
	}
}
