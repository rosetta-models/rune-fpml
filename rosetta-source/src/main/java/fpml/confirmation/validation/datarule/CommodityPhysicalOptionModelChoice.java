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
import fpml.confirmation.CommodityPhysicalOptionModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CommodityPhysicalOptionModelChoice")
@ImplementedBy(CommodityPhysicalOptionModelChoice.Default.class)
public interface CommodityPhysicalOptionModelChoice extends Validator<CommodityPhysicalOptionModel> {
	
	String NAME = "CommodityPhysicalOptionModelChoice";
	String DEFINITION = "required choice commoditySwap, commodityForward";
	
	ValidationResult<CommodityPhysicalOptionModel> validate(RosettaPath path, CommodityPhysicalOptionModel commodityPhysicalOptionModel);
	
	class Default implements CommodityPhysicalOptionModelChoice {
	
		@Override
		public ValidationResult<CommodityPhysicalOptionModel> validate(RosettaPath path, CommodityPhysicalOptionModel commodityPhysicalOptionModel) {
			ComparisonResult result = executeDataRule(commodityPhysicalOptionModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityPhysicalOptionModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityPhysicalOptionModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityPhysicalOptionModel commodityPhysicalOptionModel) {
			try {
				return choice(MapperS.of(commodityPhysicalOptionModel), Arrays.asList("commoditySwap", "commodityForward"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityPhysicalOptionModelChoice {
	
		@Override
		public ValidationResult<CommodityPhysicalOptionModel> validate(RosettaPath path, CommodityPhysicalOptionModel commodityPhysicalOptionModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityPhysicalOptionModel", path, DEFINITION);
		}
	}
}
