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
import fpml.confirmation.CommodityNotionalQuantityModelSequence;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CommodityNotionalQuantityModelSequenceChoice")
@ImplementedBy(CommodityNotionalQuantityModelSequenceChoice.Default.class)
public interface CommodityNotionalQuantityModelSequenceChoice extends Validator<CommodityNotionalQuantityModelSequence> {
	
	String NAME = "CommodityNotionalQuantityModelSequenceChoice";
	String DEFINITION = "required choice notionalQuantitySchedule, notionalQuantity , settlementPeriodsNotionalQuantity";
	
	ValidationResult<CommodityNotionalQuantityModelSequence> validate(RosettaPath path, CommodityNotionalQuantityModelSequence commodityNotionalQuantityModelSequence);
	
	class Default implements CommodityNotionalQuantityModelSequenceChoice {
	
		@Override
		public ValidationResult<CommodityNotionalQuantityModelSequence> validate(RosettaPath path, CommodityNotionalQuantityModelSequence commodityNotionalQuantityModelSequence) {
			ComparisonResult result = executeDataRule(commodityNotionalQuantityModelSequence);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityNotionalQuantityModelSequence", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityNotionalQuantityModelSequence", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityNotionalQuantityModelSequence commodityNotionalQuantityModelSequence) {
			try {
				return choice(MapperS.of(commodityNotionalQuantityModelSequence), Arrays.asList("notionalQuantitySchedule", "notionalQuantity", "settlementPeriodsNotionalQuantity"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityNotionalQuantityModelSequenceChoice {
	
		@Override
		public ValidationResult<CommodityNotionalQuantityModelSequence> validate(RosettaPath path, CommodityNotionalQuantityModelSequence commodityNotionalQuantityModelSequence) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityNotionalQuantityModelSequence", path, DEFINITION);
		}
	}
}
