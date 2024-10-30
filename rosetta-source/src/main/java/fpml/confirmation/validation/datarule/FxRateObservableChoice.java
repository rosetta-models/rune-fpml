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
import fpml.confirmation.FxRateObservable;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("FxRateObservableChoice")
@ImplementedBy(FxRateObservableChoice.Default.class)
public interface FxRateObservableChoice extends Validator<FxRateObservable> {
	
	String NAME = "FxRateObservableChoice";
	String DEFINITION = "required choice informationSource, crossRate";
	
	ValidationResult<FxRateObservable> validate(RosettaPath path, FxRateObservable fxRateObservable);
	
	class Default implements FxRateObservableChoice {
	
		@Override
		public ValidationResult<FxRateObservable> validate(RosettaPath path, FxRateObservable fxRateObservable) {
			ComparisonResult result = executeDataRule(fxRateObservable);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxRateObservable", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxRateObservable", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxRateObservable fxRateObservable) {
			try {
				return choice(MapperS.of(fxRateObservable), Arrays.asList("informationSource", "crossRate"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxRateObservableChoice {
	
		@Override
		public ValidationResult<FxRateObservable> validate(RosettaPath path, FxRateObservable fxRateObservable) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxRateObservable", path, DEFINITION);
		}
	}
}
