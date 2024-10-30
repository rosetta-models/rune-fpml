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
import fpml.confirmation.CommodityUnderlyerChoiceModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CommodityUnderlyerChoiceModelChoice")
@ImplementedBy(CommodityUnderlyerChoiceModelChoice.Default.class)
public interface CommodityUnderlyerChoiceModelChoice extends Validator<CommodityUnderlyerChoiceModel> {
	
	String NAME = "CommodityUnderlyerChoiceModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<CommodityUnderlyerChoiceModel> validate(RosettaPath path, CommodityUnderlyerChoiceModel commodityUnderlyerChoiceModel);
	
	class Default implements CommodityUnderlyerChoiceModelChoice {
	
		@Override
		public ValidationResult<CommodityUnderlyerChoiceModel> validate(RosettaPath path, CommodityUnderlyerChoiceModel commodityUnderlyerChoiceModel) {
			ComparisonResult result = executeDataRule(commodityUnderlyerChoiceModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityUnderlyerChoiceModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityUnderlyerChoiceModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityUnderlyerChoiceModel commodityUnderlyerChoiceModel) {
			try {
				return choice(MapperS.of(commodityUnderlyerChoiceModel), Arrays.asList("commodity", "commodityBasket"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityUnderlyerChoiceModelChoice {
	
		@Override
		public ValidationResult<CommodityUnderlyerChoiceModel> validate(RosettaPath path, CommodityUnderlyerChoiceModel commodityUnderlyerChoiceModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityUnderlyerChoiceModel", path, DEFINITION);
		}
	}
}
