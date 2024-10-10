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
import fpml.confirmation.CommodityDeliveryPeriodsPointerModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CommodityDeliveryPeriodsPointerModelChoice")
@ImplementedBy(CommodityDeliveryPeriodsPointerModelChoice.Default.class)
public interface CommodityDeliveryPeriodsPointerModelChoice extends Validator<CommodityDeliveryPeriodsPointerModel> {
	
	String NAME = "CommodityDeliveryPeriodsPointerModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<CommodityDeliveryPeriodsPointerModel> validate(RosettaPath path, CommodityDeliveryPeriodsPointerModel commodityDeliveryPeriodsPointerModel);
	
	class Default implements CommodityDeliveryPeriodsPointerModelChoice {
	
		@Override
		public ValidationResult<CommodityDeliveryPeriodsPointerModel> validate(RosettaPath path, CommodityDeliveryPeriodsPointerModel commodityDeliveryPeriodsPointerModel) {
			ComparisonResult result = executeDataRule(commodityDeliveryPeriodsPointerModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityDeliveryPeriodsPointerModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityDeliveryPeriodsPointerModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityDeliveryPeriodsPointerModel commodityDeliveryPeriodsPointerModel) {
			try {
				return choice(MapperS.of(commodityDeliveryPeriodsPointerModel), Arrays.asList("deliveryPeriodsReference", "deliveryPeriodsScheduleReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityDeliveryPeriodsPointerModelChoice {
	
		@Override
		public ValidationResult<CommodityDeliveryPeriodsPointerModel> validate(RosettaPath path, CommodityDeliveryPeriodsPointerModel commodityDeliveryPeriodsPointerModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityDeliveryPeriodsPointerModel", path, DEFINITION);
		}
	}
}
