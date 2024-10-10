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
import fpml.confirmation.GasPhysicalQuantity;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("GasPhysicalQuantityChoice")
@ImplementedBy(GasPhysicalQuantityChoice.Default.class)
public interface GasPhysicalQuantityChoice extends Validator<GasPhysicalQuantity> {
	
	String NAME = "GasPhysicalQuantityChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<GasPhysicalQuantity> validate(RosettaPath path, GasPhysicalQuantity gasPhysicalQuantity);
	
	class Default implements GasPhysicalQuantityChoice {
	
		@Override
		public ValidationResult<GasPhysicalQuantity> validate(RosettaPath path, GasPhysicalQuantity gasPhysicalQuantity) {
			ComparisonResult result = executeDataRule(gasPhysicalQuantity);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "GasPhysicalQuantity", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "GasPhysicalQuantity", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(GasPhysicalQuantity gasPhysicalQuantity) {
			try {
				return choice(MapperS.of(gasPhysicalQuantity), Arrays.asList("id", "commodityFixedPhysicalQuantityModel", "gasPhysicalQuantitySequence"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements GasPhysicalQuantityChoice {
	
		@Override
		public ValidationResult<GasPhysicalQuantity> validate(RosettaPath path, GasPhysicalQuantity gasPhysicalQuantity) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "GasPhysicalQuantity", path, DEFINITION);
		}
	}
}
