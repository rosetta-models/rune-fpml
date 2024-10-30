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
import fpml.confirmation.CommodityProductModelSequence;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CommodityProductModelSequenceChoice")
@ImplementedBy(CommodityProductModelSequenceChoice.Default.class)
public interface CommodityProductModelSequenceChoice extends Validator<CommodityProductModelSequence> {
	
	String NAME = "CommodityProductModelSequenceChoice";
	String DEFINITION = "required choice commodityProductModelSequenceChoice, deliveryDate , deliveryDateYearMonth";
	
	ValidationResult<CommodityProductModelSequence> validate(RosettaPath path, CommodityProductModelSequence commodityProductModelSequence);
	
	class Default implements CommodityProductModelSequenceChoice {
	
		@Override
		public ValidationResult<CommodityProductModelSequence> validate(RosettaPath path, CommodityProductModelSequence commodityProductModelSequence) {
			ComparisonResult result = executeDataRule(commodityProductModelSequence);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityProductModelSequence", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityProductModelSequence", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityProductModelSequence commodityProductModelSequence) {
			try {
				return choice(MapperS.of(commodityProductModelSequence), Arrays.asList("commodityProductModelSequenceChoice", "deliveryDate", "deliveryDateYearMonth"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityProductModelSequenceChoice {
	
		@Override
		public ValidationResult<CommodityProductModelSequence> validate(RosettaPath path, CommodityProductModelSequence commodityProductModelSequence) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityProductModelSequence", path, DEFINITION);
		}
	}
}
