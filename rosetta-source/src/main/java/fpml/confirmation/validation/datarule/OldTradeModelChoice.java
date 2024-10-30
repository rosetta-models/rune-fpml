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
import fpml.confirmation.OldTradeModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("OldTradeModelChoice")
@ImplementedBy(OldTradeModelChoice.Default.class)
public interface OldTradeModelChoice extends Validator<OldTradeModel> {
	
	String NAME = "OldTradeModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<OldTradeModel> validate(RosettaPath path, OldTradeModel oldTradeModel);
	
	class Default implements OldTradeModelChoice {
	
		@Override
		public ValidationResult<OldTradeModel> validate(RosettaPath path, OldTradeModel oldTradeModel) {
			ComparisonResult result = executeDataRule(oldTradeModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OldTradeModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "OldTradeModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(OldTradeModel oldTradeModel) {
			try {
				return choice(MapperS.of(oldTradeModel), Arrays.asList("oldTradeIdentifier", "oldTrade"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OldTradeModelChoice {
	
		@Override
		public ValidationResult<OldTradeModel> validate(RosettaPath path, OldTradeModel oldTradeModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OldTradeModel", path, DEFINITION);
		}
	}
}
