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
import fpml.confirmation.CommodityProductModelSequenceChoice;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CommodityProductModelSequenceChoiceChoice")
@ImplementedBy(CommodityProductModelSequenceChoiceChoice.Default.class)
public interface CommodityProductModelSequenceChoiceChoice extends Validator<CommodityProductModelSequenceChoice> {
	
	String NAME = "CommodityProductModelSequenceChoiceChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<CommodityProductModelSequenceChoice> validate(RosettaPath path, CommodityProductModelSequenceChoice commodityProductModelSequenceChoice);
	
	class Default implements CommodityProductModelSequenceChoiceChoice {
	
		@Override
		public ValidationResult<CommodityProductModelSequenceChoice> validate(RosettaPath path, CommodityProductModelSequenceChoice commodityProductModelSequenceChoice) {
			ComparisonResult result = executeDataRule(commodityProductModelSequenceChoice);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityProductModelSequenceChoice", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityProductModelSequenceChoice", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityProductModelSequenceChoice commodityProductModelSequenceChoice) {
			try {
				return choice(MapperS.of(commodityProductModelSequenceChoice), Arrays.asList("deliveryDates", "deliveryNearby"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityProductModelSequenceChoiceChoice {
	
		@Override
		public ValidationResult<CommodityProductModelSequenceChoice> validate(RosettaPath path, CommodityProductModelSequenceChoice commodityProductModelSequenceChoice) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityProductModelSequenceChoice", path, DEFINITION);
		}
	}
}
