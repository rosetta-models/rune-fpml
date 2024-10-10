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
import fpml.confirmation.CommodityFixedPriceModelChoice;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CommodityFixedPriceModelChoiceChoice")
@ImplementedBy(CommodityFixedPriceModelChoiceChoice.Default.class)
public interface CommodityFixedPriceModelChoiceChoice extends Validator<CommodityFixedPriceModelChoice> {
	
	String NAME = "CommodityFixedPriceModelChoiceChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<CommodityFixedPriceModelChoice> validate(RosettaPath path, CommodityFixedPriceModelChoice commodityFixedPriceModelChoice);
	
	class Default implements CommodityFixedPriceModelChoiceChoice {
	
		@Override
		public ValidationResult<CommodityFixedPriceModelChoice> validate(RosettaPath path, CommodityFixedPriceModelChoice commodityFixedPriceModelChoice) {
			ComparisonResult result = executeDataRule(commodityFixedPriceModelChoice);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityFixedPriceModelChoice", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityFixedPriceModelChoice", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityFixedPriceModelChoice commodityFixedPriceModelChoice) {
			try {
				return choice(MapperS.of(commodityFixedPriceModelChoice), Arrays.asList("fixedPrice", "worldscaleRate", "contractRate", "settlementPeriodsPrice"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityFixedPriceModelChoiceChoice {
	
		@Override
		public ValidationResult<CommodityFixedPriceModelChoice> validate(RosettaPath path, CommodityFixedPriceModelChoice commodityFixedPriceModelChoice) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityFixedPriceModelChoice", path, DEFINITION);
		}
	}
}
