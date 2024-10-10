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
import fpml.confirmation.FxCashSettlement;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("FxCashSettlementChoice")
@ImplementedBy(FxCashSettlementChoice.Default.class)
public interface FxCashSettlementChoice extends Validator<FxCashSettlement> {
	
	String NAME = "FxCashSettlementChoice";
	String DEFINITION = "optional choice fixing, rateSourceFixing";
	
	ValidationResult<FxCashSettlement> validate(RosettaPath path, FxCashSettlement fxCashSettlement);
	
	class Default implements FxCashSettlementChoice {
	
		@Override
		public ValidationResult<FxCashSettlement> validate(RosettaPath path, FxCashSettlement fxCashSettlement) {
			ComparisonResult result = executeDataRule(fxCashSettlement);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxCashSettlement", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxCashSettlement", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxCashSettlement fxCashSettlement) {
			try {
				return choice(MapperS.of(fxCashSettlement), Arrays.asList("fixing", "rateSourceFixing"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxCashSettlementChoice {
	
		@Override
		public ValidationResult<FxCashSettlement> validate(RosettaPath path, FxCashSettlement fxCashSettlement) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxCashSettlement", path, DEFINITION);
		}
	}
}
