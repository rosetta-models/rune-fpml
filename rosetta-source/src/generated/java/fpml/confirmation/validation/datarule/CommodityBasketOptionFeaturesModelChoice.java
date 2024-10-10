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
import fpml.confirmation.CommodityBasketOptionFeaturesModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CommodityBasketOptionFeaturesModelChoice")
@ImplementedBy(CommodityBasketOptionFeaturesModelChoice.Default.class)
public interface CommodityBasketOptionFeaturesModelChoice extends Validator<CommodityBasketOptionFeaturesModel> {
	
	String NAME = "CommodityBasketOptionFeaturesModelChoice";
	String DEFINITION = "required choice calculationPeriodsSchedule, calculationPeriods";
	
	ValidationResult<CommodityBasketOptionFeaturesModel> validate(RosettaPath path, CommodityBasketOptionFeaturesModel commodityBasketOptionFeaturesModel);
	
	class Default implements CommodityBasketOptionFeaturesModelChoice {
	
		@Override
		public ValidationResult<CommodityBasketOptionFeaturesModel> validate(RosettaPath path, CommodityBasketOptionFeaturesModel commodityBasketOptionFeaturesModel) {
			ComparisonResult result = executeDataRule(commodityBasketOptionFeaturesModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityBasketOptionFeaturesModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityBasketOptionFeaturesModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityBasketOptionFeaturesModel commodityBasketOptionFeaturesModel) {
			try {
				return choice(MapperS.of(commodityBasketOptionFeaturesModel), Arrays.asList("calculationPeriodsSchedule", "calculationPeriods"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityBasketOptionFeaturesModelChoice {
	
		@Override
		public ValidationResult<CommodityBasketOptionFeaturesModel> validate(RosettaPath path, CommodityBasketOptionFeaturesModel commodityBasketOptionFeaturesModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityBasketOptionFeaturesModel", path, DEFINITION);
		}
	}
}
