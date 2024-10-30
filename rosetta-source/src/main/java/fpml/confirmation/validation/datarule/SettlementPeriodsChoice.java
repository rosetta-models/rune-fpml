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
import fpml.confirmation.SettlementPeriods;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("SettlementPeriodsChoice")
@ImplementedBy(SettlementPeriodsChoice.Default.class)
public interface SettlementPeriodsChoice extends Validator<SettlementPeriods> {
	
	String NAME = "SettlementPeriodsChoice";
	String DEFINITION = "optional choice excludeHolidays, includeHolidays";
	
	ValidationResult<SettlementPeriods> validate(RosettaPath path, SettlementPeriods settlementPeriods);
	
	class Default implements SettlementPeriodsChoice {
	
		@Override
		public ValidationResult<SettlementPeriods> validate(RosettaPath path, SettlementPeriods settlementPeriods) {
			ComparisonResult result = executeDataRule(settlementPeriods);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementPeriods", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "SettlementPeriods", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(SettlementPeriods settlementPeriods) {
			try {
				return choice(MapperS.of(settlementPeriods), Arrays.asList("excludeHolidays", "includeHolidays"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SettlementPeriodsChoice {
	
		@Override
		public ValidationResult<SettlementPeriods> validate(RosettaPath path, SettlementPeriods settlementPeriods) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementPeriods", path, DEFINITION);
		}
	}
}
