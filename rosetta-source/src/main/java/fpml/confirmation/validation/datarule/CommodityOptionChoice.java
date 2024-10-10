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
import fpml.confirmation.CommodityOption;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CommodityOptionChoice")
@ImplementedBy(CommodityOptionChoice.Default.class)
public interface CommodityOptionChoice extends Validator<CommodityOption> {
	
	String NAME = "CommodityOptionChoice";
	String DEFINITION = "required choice commodityFinancialOptionModel, commodityPhysicalOptionModel , commodityWeatherOptionModel";
	
	ValidationResult<CommodityOption> validate(RosettaPath path, CommodityOption commodityOption);
	
	class Default implements CommodityOptionChoice {
	
		@Override
		public ValidationResult<CommodityOption> validate(RosettaPath path, CommodityOption commodityOption) {
			ComparisonResult result = executeDataRule(commodityOption);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityOption", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityOption", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityOption commodityOption) {
			try {
				return choice(MapperS.of(commodityOption), Arrays.asList("commodityFinancialOptionModel", "commodityPhysicalOptionModel", "commodityWeatherOptionModel"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityOptionChoice {
	
		@Override
		public ValidationResult<CommodityOption> validate(RosettaPath path, CommodityOption commodityOption) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityOption", path, DEFINITION);
		}
	}
}
