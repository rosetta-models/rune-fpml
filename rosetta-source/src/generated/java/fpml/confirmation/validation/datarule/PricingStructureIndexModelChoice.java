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
import fpml.confirmation.PricingStructureIndexModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("PricingStructureIndexModelChoice")
@ImplementedBy(PricingStructureIndexModelChoice.Default.class)
public interface PricingStructureIndexModelChoice extends Validator<PricingStructureIndexModel> {
	
	String NAME = "PricingStructureIndexModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<PricingStructureIndexModel> validate(RosettaPath path, PricingStructureIndexModel pricingStructureIndexModel);
	
	class Default implements PricingStructureIndexModelChoice {
	
		@Override
		public ValidationResult<PricingStructureIndexModel> validate(RosettaPath path, PricingStructureIndexModel pricingStructureIndexModel) {
			ComparisonResult result = executeDataRule(pricingStructureIndexModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PricingStructureIndexModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "PricingStructureIndexModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(PricingStructureIndexModel pricingStructureIndexModel) {
			try {
				return choice(MapperS.of(pricingStructureIndexModel), Arrays.asList("term", "expiration", "strike", "generic"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PricingStructureIndexModelChoice {
	
		@Override
		public ValidationResult<PricingStructureIndexModel> validate(RosettaPath path, PricingStructureIndexModel pricingStructureIndexModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PricingStructureIndexModel", path, DEFINITION);
		}
	}
}
