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
import fpml.confirmation.CoalProduct;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CoalProductChoice")
@ImplementedBy(CoalProductChoice.Default.class)
public interface CoalProductChoice extends Validator<CoalProduct> {
	
	String NAME = "CoalProductChoice";
	String DEFINITION = "required choice _type, coalProductSpecifications";
	
	ValidationResult<CoalProduct> validate(RosettaPath path, CoalProduct coalProduct);
	
	class Default implements CoalProductChoice {
	
		@Override
		public ValidationResult<CoalProduct> validate(RosettaPath path, CoalProduct coalProduct) {
			ComparisonResult result = executeDataRule(coalProduct);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CoalProduct", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CoalProduct", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CoalProduct coalProduct) {
			try {
				return choice(MapperS.of(coalProduct), Arrays.asList("_type", "coalProductSpecifications"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CoalProductChoice {
	
		@Override
		public ValidationResult<CoalProduct> validate(RosettaPath path, CoalProduct coalProduct) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CoalProduct", path, DEFINITION);
		}
	}
}
