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
import fpml.confirmation.ApprovalStatusNotification;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("ApprovalStatusNotificationChoice")
@ImplementedBy(ApprovalStatusNotificationChoice.Default.class)
public interface ApprovalStatusNotificationChoice extends Validator<ApprovalStatusNotification> {
	
	String NAME = "ApprovalStatusNotificationChoice";
	String DEFINITION = "required choice trade, tradeIdentifier";
	
	ValidationResult<ApprovalStatusNotification> validate(RosettaPath path, ApprovalStatusNotification approvalStatusNotification);
	
	class Default implements ApprovalStatusNotificationChoice {
	
		@Override
		public ValidationResult<ApprovalStatusNotification> validate(RosettaPath path, ApprovalStatusNotification approvalStatusNotification) {
			ComparisonResult result = executeDataRule(approvalStatusNotification);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ApprovalStatusNotification", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "ApprovalStatusNotification", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(ApprovalStatusNotification approvalStatusNotification) {
			try {
				return choice(MapperS.of(approvalStatusNotification), Arrays.asList("trade", "tradeIdentifier"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ApprovalStatusNotificationChoice {
	
		@Override
		public ValidationResult<ApprovalStatusNotification> validate(RosettaPath path, ApprovalStatusNotification approvalStatusNotification) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ApprovalStatusNotification", path, DEFINITION);
		}
	}
}
