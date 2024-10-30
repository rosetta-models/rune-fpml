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
import fpml.confirmation.CommodityPaymentDatesModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CommodityPaymentDatesModelChoice")
@ImplementedBy(CommodityPaymentDatesModelChoice.Default.class)
public interface CommodityPaymentDatesModelChoice extends Validator<CommodityPaymentDatesModel> {
	
	String NAME = "CommodityPaymentDatesModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<CommodityPaymentDatesModel> validate(RosettaPath path, CommodityPaymentDatesModel commodityPaymentDatesModel);
	
	class Default implements CommodityPaymentDatesModelChoice {
	
		@Override
		public ValidationResult<CommodityPaymentDatesModel> validate(RosettaPath path, CommodityPaymentDatesModel commodityPaymentDatesModel) {
			ComparisonResult result = executeDataRule(commodityPaymentDatesModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityPaymentDatesModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityPaymentDatesModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityPaymentDatesModel commodityPaymentDatesModel) {
			try {
				return choice(MapperS.of(commodityPaymentDatesModel), Arrays.asList("relativePaymentDates", "commodityNonPeriodicPaymentDatesModel"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityPaymentDatesModelChoice {
	
		@Override
		public ValidationResult<CommodityPaymentDatesModel> validate(RosettaPath path, CommodityPaymentDatesModel commodityPaymentDatesModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityPaymentDatesModel", path, DEFINITION);
		}
	}
}
