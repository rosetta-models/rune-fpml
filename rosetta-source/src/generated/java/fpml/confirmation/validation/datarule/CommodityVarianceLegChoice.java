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
import fpml.confirmation.CommodityVarianceLeg;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CommodityVarianceLegChoice")
@ImplementedBy(CommodityVarianceLegChoice.Default.class)
public interface CommodityVarianceLegChoice extends Validator<CommodityVarianceLeg> {
	
	String NAME = "CommodityVarianceLegChoice";
	String DEFINITION = "required choice varianceStrikePrice, volatilityStrikePrice";
	
	ValidationResult<CommodityVarianceLeg> validate(RosettaPath path, CommodityVarianceLeg commodityVarianceLeg);
	
	class Default implements CommodityVarianceLegChoice {
	
		@Override
		public ValidationResult<CommodityVarianceLeg> validate(RosettaPath path, CommodityVarianceLeg commodityVarianceLeg) {
			ComparisonResult result = executeDataRule(commodityVarianceLeg);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityVarianceLeg", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityVarianceLeg", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityVarianceLeg commodityVarianceLeg) {
			try {
				return choice(MapperS.of(commodityVarianceLeg), Arrays.asList("varianceStrikePrice", "volatilityStrikePrice"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityVarianceLegChoice {
	
		@Override
		public ValidationResult<CommodityVarianceLeg> validate(RosettaPath path, CommodityVarianceLeg commodityVarianceLeg) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityVarianceLeg", path, DEFINITION);
		}
	}
}
