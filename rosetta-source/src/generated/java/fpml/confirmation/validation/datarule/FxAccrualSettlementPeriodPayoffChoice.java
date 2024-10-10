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
import fpml.confirmation.FxAccrualSettlementPeriodPayoff;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("FxAccrualSettlementPeriodPayoffChoice")
@ImplementedBy(FxAccrualSettlementPeriodPayoffChoice.Default.class)
public interface FxAccrualSettlementPeriodPayoffChoice extends Validator<FxAccrualSettlementPeriodPayoff> {
	
	String NAME = "FxAccrualSettlementPeriodPayoffChoice";
	String DEFINITION = "required choice fxAccrualSettlementPeriodPayoffSequence, averageStrikeFixingDates";
	
	ValidationResult<FxAccrualSettlementPeriodPayoff> validate(RosettaPath path, FxAccrualSettlementPeriodPayoff fxAccrualSettlementPeriodPayoff);
	
	class Default implements FxAccrualSettlementPeriodPayoffChoice {
	
		@Override
		public ValidationResult<FxAccrualSettlementPeriodPayoff> validate(RosettaPath path, FxAccrualSettlementPeriodPayoff fxAccrualSettlementPeriodPayoff) {
			ComparisonResult result = executeDataRule(fxAccrualSettlementPeriodPayoff);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAccrualSettlementPeriodPayoff", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxAccrualSettlementPeriodPayoff", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxAccrualSettlementPeriodPayoff fxAccrualSettlementPeriodPayoff) {
			try {
				return choice(MapperS.of(fxAccrualSettlementPeriodPayoff), Arrays.asList("fxAccrualSettlementPeriodPayoffSequence", "averageStrikeFixingDates"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxAccrualSettlementPeriodPayoffChoice {
	
		@Override
		public ValidationResult<FxAccrualSettlementPeriodPayoff> validate(RosettaPath path, FxAccrualSettlementPeriodPayoff fxAccrualSettlementPeriodPayoff) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAccrualSettlementPeriodPayoff", path, DEFINITION);
		}
	}
}
