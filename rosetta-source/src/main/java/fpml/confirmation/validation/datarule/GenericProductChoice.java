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
import fpml.confirmation.GenericProduct;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("GenericProductChoice")
@ImplementedBy(GenericProductChoice.Default.class)
public interface GenericProductChoice extends Validator<GenericProduct> {
	
	String NAME = "GenericProductChoice";
	String DEFINITION = "optional choice buyerSellerModel, counterpartyReference";
	
	ValidationResult<GenericProduct> validate(RosettaPath path, GenericProduct genericProduct);
	
	class Default implements GenericProductChoice {
	
		@Override
		public ValidationResult<GenericProduct> validate(RosettaPath path, GenericProduct genericProduct) {
			ComparisonResult result = executeDataRule(genericProduct);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "GenericProduct", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "GenericProduct", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(GenericProduct genericProduct) {
			try {
				return choice(MapperS.of(genericProduct), Arrays.asList("buyerSellerModel", "counterpartyReference"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements GenericProductChoice {
	
		@Override
		public ValidationResult<GenericProduct> validate(RosettaPath path, GenericProduct genericProduct) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "GenericProduct", path, DEFINITION);
		}
	}
}
