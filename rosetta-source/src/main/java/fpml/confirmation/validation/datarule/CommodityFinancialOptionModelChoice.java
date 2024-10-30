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
import fpml.confirmation.CommodityFinancialOptionModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CommodityFinancialOptionModelChoice")
@ImplementedBy(CommodityFinancialOptionModelChoice.Default.class)
public interface CommodityFinancialOptionModelChoice extends Validator<CommodityFinancialOptionModel> {
	
	String NAME = "CommodityFinancialOptionModelChoice";
	String DEFINITION = "required choice commodityStrikePriceModel, commodityFloatingStrikePriceModel";
	
	ValidationResult<CommodityFinancialOptionModel> validate(RosettaPath path, CommodityFinancialOptionModel commodityFinancialOptionModel);
	
	class Default implements CommodityFinancialOptionModelChoice {
	
		@Override
		public ValidationResult<CommodityFinancialOptionModel> validate(RosettaPath path, CommodityFinancialOptionModel commodityFinancialOptionModel) {
			ComparisonResult result = executeDataRule(commodityFinancialOptionModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityFinancialOptionModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityFinancialOptionModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityFinancialOptionModel commodityFinancialOptionModel) {
			try {
				return choice(MapperS.of(commodityFinancialOptionModel), Arrays.asList("commodityStrikePriceModel", "commodityFloatingStrikePriceModel"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityFinancialOptionModelChoice {
	
		@Override
		public ValidationResult<CommodityFinancialOptionModel> validate(RosettaPath path, CommodityFinancialOptionModel commodityFinancialOptionModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityFinancialOptionModel", path, DEFINITION);
		}
	}
}
