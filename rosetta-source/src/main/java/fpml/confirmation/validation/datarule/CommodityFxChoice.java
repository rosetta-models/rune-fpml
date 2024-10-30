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
import fpml.confirmation.CommodityFx;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CommodityFxChoice")
@ImplementedBy(CommodityFxChoice.Default.class)
public interface CommodityFxChoice extends Validator<CommodityFx> {
	
	String NAME = "CommodityFxChoice";
	String DEFINITION = "optional choice fixingTime, commodityFxSequence";
	
	ValidationResult<CommodityFx> validate(RosettaPath path, CommodityFx commodityFx);
	
	class Default implements CommodityFxChoice {
	
		@Override
		public ValidationResult<CommodityFx> validate(RosettaPath path, CommodityFx commodityFx) {
			ComparisonResult result = executeDataRule(commodityFx);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityFx", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityFx", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityFx commodityFx) {
			try {
				return choice(MapperS.of(commodityFx), Arrays.asList("fixingTime", "commodityFxSequence"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityFxChoice {
	
		@Override
		public ValidationResult<CommodityFx> validate(RosettaPath path, CommodityFx commodityFx) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityFx", path, DEFINITION);
		}
	}
}
