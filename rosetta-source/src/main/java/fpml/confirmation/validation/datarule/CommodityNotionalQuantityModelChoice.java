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
import fpml.confirmation.CommodityNotionalQuantityModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CommodityNotionalQuantityModelChoice")
@ImplementedBy(CommodityNotionalQuantityModelChoice.Default.class)
public interface CommodityNotionalQuantityModelChoice extends Validator<CommodityNotionalQuantityModel> {
	
	String NAME = "CommodityNotionalQuantityModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<CommodityNotionalQuantityModel> validate(RosettaPath path, CommodityNotionalQuantityModel commodityNotionalQuantityModel);
	
	class Default implements CommodityNotionalQuantityModelChoice {
	
		@Override
		public ValidationResult<CommodityNotionalQuantityModel> validate(RosettaPath path, CommodityNotionalQuantityModel commodityNotionalQuantityModel) {
			ComparisonResult result = executeDataRule(commodityNotionalQuantityModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityNotionalQuantityModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityNotionalQuantityModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityNotionalQuantityModel commodityNotionalQuantityModel) {
			try {
				return choice(MapperS.of(commodityNotionalQuantityModel), Arrays.asList("commodityNotionalQuantityModelSequence", "quantityReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityNotionalQuantityModelChoice {
	
		@Override
		public ValidationResult<CommodityNotionalQuantityModel> validate(RosettaPath path, CommodityNotionalQuantityModel commodityNotionalQuantityModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityNotionalQuantityModel", path, DEFINITION);
		}
	}
}
