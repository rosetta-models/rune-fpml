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
import fpml.confirmation.FeaturePayment;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("FeaturePaymentChoice")
@ImplementedBy(FeaturePaymentChoice.Default.class)
public interface FeaturePaymentChoice extends Validator<FeaturePayment> {
	
	String NAME = "FeaturePaymentChoice";
	String DEFINITION = "required choice levelPercentage, amount";
	
	ValidationResult<FeaturePayment> validate(RosettaPath path, FeaturePayment featurePayment);
	
	class Default implements FeaturePaymentChoice {
	
		@Override
		public ValidationResult<FeaturePayment> validate(RosettaPath path, FeaturePayment featurePayment) {
			ComparisonResult result = executeDataRule(featurePayment);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FeaturePayment", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FeaturePayment", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FeaturePayment featurePayment) {
			try {
				return choice(MapperS.of(featurePayment), Arrays.asList("levelPercentage", "amount"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FeaturePaymentChoice {
	
		@Override
		public ValidationResult<FeaturePayment> validate(RosettaPath path, FeaturePayment featurePayment) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FeaturePayment", path, DEFINITION);
		}
	}
}
