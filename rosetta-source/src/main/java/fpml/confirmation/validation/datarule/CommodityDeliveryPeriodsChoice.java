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
import fpml.confirmation.CommodityDeliveryPeriods;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CommodityDeliveryPeriodsChoice")
@ImplementedBy(CommodityDeliveryPeriodsChoice.Default.class)
public interface CommodityDeliveryPeriodsChoice extends Validator<CommodityDeliveryPeriods> {
	
	String NAME = "CommodityDeliveryPeriodsChoice";
	String DEFINITION = "required choice periods, periodsSchedule , commodityCalculationPeriodsPointerModel";
	
	ValidationResult<CommodityDeliveryPeriods> validate(RosettaPath path, CommodityDeliveryPeriods commodityDeliveryPeriods);
	
	class Default implements CommodityDeliveryPeriodsChoice {
	
		@Override
		public ValidationResult<CommodityDeliveryPeriods> validate(RosettaPath path, CommodityDeliveryPeriods commodityDeliveryPeriods) {
			ComparisonResult result = executeDataRule(commodityDeliveryPeriods);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityDeliveryPeriods", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityDeliveryPeriods", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityDeliveryPeriods commodityDeliveryPeriods) {
			try {
				return choice(MapperS.of(commodityDeliveryPeriods), Arrays.asList("periods", "periodsSchedule", "commodityCalculationPeriodsPointerModel"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityDeliveryPeriodsChoice {
	
		@Override
		public ValidationResult<CommodityDeliveryPeriods> validate(RosettaPath path, CommodityDeliveryPeriods commodityDeliveryPeriods) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityDeliveryPeriods", path, DEFINITION);
		}
	}
}
