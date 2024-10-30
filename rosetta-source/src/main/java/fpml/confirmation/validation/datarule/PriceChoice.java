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
import fpml.confirmation.Price;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("PriceChoice")
@ImplementedBy(PriceChoice.Default.class)
public interface PriceChoice extends Validator<Price> {
	
	String NAME = "PriceChoice";
	String DEFINITION = "required choice priceSequence, amountRelativeTo , equityPriceModel";
	
	ValidationResult<Price> validate(RosettaPath path, Price price);
	
	class Default implements PriceChoice {
	
		@Override
		public ValidationResult<Price> validate(RosettaPath path, Price price) {
			ComparisonResult result = executeDataRule(price);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Price", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "Price", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(Price price) {
			try {
				return choice(MapperS.of(price), Arrays.asList("priceSequence", "amountRelativeTo", "equityPriceModel"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PriceChoice {
	
		@Override
		public ValidationResult<Price> validate(RosettaPath path, Price price) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Price", path, DEFINITION);
		}
	}
}
