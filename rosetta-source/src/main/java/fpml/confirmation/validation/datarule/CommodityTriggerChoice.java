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
import fpml.confirmation.CommodityTrigger;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CommodityTriggerChoice")
@ImplementedBy(CommodityTriggerChoice.Default.class)
public interface CommodityTriggerChoice extends Validator<CommodityTrigger> {
	
	String NAME = "CommodityTriggerChoice";
	String DEFINITION = "required choice commodityTriggerSequence, levelPercentage , levelPrice";
	
	ValidationResult<CommodityTrigger> validate(RosettaPath path, CommodityTrigger commodityTrigger);
	
	class Default implements CommodityTriggerChoice {
	
		@Override
		public ValidationResult<CommodityTrigger> validate(RosettaPath path, CommodityTrigger commodityTrigger) {
			ComparisonResult result = executeDataRule(commodityTrigger);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityTrigger", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityTrigger", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityTrigger commodityTrigger) {
			try {
				return choice(MapperS.of(commodityTrigger), Arrays.asList("commodityTriggerSequence", "levelPercentage", "levelPrice"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityTriggerChoice {
	
		@Override
		public ValidationResult<CommodityTrigger> validate(RosettaPath path, CommodityTrigger commodityTrigger) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityTrigger", path, DEFINITION);
		}
	}
}
