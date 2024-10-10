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
import fpml.confirmation.CommodityValuationDatesSequence;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CommodityValuationDatesSequenceChoice")
@ImplementedBy(CommodityValuationDatesSequenceChoice.Default.class)
public interface CommodityValuationDatesSequenceChoice extends Validator<CommodityValuationDatesSequence> {
	
	String NAME = "CommodityValuationDatesSequenceChoice";
	String DEFINITION = "required choice commodityValuationDatesSequenceSequence, settlementPeriods , settlementPeriodsReference";
	
	ValidationResult<CommodityValuationDatesSequence> validate(RosettaPath path, CommodityValuationDatesSequence commodityValuationDatesSequence);
	
	class Default implements CommodityValuationDatesSequenceChoice {
	
		@Override
		public ValidationResult<CommodityValuationDatesSequence> validate(RosettaPath path, CommodityValuationDatesSequence commodityValuationDatesSequence) {
			ComparisonResult result = executeDataRule(commodityValuationDatesSequence);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityValuationDatesSequence", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityValuationDatesSequence", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityValuationDatesSequence commodityValuationDatesSequence) {
			try {
				return choice(MapperS.of(commodityValuationDatesSequence), Arrays.asList("commodityValuationDatesSequenceSequence", "settlementPeriods", "settlementPeriodsReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityValuationDatesSequenceChoice {
	
		@Override
		public ValidationResult<CommodityValuationDatesSequence> validate(RosettaPath path, CommodityValuationDatesSequence commodityValuationDatesSequence) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityValuationDatesSequence", path, DEFINITION);
		}
	}
}
