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
import fpml.confirmation.TradeNotionalChangeModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("TradeNotionalChangeModelChoice")
@ImplementedBy(TradeNotionalChangeModelChoice.Default.class)
public interface TradeNotionalChangeModelChoice extends Validator<TradeNotionalChangeModel> {
	
	String NAME = "TradeNotionalChangeModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<TradeNotionalChangeModel> validate(RosettaPath path, TradeNotionalChangeModel tradeNotionalChangeModel);
	
	class Default implements TradeNotionalChangeModelChoice {
	
		@Override
		public ValidationResult<TradeNotionalChangeModel> validate(RosettaPath path, TradeNotionalChangeModel tradeNotionalChangeModel) {
			ComparisonResult result = executeDataRule(tradeNotionalChangeModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeNotionalChangeModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "TradeNotionalChangeModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(TradeNotionalChangeModel tradeNotionalChangeModel) {
			try {
				return choice(MapperS.of(tradeNotionalChangeModel), Arrays.asList("tradeNotionalChangeModelSequence0", "tradeNotionalChangeModelSequence1", "tradeNotionalChangeModelSequence2"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeNotionalChangeModelChoice {
	
		@Override
		public ValidationResult<TradeNotionalChangeModel> validate(RosettaPath path, TradeNotionalChangeModel tradeNotionalChangeModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeNotionalChangeModel", path, DEFINITION);
		}
	}
}
