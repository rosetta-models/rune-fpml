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
import fpml.confirmation.PricingParameterDerivative;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("PricingParameterDerivativeChoice")
@ImplementedBy(PricingParameterDerivativeChoice.Default.class)
public interface PricingParameterDerivativeChoice extends Validator<PricingParameterDerivative> {
	
	String NAME = "PricingParameterDerivativeChoice";
	String DEFINITION = "required choice parameterReference, inputDateReference";
	
	ValidationResult<PricingParameterDerivative> validate(RosettaPath path, PricingParameterDerivative pricingParameterDerivative);
	
	class Default implements PricingParameterDerivativeChoice {
	
		@Override
		public ValidationResult<PricingParameterDerivative> validate(RosettaPath path, PricingParameterDerivative pricingParameterDerivative) {
			ComparisonResult result = executeDataRule(pricingParameterDerivative);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PricingParameterDerivative", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "PricingParameterDerivative", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(PricingParameterDerivative pricingParameterDerivative) {
			try {
				return choice(MapperS.of(pricingParameterDerivative), Arrays.asList("parameterReference", "inputDateReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PricingParameterDerivativeChoice {
	
		@Override
		public ValidationResult<PricingParameterDerivative> validate(RosettaPath path, PricingParameterDerivative pricingParameterDerivative) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PricingParameterDerivative", path, DEFINITION);
		}
	}
}
