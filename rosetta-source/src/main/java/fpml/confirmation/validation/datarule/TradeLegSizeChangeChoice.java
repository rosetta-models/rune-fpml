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
import fpml.confirmation.TradeLegSizeChange;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("TradeLegSizeChangeChoice")
@ImplementedBy(TradeLegSizeChangeChoice.Default.class)
public interface TradeLegSizeChangeChoice extends Validator<TradeLegSizeChange> {
	
	String NAME = "TradeLegSizeChangeChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<TradeLegSizeChange> validate(RosettaPath path, TradeLegSizeChange tradeLegSizeChange);
	
	class Default implements TradeLegSizeChangeChoice {
	
		@Override
		public ValidationResult<TradeLegSizeChange> validate(RosettaPath path, TradeLegSizeChange tradeLegSizeChange) {
			ComparisonResult result = executeDataRule(tradeLegSizeChange);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeLegSizeChange", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "TradeLegSizeChange", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(TradeLegSizeChange tradeLegSizeChange) {
			try {
				return choice(MapperS.of(tradeLegSizeChange), Arrays.asList("tradeLegNotionalChangeModel", "tradeLegNumberOfOptionsChangeModel", "tradeLegNumberOfUnitsChangeModel", "tradeLegNotionalScheduleChangeModel", "tradeLegFixedAmountChangeModel"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeLegSizeChangeChoice {
	
		@Override
		public ValidationResult<TradeLegSizeChange> validate(RosettaPath path, TradeLegSizeChange tradeLegSizeChange) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeLegSizeChange", path, DEFINITION);
		}
	}
}
