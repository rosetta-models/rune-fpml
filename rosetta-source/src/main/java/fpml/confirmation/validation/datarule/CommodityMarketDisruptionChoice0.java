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
import fpml.confirmation.CommodityMarketDisruption;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CommodityMarketDisruptionChoice0")
@ImplementedBy(CommodityMarketDisruptionChoice0.Default.class)
public interface CommodityMarketDisruptionChoice0 extends Validator<CommodityMarketDisruption> {
	
	String NAME = "CommodityMarketDisruptionChoice0";
	String DEFINITION = "required choice commodityMarketDisruptionSequence, marketDisruptionEvent";
	
	ValidationResult<CommodityMarketDisruption> validate(RosettaPath path, CommodityMarketDisruption commodityMarketDisruption);
	
	class Default implements CommodityMarketDisruptionChoice0 {
	
		@Override
		public ValidationResult<CommodityMarketDisruption> validate(RosettaPath path, CommodityMarketDisruption commodityMarketDisruption) {
			ComparisonResult result = executeDataRule(commodityMarketDisruption);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityMarketDisruption", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityMarketDisruption", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityMarketDisruption commodityMarketDisruption) {
			try {
				return choice(MapperS.of(commodityMarketDisruption), Arrays.asList("commodityMarketDisruptionSequence", "marketDisruptionEvent"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityMarketDisruptionChoice0 {
	
		@Override
		public ValidationResult<CommodityMarketDisruption> validate(RosettaPath path, CommodityMarketDisruption commodityMarketDisruption) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityMarketDisruption", path, DEFINITION);
		}
	}
}
