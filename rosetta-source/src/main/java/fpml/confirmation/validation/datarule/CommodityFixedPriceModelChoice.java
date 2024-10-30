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
import fpml.confirmation.CommodityFixedPriceModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CommodityFixedPriceModelChoice")
@ImplementedBy(CommodityFixedPriceModelChoice.Default.class)
public interface CommodityFixedPriceModelChoice extends Validator<CommodityFixedPriceModel> {
	
	String NAME = "CommodityFixedPriceModelChoice";
	String DEFINITION = "required choice fixedPriceSchedule, commodityFixedPriceModelChoice";
	
	ValidationResult<CommodityFixedPriceModel> validate(RosettaPath path, CommodityFixedPriceModel commodityFixedPriceModel);
	
	class Default implements CommodityFixedPriceModelChoice {
	
		@Override
		public ValidationResult<CommodityFixedPriceModel> validate(RosettaPath path, CommodityFixedPriceModel commodityFixedPriceModel) {
			ComparisonResult result = executeDataRule(commodityFixedPriceModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityFixedPriceModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityFixedPriceModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityFixedPriceModel commodityFixedPriceModel) {
			try {
				return choice(MapperS.of(commodityFixedPriceModel), Arrays.asList("fixedPriceSchedule", "commodityFixedPriceModelChoice"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityFixedPriceModelChoice {
	
		@Override
		public ValidationResult<CommodityFixedPriceModel> validate(RosettaPath path, CommodityFixedPriceModel commodityFixedPriceModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityFixedPriceModel", path, DEFINITION);
		}
	}
}
