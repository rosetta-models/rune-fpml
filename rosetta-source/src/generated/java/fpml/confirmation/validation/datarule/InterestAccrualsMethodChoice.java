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
import fpml.confirmation.InterestAccrualsMethod;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("InterestAccrualsMethodChoice")
@ImplementedBy(InterestAccrualsMethodChoice.Default.class)
public interface InterestAccrualsMethodChoice extends Validator<InterestAccrualsMethod> {
	
	String NAME = "InterestAccrualsMethodChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<InterestAccrualsMethod> validate(RosettaPath path, InterestAccrualsMethod interestAccrualsMethod);
	
	class Default implements InterestAccrualsMethodChoice {
	
		@Override
		public ValidationResult<InterestAccrualsMethod> validate(RosettaPath path, InterestAccrualsMethod interestAccrualsMethod) {
			ComparisonResult result = executeDataRule(interestAccrualsMethod);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "InterestAccrualsMethod", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "InterestAccrualsMethod", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(InterestAccrualsMethod interestAccrualsMethod) {
			try {
				return choice(MapperS.of(interestAccrualsMethod), Arrays.asList("floatingRateCalculation", "fixedRate"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements InterestAccrualsMethodChoice {
	
		@Override
		public ValidationResult<InterestAccrualsMethod> validate(RosettaPath path, InterestAccrualsMethod interestAccrualsMethod) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "InterestAccrualsMethod", path, DEFINITION);
		}
	}
}
