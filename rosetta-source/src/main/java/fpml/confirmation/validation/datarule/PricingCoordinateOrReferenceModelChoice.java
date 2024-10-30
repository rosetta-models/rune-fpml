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
import fpml.confirmation.PricingCoordinateOrReferenceModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("PricingCoordinateOrReferenceModelChoice")
@ImplementedBy(PricingCoordinateOrReferenceModelChoice.Default.class)
public interface PricingCoordinateOrReferenceModelChoice extends Validator<PricingCoordinateOrReferenceModel> {
	
	String NAME = "PricingCoordinateOrReferenceModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<PricingCoordinateOrReferenceModel> validate(RosettaPath path, PricingCoordinateOrReferenceModel pricingCoordinateOrReferenceModel);
	
	class Default implements PricingCoordinateOrReferenceModelChoice {
	
		@Override
		public ValidationResult<PricingCoordinateOrReferenceModel> validate(RosettaPath path, PricingCoordinateOrReferenceModel pricingCoordinateOrReferenceModel) {
			ComparisonResult result = executeDataRule(pricingCoordinateOrReferenceModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PricingCoordinateOrReferenceModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "PricingCoordinateOrReferenceModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(PricingCoordinateOrReferenceModel pricingCoordinateOrReferenceModel) {
			try {
				return choice(MapperS.of(pricingCoordinateOrReferenceModel), Arrays.asList("coordinate", "coordinateReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PricingCoordinateOrReferenceModelChoice {
	
		@Override
		public ValidationResult<PricingCoordinateOrReferenceModel> validate(RosettaPath path, PricingCoordinateOrReferenceModel pricingCoordinateOrReferenceModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PricingCoordinateOrReferenceModel", path, DEFINITION);
		}
	}
}
