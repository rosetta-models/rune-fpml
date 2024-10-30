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
import fpml.confirmation.NewTradeModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("NewTradeModelChoice")
@ImplementedBy(NewTradeModelChoice.Default.class)
public interface NewTradeModelChoice extends Validator<NewTradeModel> {
	
	String NAME = "NewTradeModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<NewTradeModel> validate(RosettaPath path, NewTradeModel newTradeModel);
	
	class Default implements NewTradeModelChoice {
	
		@Override
		public ValidationResult<NewTradeModel> validate(RosettaPath path, NewTradeModel newTradeModel) {
			ComparisonResult result = executeDataRule(newTradeModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "NewTradeModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "NewTradeModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(NewTradeModel newTradeModel) {
			try {
				return choice(MapperS.of(newTradeModel), Arrays.asList("newTradeIdentifier", "newTrade"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements NewTradeModelChoice {
	
		@Override
		public ValidationResult<NewTradeModel> validate(RosettaPath path, NewTradeModel newTradeModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "NewTradeModel", path, DEFINITION);
		}
	}
}
