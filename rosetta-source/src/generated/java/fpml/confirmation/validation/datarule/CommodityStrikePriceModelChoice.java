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
import fpml.confirmation.CommodityStrikePriceModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CommodityStrikePriceModelChoice")
@ImplementedBy(CommodityStrikePriceModelChoice.Default.class)
public interface CommodityStrikePriceModelChoice extends Validator<CommodityStrikePriceModel> {
	
	String NAME = "CommodityStrikePriceModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<CommodityStrikePriceModel> validate(RosettaPath path, CommodityStrikePriceModel commodityStrikePriceModel);
	
	class Default implements CommodityStrikePriceModelChoice {
	
		@Override
		public ValidationResult<CommodityStrikePriceModel> validate(RosettaPath path, CommodityStrikePriceModel commodityStrikePriceModel) {
			ComparisonResult result = executeDataRule(commodityStrikePriceModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityStrikePriceModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityStrikePriceModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityStrikePriceModel commodityStrikePriceModel) {
			try {
				return choice(MapperS.of(commodityStrikePriceModel), Arrays.asList("strikePricePerUnit", "strikePricePerUnitSchedule"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityStrikePriceModelChoice {
	
		@Override
		public ValidationResult<CommodityStrikePriceModel> validate(RosettaPath path, CommodityStrikePriceModel commodityStrikePriceModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityStrikePriceModel", path, DEFINITION);
		}
	}
}
