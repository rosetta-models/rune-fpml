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
import fpml.confirmation.ServiceNotification;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("ServiceNotificationChoice")
@ImplementedBy(ServiceNotificationChoice.Default.class)
public interface ServiceNotificationChoice extends Validator<ServiceNotification> {
	
	String NAME = "ServiceNotificationChoice";
	String DEFINITION = "required choice status, processingStatus , advisory";
	
	ValidationResult<ServiceNotification> validate(RosettaPath path, ServiceNotification serviceNotification);
	
	class Default implements ServiceNotificationChoice {
	
		@Override
		public ValidationResult<ServiceNotification> validate(RosettaPath path, ServiceNotification serviceNotification) {
			ComparisonResult result = executeDataRule(serviceNotification);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ServiceNotification", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "ServiceNotification", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(ServiceNotification serviceNotification) {
			try {
				return choice(MapperS.of(serviceNotification), Arrays.asList("status", "processingStatus", "advisory"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ServiceNotificationChoice {
	
		@Override
		public ValidationResult<ServiceNotification> validate(RosettaPath path, ServiceNotification serviceNotification) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ServiceNotification", path, DEFINITION);
		}
	}
}
