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
import fpml.confirmation.CommodityRelativePaymentDates;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CommodityRelativePaymentDatesChoice")
@ImplementedBy(CommodityRelativePaymentDatesChoice.Default.class)
public interface CommodityRelativePaymentDatesChoice extends Validator<CommodityRelativePaymentDates> {
	
	String NAME = "CommodityRelativePaymentDatesChoice";
	String DEFINITION = "required choice payRelativeTo, payRelativeToEvent";
	
	ValidationResult<CommodityRelativePaymentDates> validate(RosettaPath path, CommodityRelativePaymentDates commodityRelativePaymentDates);
	
	class Default implements CommodityRelativePaymentDatesChoice {
	
		@Override
		public ValidationResult<CommodityRelativePaymentDates> validate(RosettaPath path, CommodityRelativePaymentDates commodityRelativePaymentDates) {
			ComparisonResult result = executeDataRule(commodityRelativePaymentDates);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityRelativePaymentDates", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityRelativePaymentDates", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityRelativePaymentDates commodityRelativePaymentDates) {
			try {
				return choice(MapperS.of(commodityRelativePaymentDates), Arrays.asList("payRelativeTo", "payRelativeToEvent"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityRelativePaymentDatesChoice {
	
		@Override
		public ValidationResult<CommodityRelativePaymentDates> validate(RosettaPath path, CommodityRelativePaymentDates commodityRelativePaymentDates) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityRelativePaymentDates", path, DEFINITION);
		}
	}
}
