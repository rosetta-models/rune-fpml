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
import fpml.confirmation.StrategyFeature;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("StrategyFeatureChoice")
@ImplementedBy(StrategyFeatureChoice.Default.class)
public interface StrategyFeatureChoice extends Validator<StrategyFeature> {
	
	String NAME = "StrategyFeatureChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<StrategyFeature> validate(RosettaPath path, StrategyFeature strategyFeature);
	
	class Default implements StrategyFeatureChoice {
	
		@Override
		public ValidationResult<StrategyFeature> validate(RosettaPath path, StrategyFeature strategyFeature) {
			ComparisonResult result = executeDataRule(strategyFeature);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "StrategyFeature", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "StrategyFeature", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(StrategyFeature strategyFeature) {
			try {
				return choice(MapperS.of(strategyFeature), Arrays.asList("strikeSpread", "calendarSpread"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements StrategyFeatureChoice {
	
		@Override
		public ValidationResult<StrategyFeature> validate(RosettaPath path, StrategyFeature strategyFeature) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "StrategyFeature", path, DEFINITION);
		}
	}
}
