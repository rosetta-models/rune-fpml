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
import fpml.confirmation.DerivativeCalculationParametersModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("DerivativeCalculationParametersModelChoice")
@ImplementedBy(DerivativeCalculationParametersModelChoice.Default.class)
public interface DerivativeCalculationParametersModelChoice extends Validator<DerivativeCalculationParametersModel> {
	
	String NAME = "DerivativeCalculationParametersModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<DerivativeCalculationParametersModel> validate(RosettaPath path, DerivativeCalculationParametersModel derivativeCalculationParametersModel);
	
	class Default implements DerivativeCalculationParametersModelChoice {
	
		@Override
		public ValidationResult<DerivativeCalculationParametersModel> validate(RosettaPath path, DerivativeCalculationParametersModel derivativeCalculationParametersModel) {
			ComparisonResult result = executeDataRule(derivativeCalculationParametersModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DerivativeCalculationParametersModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "DerivativeCalculationParametersModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(DerivativeCalculationParametersModel derivativeCalculationParametersModel) {
			try {
				return choice(MapperS.of(derivativeCalculationParametersModel), Arrays.asList("finiteDifferenceDerivativeParametersModel", "analyticDerivativeParametersModel", "substitutionDerivativeParametersModel"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements DerivativeCalculationParametersModelChoice {
	
		@Override
		public ValidationResult<DerivativeCalculationParametersModel> validate(RosettaPath path, DerivativeCalculationParametersModel derivativeCalculationParametersModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DerivativeCalculationParametersModel", path, DEFINITION);
		}
	}
}
