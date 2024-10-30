package cdm.observable.asset.validation.datarule;

import cdm.observable.asset.FloatingRateIndex;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 6.0.0-dev.76
 */
@RosettaDataRule("FloatingRateIndexChoice")
@ImplementedBy(FloatingRateIndexChoice.Default.class)
public interface FloatingRateIndexChoice extends Validator<FloatingRateIndex> {
	
	String NAME = "FloatingRateIndexChoice";
	String DEFINITION = "";
	
	ValidationResult<FloatingRateIndex> validate(RosettaPath path, FloatingRateIndex floatingRateIndex);
	
	class Default implements FloatingRateIndexChoice {
	
		@Override
		public ValidationResult<FloatingRateIndex> validate(RosettaPath path, FloatingRateIndex floatingRateIndex) {
			ComparisonResult result = executeDataRule(floatingRateIndex);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FloatingRateIndex", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FloatingRateIndex", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FloatingRateIndex floatingRateIndex) {
			try {
				return choice(MapperS.of(floatingRateIndex), Arrays.asList("InterestRateIndex", "InflationIndex"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FloatingRateIndexChoice {
	
		@Override
		public ValidationResult<FloatingRateIndex> validate(RosettaPath path, FloatingRateIndex floatingRateIndex) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FloatingRateIndex", path, DEFINITION);
		}
	}
}
