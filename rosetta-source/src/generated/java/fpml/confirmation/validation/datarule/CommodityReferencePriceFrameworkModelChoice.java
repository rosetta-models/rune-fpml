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
import fpml.confirmation.CommodityReferencePriceFrameworkModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CommodityReferencePriceFrameworkModelChoice")
@ImplementedBy(CommodityReferencePriceFrameworkModelChoice.Default.class)
public interface CommodityReferencePriceFrameworkModelChoice extends Validator<CommodityReferencePriceFrameworkModel> {
	
	String NAME = "CommodityReferencePriceFrameworkModelChoice";
	String DEFINITION = "required choice exchangeId, publication";
	
	ValidationResult<CommodityReferencePriceFrameworkModel> validate(RosettaPath path, CommodityReferencePriceFrameworkModel commodityReferencePriceFrameworkModel);
	
	class Default implements CommodityReferencePriceFrameworkModelChoice {
	
		@Override
		public ValidationResult<CommodityReferencePriceFrameworkModel> validate(RosettaPath path, CommodityReferencePriceFrameworkModel commodityReferencePriceFrameworkModel) {
			ComparisonResult result = executeDataRule(commodityReferencePriceFrameworkModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityReferencePriceFrameworkModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityReferencePriceFrameworkModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityReferencePriceFrameworkModel commodityReferencePriceFrameworkModel) {
			try {
				return choice(MapperS.of(commodityReferencePriceFrameworkModel), Arrays.asList("exchangeId", "publication"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityReferencePriceFrameworkModelChoice {
	
		@Override
		public ValidationResult<CommodityReferencePriceFrameworkModel> validate(RosettaPath path, CommodityReferencePriceFrameworkModel commodityReferencePriceFrameworkModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityReferencePriceFrameworkModel", path, DEFINITION);
		}
	}
}
