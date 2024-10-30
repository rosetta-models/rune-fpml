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
import fpml.confirmation.NotionalStepRule;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("NotionalStepRuleChoice")
@ImplementedBy(NotionalStepRuleChoice.Default.class)
public interface NotionalStepRuleChoice extends Validator<NotionalStepRule> {
	
	String NAME = "NotionalStepRuleChoice";
	String DEFINITION = "required choice notionalStepAmount, notionalStepRuleSequence";
	
	ValidationResult<NotionalStepRule> validate(RosettaPath path, NotionalStepRule notionalStepRule);
	
	class Default implements NotionalStepRuleChoice {
	
		@Override
		public ValidationResult<NotionalStepRule> validate(RosettaPath path, NotionalStepRule notionalStepRule) {
			ComparisonResult result = executeDataRule(notionalStepRule);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "NotionalStepRule", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "NotionalStepRule", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(NotionalStepRule notionalStepRule) {
			try {
				return choice(MapperS.of(notionalStepRule), Arrays.asList("notionalStepAmount", "notionalStepRuleSequence"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements NotionalStepRuleChoice {
	
		@Override
		public ValidationResult<NotionalStepRule> validate(RosettaPath path, NotionalStepRule notionalStepRule) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "NotionalStepRule", path, DEFINITION);
		}
	}
}
