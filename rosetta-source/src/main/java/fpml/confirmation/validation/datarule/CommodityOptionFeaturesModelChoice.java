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
import fpml.confirmation.CommodityOptionFeaturesModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CommodityOptionFeaturesModelChoice")
@ImplementedBy(CommodityOptionFeaturesModelChoice.Default.class)
public interface CommodityOptionFeaturesModelChoice extends Validator<CommodityOptionFeaturesModel> {
	
	String NAME = "CommodityOptionFeaturesModelChoice";
	String DEFINITION = "optional choice commodityOptionFeaturesModelSequence, barrier";
	
	ValidationResult<CommodityOptionFeaturesModel> validate(RosettaPath path, CommodityOptionFeaturesModel commodityOptionFeaturesModel);
	
	class Default implements CommodityOptionFeaturesModelChoice {
	
		@Override
		public ValidationResult<CommodityOptionFeaturesModel> validate(RosettaPath path, CommodityOptionFeaturesModel commodityOptionFeaturesModel) {
			ComparisonResult result = executeDataRule(commodityOptionFeaturesModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityOptionFeaturesModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityOptionFeaturesModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityOptionFeaturesModel commodityOptionFeaturesModel) {
			try {
				return choice(MapperS.of(commodityOptionFeaturesModel), Arrays.asList("commodityOptionFeaturesModelSequence", "barrier"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityOptionFeaturesModelChoice {
	
		@Override
		public ValidationResult<CommodityOptionFeaturesModel> validate(RosettaPath path, CommodityOptionFeaturesModel commodityOptionFeaturesModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityOptionFeaturesModel", path, DEFINITION);
		}
	}
}
