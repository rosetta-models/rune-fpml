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
import fpml.confirmation.RequestClearingRetracted;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("RequestClearingRetractedChoice")
@ImplementedBy(RequestClearingRetractedChoice.Default.class)
public interface RequestClearingRetractedChoice extends Validator<RequestClearingRetracted> {
	
	String NAME = "RequestClearingRetractedChoice";
	String DEFINITION = "optional choice tradingEventsModel, deClear";
	
	ValidationResult<RequestClearingRetracted> validate(RosettaPath path, RequestClearingRetracted requestClearingRetracted);
	
	class Default implements RequestClearingRetractedChoice {
	
		@Override
		public ValidationResult<RequestClearingRetracted> validate(RosettaPath path, RequestClearingRetracted requestClearingRetracted) {
			ComparisonResult result = executeDataRule(requestClearingRetracted);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RequestClearingRetracted", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "RequestClearingRetracted", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(RequestClearingRetracted requestClearingRetracted) {
			try {
				return choice(MapperS.of(requestClearingRetracted), Arrays.asList("tradingEventsModel", "deClear"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RequestClearingRetractedChoice {
	
		@Override
		public ValidationResult<RequestClearingRetracted> validate(RosettaPath path, RequestClearingRetracted requestClearingRetracted) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RequestClearingRetracted", path, DEFINITION);
		}
	}
}
