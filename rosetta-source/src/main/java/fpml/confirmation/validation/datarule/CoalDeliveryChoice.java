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
import fpml.confirmation.CoalDelivery;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CoalDeliveryChoice")
@ImplementedBy(CoalDeliveryChoice.Default.class)
public interface CoalDeliveryChoice extends Validator<CoalDelivery> {
	
	String NAME = "CoalDeliveryChoice";
	String DEFINITION = "required choice deliveryPoint, deliveryAtSource";
	
	ValidationResult<CoalDelivery> validate(RosettaPath path, CoalDelivery coalDelivery);
	
	class Default implements CoalDeliveryChoice {
	
		@Override
		public ValidationResult<CoalDelivery> validate(RosettaPath path, CoalDelivery coalDelivery) {
			ComparisonResult result = executeDataRule(coalDelivery);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CoalDelivery", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CoalDelivery", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CoalDelivery coalDelivery) {
			try {
				return choice(MapperS.of(coalDelivery), Arrays.asList("deliveryPoint", "deliveryAtSource"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CoalDeliveryChoice {
	
		@Override
		public ValidationResult<CoalDelivery> validate(RosettaPath path, CoalDelivery coalDelivery) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CoalDelivery", path, DEFINITION);
		}
	}
}
