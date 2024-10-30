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
import fpml.confirmation.FeeTradeModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("FeeTradeModelChoice")
@ImplementedBy(FeeTradeModelChoice.Default.class)
public interface FeeTradeModelChoice extends Validator<FeeTradeModel> {
	
	String NAME = "FeeTradeModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<FeeTradeModel> validate(RosettaPath path, FeeTradeModel feeTradeModel);
	
	class Default implements FeeTradeModelChoice {
	
		@Override
		public ValidationResult<FeeTradeModel> validate(RosettaPath path, FeeTradeModel feeTradeModel) {
			ComparisonResult result = executeDataRule(feeTradeModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FeeTradeModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FeeTradeModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FeeTradeModel feeTradeModel) {
			try {
				return choice(MapperS.of(feeTradeModel), Arrays.asList("feeTradeIdentifier", "feeTrade"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FeeTradeModelChoice {
	
		@Override
		public ValidationResult<FeeTradeModel> validate(RosettaPath path, FeeTradeModel feeTradeModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FeeTradeModel", path, DEFINITION);
		}
	}
}
