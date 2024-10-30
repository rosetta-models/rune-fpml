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
import fpml.confirmation.TradeOrInfoModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("TradeOrInfoModelChoice")
@ImplementedBy(TradeOrInfoModelChoice.Default.class)
public interface TradeOrInfoModelChoice extends Validator<TradeOrInfoModel> {
	
	String NAME = "TradeOrInfoModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<TradeOrInfoModel> validate(RosettaPath path, TradeOrInfoModel tradeOrInfoModel);
	
	class Default implements TradeOrInfoModelChoice {
	
		@Override
		public ValidationResult<TradeOrInfoModel> validate(RosettaPath path, TradeOrInfoModel tradeOrInfoModel) {
			ComparisonResult result = executeDataRule(tradeOrInfoModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeOrInfoModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "TradeOrInfoModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(TradeOrInfoModel tradeOrInfoModel) {
			try {
				return choice(MapperS.of(tradeOrInfoModel), Arrays.asList("tradeOrInfoModelSequence", "tradeReferenceInformationModel", "tradePackage"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradeOrInfoModelChoice {
	
		@Override
		public ValidationResult<TradeOrInfoModel> validate(RosettaPath path, TradeOrInfoModel tradeOrInfoModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradeOrInfoModel", path, DEFINITION);
		}
	}
}
