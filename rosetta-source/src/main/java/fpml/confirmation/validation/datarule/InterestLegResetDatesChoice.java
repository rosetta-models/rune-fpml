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
import fpml.confirmation.InterestLegResetDates;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("InterestLegResetDatesChoice")
@ImplementedBy(InterestLegResetDatesChoice.Default.class)
public interface InterestLegResetDatesChoice extends Validator<InterestLegResetDates> {
	
	String NAME = "InterestLegResetDatesChoice";
	String DEFINITION = "required choice resetRelativeTo, resetFrequency";
	
	ValidationResult<InterestLegResetDates> validate(RosettaPath path, InterestLegResetDates interestLegResetDates);
	
	class Default implements InterestLegResetDatesChoice {
	
		@Override
		public ValidationResult<InterestLegResetDates> validate(RosettaPath path, InterestLegResetDates interestLegResetDates) {
			ComparisonResult result = executeDataRule(interestLegResetDates);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "InterestLegResetDates", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "InterestLegResetDates", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(InterestLegResetDates interestLegResetDates) {
			try {
				return choice(MapperS.of(interestLegResetDates), Arrays.asList("resetRelativeTo", "resetFrequency"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements InterestLegResetDatesChoice {
	
		@Override
		public ValidationResult<InterestLegResetDates> validate(RosettaPath path, InterestLegResetDates interestLegResetDates) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "InterestLegResetDates", path, DEFINITION);
		}
	}
}
