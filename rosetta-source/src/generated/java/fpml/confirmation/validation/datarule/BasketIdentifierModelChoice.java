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
import fpml.confirmation.BasketIdentifierModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("BasketIdentifierModelChoice")
@ImplementedBy(BasketIdentifierModelChoice.Default.class)
public interface BasketIdentifierModelChoice extends Validator<BasketIdentifierModel> {
	
	String NAME = "BasketIdentifierModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<BasketIdentifierModel> validate(RosettaPath path, BasketIdentifierModel basketIdentifierModel);
	
	class Default implements BasketIdentifierModelChoice {
	
		@Override
		public ValidationResult<BasketIdentifierModel> validate(RosettaPath path, BasketIdentifierModel basketIdentifierModel) {
			ComparisonResult result = executeDataRule(basketIdentifierModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "BasketIdentifierModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "BasketIdentifierModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(BasketIdentifierModel basketIdentifierModel) {
			try {
				return choice(MapperS.of(basketIdentifierModel), Arrays.asList("basketIdentifierModelSequence", "basketId"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements BasketIdentifierModelChoice {
	
		@Override
		public ValidationResult<BasketIdentifierModel> validate(RosettaPath path, BasketIdentifierModel basketIdentifierModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "BasketIdentifierModel", path, DEFINITION);
		}
	}
}
