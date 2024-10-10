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
import fpml.confirmation.CommodityValuationDates;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CommodityValuationDatesChoice")
@ImplementedBy(CommodityValuationDatesChoice.Default.class)
public interface CommodityValuationDatesChoice extends Validator<CommodityValuationDates> {
	
	String NAME = "CommodityValuationDatesChoice";
	String DEFINITION = "required choice commodityValuationDatesSequence, valuationDates";
	
	ValidationResult<CommodityValuationDates> validate(RosettaPath path, CommodityValuationDates commodityValuationDates);
	
	class Default implements CommodityValuationDatesChoice {
	
		@Override
		public ValidationResult<CommodityValuationDates> validate(RosettaPath path, CommodityValuationDates commodityValuationDates) {
			ComparisonResult result = executeDataRule(commodityValuationDates);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityValuationDates", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityValuationDates", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityValuationDates commodityValuationDates) {
			try {
				return choice(MapperS.of(commodityValuationDates), Arrays.asList("commodityValuationDatesSequence", "valuationDates"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityValuationDatesChoice {
	
		@Override
		public ValidationResult<CommodityValuationDates> validate(RosettaPath path, CommodityValuationDates commodityValuationDates) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityValuationDates", path, DEFINITION);
		}
	}
}
