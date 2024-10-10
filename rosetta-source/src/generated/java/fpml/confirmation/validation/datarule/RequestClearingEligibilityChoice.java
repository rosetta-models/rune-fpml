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
import fpml.confirmation.RequestClearingEligibility;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("RequestClearingEligibilityChoice")
@ImplementedBy(RequestClearingEligibilityChoice.Default.class)
public interface RequestClearingEligibilityChoice extends Validator<RequestClearingEligibility> {
	
	String NAME = "RequestClearingEligibilityChoice";
	String DEFINITION = "required choice tradingEventsModel, deClear";
	
	ValidationResult<RequestClearingEligibility> validate(RosettaPath path, RequestClearingEligibility requestClearingEligibility);
	
	class Default implements RequestClearingEligibilityChoice {
	
		@Override
		public ValidationResult<RequestClearingEligibility> validate(RosettaPath path, RequestClearingEligibility requestClearingEligibility) {
			ComparisonResult result = executeDataRule(requestClearingEligibility);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RequestClearingEligibility", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "RequestClearingEligibility", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(RequestClearingEligibility requestClearingEligibility) {
			try {
				return choice(MapperS.of(requestClearingEligibility), Arrays.asList("tradingEventsModel", "deClear"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RequestClearingEligibilityChoice {
	
		@Override
		public ValidationResult<RequestClearingEligibility> validate(RosettaPath path, RequestClearingEligibility requestClearingEligibility) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RequestClearingEligibility", path, DEFINITION);
		}
	}
}
