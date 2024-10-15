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
import fpml.confirmation.CashSettlement;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CashSettlementChoice")
@ImplementedBy(CashSettlementChoice.Default.class)
public interface CashSettlementChoice extends Validator<CashSettlement> {
	
	String NAME = "CashSettlementChoice";
	String DEFINITION = "optional choice cashPriceMethod, cashPriceAlternateMethod , parYieldCurveAdjustedMethod , zeroCouponYieldAdjustedMethod , parYieldCurveUnadjustedMethod , crossCurrencyMethod , collateralizedCashPriceMethod";
	
	ValidationResult<CashSettlement> validate(RosettaPath path, CashSettlement cashSettlement);
	
	class Default implements CashSettlementChoice {
	
		@Override
		public ValidationResult<CashSettlement> validate(RosettaPath path, CashSettlement cashSettlement) {
			ComparisonResult result = executeDataRule(cashSettlement);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CashSettlement", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CashSettlement", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CashSettlement cashSettlement) {
			try {
				return choice(MapperS.of(cashSettlement), Arrays.asList("cashPriceMethod", "cashPriceAlternateMethod", "parYieldCurveAdjustedMethod", "zeroCouponYieldAdjustedMethod", "parYieldCurveUnadjustedMethod", "crossCurrencyMethod", "collateralizedCashPriceMethod"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CashSettlementChoice {
	
		@Override
		public ValidationResult<CashSettlement> validate(RosettaPath path, CashSettlement cashSettlement) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CashSettlement", path, DEFINITION);
		}
	}
}
