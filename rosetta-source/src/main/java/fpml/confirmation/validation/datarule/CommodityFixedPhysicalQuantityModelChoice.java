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
import fpml.confirmation.CommodityFixedPhysicalQuantityModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CommodityFixedPhysicalQuantityModelChoice")
@ImplementedBy(CommodityFixedPhysicalQuantityModelChoice.Default.class)
public interface CommodityFixedPhysicalQuantityModelChoice extends Validator<CommodityFixedPhysicalQuantityModel> {
	
	String NAME = "CommodityFixedPhysicalQuantityModelChoice";
	String DEFINITION = "required choice physicalQuantity, physicalQuantitySchedule";
	
	ValidationResult<CommodityFixedPhysicalQuantityModel> validate(RosettaPath path, CommodityFixedPhysicalQuantityModel commodityFixedPhysicalQuantityModel);
	
	class Default implements CommodityFixedPhysicalQuantityModelChoice {
	
		@Override
		public ValidationResult<CommodityFixedPhysicalQuantityModel> validate(RosettaPath path, CommodityFixedPhysicalQuantityModel commodityFixedPhysicalQuantityModel) {
			ComparisonResult result = executeDataRule(commodityFixedPhysicalQuantityModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityFixedPhysicalQuantityModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityFixedPhysicalQuantityModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityFixedPhysicalQuantityModel commodityFixedPhysicalQuantityModel) {
			try {
				return choice(MapperS.of(commodityFixedPhysicalQuantityModel), Arrays.asList("physicalQuantity", "physicalQuantitySchedule"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityFixedPhysicalQuantityModelChoice {
	
		@Override
		public ValidationResult<CommodityFixedPhysicalQuantityModel> validate(RosettaPath path, CommodityFixedPhysicalQuantityModel commodityFixedPhysicalQuantityModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityFixedPhysicalQuantityModel", path, DEFINITION);
		}
	}
}
