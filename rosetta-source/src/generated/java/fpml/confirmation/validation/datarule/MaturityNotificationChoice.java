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
import fpml.confirmation.MaturityNotification;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("MaturityNotificationChoice")
@ImplementedBy(MaturityNotificationChoice.Default.class)
public interface MaturityNotificationChoice extends Validator<MaturityNotification> {
	
	String NAME = "MaturityNotificationChoice";
	String DEFINITION = "required choice optionExpiry, tradeMaturity";
	
	ValidationResult<MaturityNotification> validate(RosettaPath path, MaturityNotification maturityNotification);
	
	class Default implements MaturityNotificationChoice {
	
		@Override
		public ValidationResult<MaturityNotification> validate(RosettaPath path, MaturityNotification maturityNotification) {
			ComparisonResult result = executeDataRule(maturityNotification);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MaturityNotification", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "MaturityNotification", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(MaturityNotification maturityNotification) {
			try {
				return choice(MapperS.of(maturityNotification), Arrays.asList("optionExpiry", "tradeMaturity"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MaturityNotificationChoice {
	
		@Override
		public ValidationResult<MaturityNotification> validate(RosettaPath path, MaturityNotification maturityNotification) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MaturityNotification", path, DEFINITION);
		}
	}
}
