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
import fpml.confirmation.CommodityCalculationPeriodsModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CommodityCalculationPeriodsModelChoice")
@ImplementedBy(CommodityCalculationPeriodsModelChoice.Default.class)
public interface CommodityCalculationPeriodsModelChoice extends Validator<CommodityCalculationPeriodsModel> {
	
	String NAME = "CommodityCalculationPeriodsModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<CommodityCalculationPeriodsModel> validate(RosettaPath path, CommodityCalculationPeriodsModel commodityCalculationPeriodsModel);
	
	class Default implements CommodityCalculationPeriodsModelChoice {
	
		@Override
		public ValidationResult<CommodityCalculationPeriodsModel> validate(RosettaPath path, CommodityCalculationPeriodsModel commodityCalculationPeriodsModel) {
			ComparisonResult result = executeDataRule(commodityCalculationPeriodsModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityCalculationPeriodsModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityCalculationPeriodsModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityCalculationPeriodsModel commodityCalculationPeriodsModel) {
			try {
				return choice(MapperS.of(commodityCalculationPeriodsModel), Arrays.asList("calculationDates", "calculationPeriods", "calculationPeriodsSchedule", "commodityCalculationPeriodsPointerModel"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityCalculationPeriodsModelChoice {
	
		@Override
		public ValidationResult<CommodityCalculationPeriodsModel> validate(RosettaPath path, CommodityCalculationPeriodsModel commodityCalculationPeriodsModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityCalculationPeriodsModel", path, DEFINITION);
		}
	}
}
