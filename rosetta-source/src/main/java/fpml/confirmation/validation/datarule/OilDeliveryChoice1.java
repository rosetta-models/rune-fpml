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
import fpml.confirmation.OilDelivery;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("OilDeliveryChoice1")
@ImplementedBy(OilDeliveryChoice1.Default.class)
public interface OilDeliveryChoice1 extends Validator<OilDelivery> {
	
	String NAME = "OilDeliveryChoice1";
	String DEFINITION = "optional choice absoluteTolerance, percentageTolerance";
	
	ValidationResult<OilDelivery> validate(RosettaPath path, OilDelivery oilDelivery);
	
	class Default implements OilDeliveryChoice1 {
	
		@Override
		public ValidationResult<OilDelivery> validate(RosettaPath path, OilDelivery oilDelivery) {
			ComparisonResult result = executeDataRule(oilDelivery);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OilDelivery", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "OilDelivery", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(OilDelivery oilDelivery) {
			try {
				return choice(MapperS.of(oilDelivery), Arrays.asList("absoluteTolerance", "percentageTolerance"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OilDeliveryChoice1 {
	
		@Override
		public ValidationResult<OilDelivery> validate(RosettaPath path, OilDelivery oilDelivery) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OilDelivery", path, DEFINITION);
		}
	}
}
