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
import fpml.confirmation.CommodityCalculationPeriodsPointerModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CommodityCalculationPeriodsPointerModelChoice")
@ImplementedBy(CommodityCalculationPeriodsPointerModelChoice.Default.class)
public interface CommodityCalculationPeriodsPointerModelChoice extends Validator<CommodityCalculationPeriodsPointerModel> {
	
	String NAME = "CommodityCalculationPeriodsPointerModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<CommodityCalculationPeriodsPointerModel> validate(RosettaPath path, CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel);
	
	class Default implements CommodityCalculationPeriodsPointerModelChoice {
	
		@Override
		public ValidationResult<CommodityCalculationPeriodsPointerModel> validate(RosettaPath path, CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel) {
			ComparisonResult result = executeDataRule(commodityCalculationPeriodsPointerModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityCalculationPeriodsPointerModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityCalculationPeriodsPointerModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel) {
			try {
				return choice(MapperS.of(commodityCalculationPeriodsPointerModel), Arrays.asList("calculationPeriodsReference", "calculationPeriodsScheduleReference", "calculationPeriodsDatesReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityCalculationPeriodsPointerModelChoice {
	
		@Override
		public ValidationResult<CommodityCalculationPeriodsPointerModel> validate(RosettaPath path, CommodityCalculationPeriodsPointerModel commodityCalculationPeriodsPointerModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityCalculationPeriodsPointerModel", path, DEFINITION);
		}
	}
}
