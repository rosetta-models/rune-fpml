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
import fpml.confirmation.CommodityBasketOption;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CommodityBasketOptionChoice")
@ImplementedBy(CommodityBasketOptionChoice.Default.class)
public interface CommodityBasketOptionChoice extends Validator<CommodityBasketOption> {
	
	String NAME = "CommodityBasketOptionChoice";
	String DEFINITION = "required choice commodityStrikePriceModel, commodityFloatingStrikePriceModel";
	
	ValidationResult<CommodityBasketOption> validate(RosettaPath path, CommodityBasketOption commodityBasketOption);
	
	class Default implements CommodityBasketOptionChoice {
	
		@Override
		public ValidationResult<CommodityBasketOption> validate(RosettaPath path, CommodityBasketOption commodityBasketOption) {
			ComparisonResult result = executeDataRule(commodityBasketOption);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityBasketOption", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityBasketOption", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityBasketOption commodityBasketOption) {
			try {
				return choice(MapperS.of(commodityBasketOption), Arrays.asList("commodityStrikePriceModel", "commodityFloatingStrikePriceModel"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityBasketOptionChoice {
	
		@Override
		public ValidationResult<CommodityBasketOption> validate(RosettaPath path, CommodityBasketOption commodityBasketOption) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityBasketOption", path, DEFINITION);
		}
	}
}
