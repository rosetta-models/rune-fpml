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
import fpml.confirmation.RequestClearing;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("RequestClearingChoice")
@ImplementedBy(RequestClearingChoice.Default.class)
public interface RequestClearingChoice extends Validator<RequestClearing> {
	
	String NAME = "RequestClearingChoice";
	String DEFINITION = "required choice tradingEventsModel, deClear";
	
	ValidationResult<RequestClearing> validate(RosettaPath path, RequestClearing requestClearing);
	
	class Default implements RequestClearingChoice {
	
		@Override
		public ValidationResult<RequestClearing> validate(RosettaPath path, RequestClearing requestClearing) {
			ComparisonResult result = executeDataRule(requestClearing);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RequestClearing", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "RequestClearing", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(RequestClearing requestClearing) {
			try {
				return choice(MapperS.of(requestClearing), Arrays.asList("tradingEventsModel", "deClear"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RequestClearingChoice {
	
		@Override
		public ValidationResult<RequestClearing> validate(RosettaPath path, RequestClearing requestClearing) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RequestClearing", path, DEFINITION);
		}
	}
}
