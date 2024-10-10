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
import fpml.confirmation.RequestConsent;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("RequestConsentChoice")
@ImplementedBy(RequestConsentChoice.Default.class)
public interface RequestConsentChoice extends Validator<RequestConsent> {
	
	String NAME = "RequestConsentChoice";
	String DEFINITION = "required choice tradingAndPostTradeEventsModel, deClear";
	
	ValidationResult<RequestConsent> validate(RosettaPath path, RequestConsent requestConsent);
	
	class Default implements RequestConsentChoice {
	
		@Override
		public ValidationResult<RequestConsent> validate(RosettaPath path, RequestConsent requestConsent) {
			ComparisonResult result = executeDataRule(requestConsent);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RequestConsent", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "RequestConsent", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(RequestConsent requestConsent) {
			try {
				return choice(MapperS.of(requestConsent), Arrays.asList("tradingAndPostTradeEventsModel", "deClear"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RequestConsentChoice {
	
		@Override
		public ValidationResult<RequestConsent> validate(RosettaPath path, RequestConsent requestConsent) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RequestConsent", path, DEFINITION);
		}
	}
}
