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
import fpml.confirmation.CommodityNonPeriodicPaymentDatesModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CommodityNonPeriodicPaymentDatesModelChoice")
@ImplementedBy(CommodityNonPeriodicPaymentDatesModelChoice.Default.class)
public interface CommodityNonPeriodicPaymentDatesModelChoice extends Validator<CommodityNonPeriodicPaymentDatesModel> {
	
	String NAME = "CommodityNonPeriodicPaymentDatesModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<CommodityNonPeriodicPaymentDatesModel> validate(RosettaPath path, CommodityNonPeriodicPaymentDatesModel commodityNonPeriodicPaymentDatesModel);
	
	class Default implements CommodityNonPeriodicPaymentDatesModelChoice {
	
		@Override
		public ValidationResult<CommodityNonPeriodicPaymentDatesModel> validate(RosettaPath path, CommodityNonPeriodicPaymentDatesModel commodityNonPeriodicPaymentDatesModel) {
			ComparisonResult result = executeDataRule(commodityNonPeriodicPaymentDatesModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityNonPeriodicPaymentDatesModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityNonPeriodicPaymentDatesModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityNonPeriodicPaymentDatesModel commodityNonPeriodicPaymentDatesModel) {
			try {
				return choice(MapperS.of(commodityNonPeriodicPaymentDatesModel), Arrays.asList("paymentDates", "masterAgreementPaymentDates"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityNonPeriodicPaymentDatesModelChoice {
	
		@Override
		public ValidationResult<CommodityNonPeriodicPaymentDatesModel> validate(RosettaPath path, CommodityNonPeriodicPaymentDatesModel commodityNonPeriodicPaymentDatesModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityNonPeriodicPaymentDatesModel", path, DEFINITION);
		}
	}
}
