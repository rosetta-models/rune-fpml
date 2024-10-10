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
import fpml.confirmation.CommodityNotionalQuantitySchedule;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CommodityNotionalQuantityScheduleChoice")
@ImplementedBy(CommodityNotionalQuantityScheduleChoice.Default.class)
public interface CommodityNotionalQuantityScheduleChoice extends Validator<CommodityNotionalQuantitySchedule> {
	
	String NAME = "CommodityNotionalQuantityScheduleChoice";
	String DEFINITION = "required choice notionalStep, settlementPeriodsNotionalQuantitySchedule";
	
	ValidationResult<CommodityNotionalQuantitySchedule> validate(RosettaPath path, CommodityNotionalQuantitySchedule commodityNotionalQuantitySchedule);
	
	class Default implements CommodityNotionalQuantityScheduleChoice {
	
		@Override
		public ValidationResult<CommodityNotionalQuantitySchedule> validate(RosettaPath path, CommodityNotionalQuantitySchedule commodityNotionalQuantitySchedule) {
			ComparisonResult result = executeDataRule(commodityNotionalQuantitySchedule);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityNotionalQuantitySchedule", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityNotionalQuantitySchedule", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityNotionalQuantitySchedule commodityNotionalQuantitySchedule) {
			try {
				return choice(MapperS.of(commodityNotionalQuantitySchedule), Arrays.asList("notionalStep", "settlementPeriodsNotionalQuantitySchedule"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityNotionalQuantityScheduleChoice {
	
		@Override
		public ValidationResult<CommodityNotionalQuantitySchedule> validate(RosettaPath path, CommodityNotionalQuantitySchedule commodityNotionalQuantitySchedule) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityNotionalQuantitySchedule", path, DEFINITION);
		}
	}
}
