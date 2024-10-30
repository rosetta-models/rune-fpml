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
import fpml.confirmation.RequestConsentRetracted;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("RequestConsentRetractedChoice")
@ImplementedBy(RequestConsentRetractedChoice.Default.class)
public interface RequestConsentRetractedChoice extends Validator<RequestConsentRetracted> {
	
	String NAME = "RequestConsentRetractedChoice";
	String DEFINITION = "optional choice tradingAndPostTradeEventsModel, deClear";
	
	ValidationResult<RequestConsentRetracted> validate(RosettaPath path, RequestConsentRetracted requestConsentRetracted);
	
	class Default implements RequestConsentRetractedChoice {
	
		@Override
		public ValidationResult<RequestConsentRetracted> validate(RosettaPath path, RequestConsentRetracted requestConsentRetracted) {
			ComparisonResult result = executeDataRule(requestConsentRetracted);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RequestConsentRetracted", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "RequestConsentRetracted", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(RequestConsentRetracted requestConsentRetracted) {
			try {
				return choice(MapperS.of(requestConsentRetracted), Arrays.asList("tradingAndPostTradeEventsModel", "deClear"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RequestConsentRetractedChoice {
	
		@Override
		public ValidationResult<RequestConsentRetracted> validate(RosettaPath path, RequestConsentRetracted requestConsentRetracted) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RequestConsentRetracted", path, DEFINITION);
		}
	}
}
