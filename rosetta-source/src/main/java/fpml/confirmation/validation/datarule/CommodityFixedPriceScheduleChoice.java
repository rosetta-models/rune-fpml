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
import fpml.confirmation.CommodityFixedPriceSchedule;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CommodityFixedPriceScheduleChoice")
@ImplementedBy(CommodityFixedPriceScheduleChoice.Default.class)
public interface CommodityFixedPriceScheduleChoice extends Validator<CommodityFixedPriceSchedule> {
	
	String NAME = "CommodityFixedPriceScheduleChoice";
	String DEFINITION = "required choice fixedPriceStep, worldscaleRateStep , contractRateStep , settlementPeriodsPriceSchedule";
	
	ValidationResult<CommodityFixedPriceSchedule> validate(RosettaPath path, CommodityFixedPriceSchedule commodityFixedPriceSchedule);
	
	class Default implements CommodityFixedPriceScheduleChoice {
	
		@Override
		public ValidationResult<CommodityFixedPriceSchedule> validate(RosettaPath path, CommodityFixedPriceSchedule commodityFixedPriceSchedule) {
			ComparisonResult result = executeDataRule(commodityFixedPriceSchedule);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityFixedPriceSchedule", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityFixedPriceSchedule", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityFixedPriceSchedule commodityFixedPriceSchedule) {
			try {
				return choice(MapperS.of(commodityFixedPriceSchedule), Arrays.asList("fixedPriceStep", "worldscaleRateStep", "contractRateStep", "settlementPeriodsPriceSchedule"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityFixedPriceScheduleChoice {
	
		@Override
		public ValidationResult<CommodityFixedPriceSchedule> validate(RosettaPath path, CommodityFixedPriceSchedule commodityFixedPriceSchedule) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityFixedPriceSchedule", path, DEFINITION);
		}
	}
}
