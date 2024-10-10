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
import fpml.confirmation.SettlementPeriodLeverage;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("SettlementPeriodLeverageChoice")
@ImplementedBy(SettlementPeriodLeverageChoice.Default.class)
public interface SettlementPeriodLeverageChoice extends Validator<SettlementPeriodLeverage> {
	
	String NAME = "SettlementPeriodLeverageChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<SettlementPeriodLeverage> validate(RosettaPath path, SettlementPeriodLeverage settlementPeriodLeverage);
	
	class Default implements SettlementPeriodLeverageChoice {
	
		@Override
		public ValidationResult<SettlementPeriodLeverage> validate(RosettaPath path, SettlementPeriodLeverage settlementPeriodLeverage) {
			ComparisonResult result = executeDataRule(settlementPeriodLeverage);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementPeriodLeverage", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "SettlementPeriodLeverage", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(SettlementPeriodLeverage settlementPeriodLeverage) {
			try {
				return choice(MapperS.of(settlementPeriodLeverage), Arrays.asList("ratio", "settlementPeriodLeverageSequence"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SettlementPeriodLeverageChoice {
	
		@Override
		public ValidationResult<SettlementPeriodLeverage> validate(RosettaPath path, SettlementPeriodLeverage settlementPeriodLeverage) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementPeriodLeverage", path, DEFINITION);
		}
	}
}
