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
import fpml.confirmation.TradeLegPriceChange;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("TradeLegPriceChangeChoice")
@ImplementedBy(TradeLegPriceChangeChoice.Default.class)
public interface TradeLegPriceChangeChoice extends Validator<TradeLegPriceChange> {
	
	String NAME = "TradeLegPriceChangeChoice";
	String DEFINITION = "required choice priceReference, instrumentId";
	
	ValidationResult<TradeLegPriceChange> validate(RosettaPath path, TradeLegPriceChange tradeLegPriceChange);
	
	class Default implements TradeLegPriceChangeChoice {
	
		@Override
		public ValidationResult<TradeLegPriceChange> validate(RosettaPath path, TradeLegPriceChange tradeLegPriceChange) {
			ComparisonResult result = executeDataRule(tradeLegPriceChange);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeLegPriceChange", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "TradeLegPriceChange", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(TradeLegPriceChange tradeLegPriceChange) {
			try {
				return choice(MapperS.of(tradeLegPriceChange), Arrays.asList("priceReference", "instrumentId"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeLegPriceChangeChoice {
	
		@Override
		public ValidationResult<TradeLegPriceChange> validate(RosettaPath path, TradeLegPriceChange tradeLegPriceChange) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeLegPriceChange", path, DEFINITION);
		}
	}
}
