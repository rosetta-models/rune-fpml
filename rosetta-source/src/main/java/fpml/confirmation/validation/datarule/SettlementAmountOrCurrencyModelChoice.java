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
import fpml.confirmation.SettlementAmountOrCurrencyModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("SettlementAmountOrCurrencyModelChoice")
@ImplementedBy(SettlementAmountOrCurrencyModelChoice.Default.class)
public interface SettlementAmountOrCurrencyModelChoice extends Validator<SettlementAmountOrCurrencyModel> {
	
	String NAME = "SettlementAmountOrCurrencyModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<SettlementAmountOrCurrencyModel> validate(RosettaPath path, SettlementAmountOrCurrencyModel settlementAmountOrCurrencyModel);
	
	class Default implements SettlementAmountOrCurrencyModelChoice {
	
		@Override
		public ValidationResult<SettlementAmountOrCurrencyModel> validate(RosettaPath path, SettlementAmountOrCurrencyModel settlementAmountOrCurrencyModel) {
			ComparisonResult result = executeDataRule(settlementAmountOrCurrencyModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementAmountOrCurrencyModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "SettlementAmountOrCurrencyModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(SettlementAmountOrCurrencyModel settlementAmountOrCurrencyModel) {
			try {
				return choice(MapperS.of(settlementAmountOrCurrencyModel), Arrays.asList("settlementAmount", "settlementCurrency"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SettlementAmountOrCurrencyModelChoice {
	
		@Override
		public ValidationResult<SettlementAmountOrCurrencyModel> validate(RosettaPath path, SettlementAmountOrCurrencyModel settlementAmountOrCurrencyModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementAmountOrCurrencyModel", path, DEFINITION);
		}
	}
}
