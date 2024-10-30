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
import fpml.confirmation.SettlementPeriodFixingDates;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("SettlementPeriodFixingDatesChoice")
@ImplementedBy(SettlementPeriodFixingDatesChoice.Default.class)
public interface SettlementPeriodFixingDatesChoice extends Validator<SettlementPeriodFixingDates> {
	
	String NAME = "SettlementPeriodFixingDatesChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<SettlementPeriodFixingDates> validate(RosettaPath path, SettlementPeriodFixingDates settlementPeriodFixingDates);
	
	class Default implements SettlementPeriodFixingDatesChoice {
	
		@Override
		public ValidationResult<SettlementPeriodFixingDates> validate(RosettaPath path, SettlementPeriodFixingDates settlementPeriodFixingDates) {
			ComparisonResult result = executeDataRule(settlementPeriodFixingDates);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementPeriodFixingDates", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "SettlementPeriodFixingDates", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(SettlementPeriodFixingDates settlementPeriodFixingDates) {
			try {
				return choice(MapperS.of(settlementPeriodFixingDates), Arrays.asList("fixingDate", "settlementPeriodFixingDatesSequence", "numberOfFixings"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SettlementPeriodFixingDatesChoice {
	
		@Override
		public ValidationResult<SettlementPeriodFixingDates> validate(RosettaPath path, SettlementPeriodFixingDates settlementPeriodFixingDates) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementPeriodFixingDates", path, DEFINITION);
		}
	}
}
