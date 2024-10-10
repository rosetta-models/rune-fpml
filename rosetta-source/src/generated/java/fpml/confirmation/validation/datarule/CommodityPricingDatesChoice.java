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
import fpml.confirmation.CommodityPricingDates;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CommodityPricingDatesChoice")
@ImplementedBy(CommodityPricingDatesChoice.Default.class)
public interface CommodityPricingDatesChoice extends Validator<CommodityPricingDates> {
	
	String NAME = "CommodityPricingDatesChoice";
	String DEFINITION = "required choice commodityPricingDatesSequence, pricingDates";
	
	ValidationResult<CommodityPricingDates> validate(RosettaPath path, CommodityPricingDates commodityPricingDates);
	
	class Default implements CommodityPricingDatesChoice {
	
		@Override
		public ValidationResult<CommodityPricingDates> validate(RosettaPath path, CommodityPricingDates commodityPricingDates) {
			ComparisonResult result = executeDataRule(commodityPricingDates);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityPricingDates", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityPricingDates", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityPricingDates commodityPricingDates) {
			try {
				return choice(MapperS.of(commodityPricingDates), Arrays.asList("commodityPricingDatesSequence", "pricingDates"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityPricingDatesChoice {
	
		@Override
		public ValidationResult<CommodityPricingDates> validate(RosettaPath path, CommodityPricingDates commodityPricingDates) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityPricingDates", path, DEFINITION);
		}
	}
}
