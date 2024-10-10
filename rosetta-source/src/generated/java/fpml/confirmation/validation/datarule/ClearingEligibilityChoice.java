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
import fpml.confirmation.ClearingEligibility;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("ClearingEligibilityChoice")
@ImplementedBy(ClearingEligibilityChoice.Default.class)
public interface ClearingEligibilityChoice extends Validator<ClearingEligibility> {
	
	String NAME = "ClearingEligibilityChoice";
	String DEFINITION = "optional choice tradingEventsModel, deClear , partyTradeIdentifier";
	
	ValidationResult<ClearingEligibility> validate(RosettaPath path, ClearingEligibility clearingEligibility);
	
	class Default implements ClearingEligibilityChoice {
	
		@Override
		public ValidationResult<ClearingEligibility> validate(RosettaPath path, ClearingEligibility clearingEligibility) {
			ComparisonResult result = executeDataRule(clearingEligibility);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ClearingEligibility", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "ClearingEligibility", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(ClearingEligibility clearingEligibility) {
			try {
				return choice(MapperS.of(clearingEligibility), Arrays.asList("tradingEventsModel", "deClear", "partyTradeIdentifier"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ClearingEligibilityChoice {
	
		@Override
		public ValidationResult<ClearingEligibility> validate(RosettaPath path, ClearingEligibility clearingEligibility) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ClearingEligibility", path, DEFINITION);
		}
	}
}
