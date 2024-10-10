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
import fpml.confirmation.CommodityDeliveryPointsModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CommodityDeliveryPointsModelChoice")
@ImplementedBy(CommodityDeliveryPointsModelChoice.Default.class)
public interface CommodityDeliveryPointsModelChoice extends Validator<CommodityDeliveryPointsModel> {
	
	String NAME = "CommodityDeliveryPointsModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<CommodityDeliveryPointsModel> validate(RosettaPath path, CommodityDeliveryPointsModel commodityDeliveryPointsModel);
	
	class Default implements CommodityDeliveryPointsModelChoice {
	
		@Override
		public ValidationResult<CommodityDeliveryPointsModel> validate(RosettaPath path, CommodityDeliveryPointsModel commodityDeliveryPointsModel) {
			ComparisonResult result = executeDataRule(commodityDeliveryPointsModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityDeliveryPointsModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityDeliveryPointsModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityDeliveryPointsModel commodityDeliveryPointsModel) {
			try {
				return choice(MapperS.of(commodityDeliveryPointsModel), Arrays.asList("deliveryPoint", "commodityDeliveryPointsModelSequence"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityDeliveryPointsModelChoice {
	
		@Override
		public ValidationResult<CommodityDeliveryPointsModel> validate(RosettaPath path, CommodityDeliveryPointsModel commodityDeliveryPointsModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityDeliveryPointsModel", path, DEFINITION);
		}
	}
}
