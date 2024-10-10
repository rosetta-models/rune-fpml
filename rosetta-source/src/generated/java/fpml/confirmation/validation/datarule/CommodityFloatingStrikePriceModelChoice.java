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
import fpml.confirmation.CommodityFloatingStrikePriceModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CommodityFloatingStrikePriceModelChoice")
@ImplementedBy(CommodityFloatingStrikePriceModelChoice.Default.class)
public interface CommodityFloatingStrikePriceModelChoice extends Validator<CommodityFloatingStrikePriceModel> {
	
	String NAME = "CommodityFloatingStrikePriceModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<CommodityFloatingStrikePriceModel> validate(RosettaPath path, CommodityFloatingStrikePriceModel commodityFloatingStrikePriceModel);
	
	class Default implements CommodityFloatingStrikePriceModelChoice {
	
		@Override
		public ValidationResult<CommodityFloatingStrikePriceModel> validate(RosettaPath path, CommodityFloatingStrikePriceModel commodityFloatingStrikePriceModel) {
			ComparisonResult result = executeDataRule(commodityFloatingStrikePriceModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityFloatingStrikePriceModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityFloatingStrikePriceModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityFloatingStrikePriceModel commodityFloatingStrikePriceModel) {
			try {
				return choice(MapperS.of(commodityFloatingStrikePriceModel), Arrays.asList("floatingStrikePricePerUnit", "floatingStrikePricePerUnitSchedule"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityFloatingStrikePriceModelChoice {
	
		@Override
		public ValidationResult<CommodityFloatingStrikePriceModel> validate(RosettaPath path, CommodityFloatingStrikePriceModel commodityFloatingStrikePriceModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityFloatingStrikePriceModel", path, DEFINITION);
		}
	}
}
