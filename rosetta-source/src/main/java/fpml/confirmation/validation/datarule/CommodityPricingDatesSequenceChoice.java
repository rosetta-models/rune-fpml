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
import fpml.confirmation.CommodityPricingDatesSequence;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CommodityPricingDatesSequenceChoice")
@ImplementedBy(CommodityPricingDatesSequenceChoice.Default.class)
public interface CommodityPricingDatesSequenceChoice extends Validator<CommodityPricingDatesSequence> {
	
	String NAME = "CommodityPricingDatesSequenceChoice";
	String DEFINITION = "required choice commodityPricingDatesSequenceSequence, settlementPeriods , settlementPeriodsReference";
	
	ValidationResult<CommodityPricingDatesSequence> validate(RosettaPath path, CommodityPricingDatesSequence commodityPricingDatesSequence);
	
	class Default implements CommodityPricingDatesSequenceChoice {
	
		@Override
		public ValidationResult<CommodityPricingDatesSequence> validate(RosettaPath path, CommodityPricingDatesSequence commodityPricingDatesSequence) {
			ComparisonResult result = executeDataRule(commodityPricingDatesSequence);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityPricingDatesSequence", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityPricingDatesSequence", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityPricingDatesSequence commodityPricingDatesSequence) {
			try {
				return choice(MapperS.of(commodityPricingDatesSequence), Arrays.asList("commodityPricingDatesSequenceSequence", "settlementPeriods", "settlementPeriodsReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityPricingDatesSequenceChoice {
	
		@Override
		public ValidationResult<CommodityPricingDatesSequence> validate(RosettaPath path, CommodityPricingDatesSequence commodityPricingDatesSequence) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityPricingDatesSequence", path, DEFINITION);
		}
	}
}
