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
import fpml.confirmation.CommodityForward;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CommodityForwardChoice")
@ImplementedBy(CommodityForwardChoice.Default.class)
public interface CommodityForwardChoice extends Validator<CommodityForward> {
	
	String NAME = "CommodityForwardChoice";
	String DEFINITION = "required choice fixedLeg, averagePriceLeg";
	
	ValidationResult<CommodityForward> validate(RosettaPath path, CommodityForward commodityForward);
	
	class Default implements CommodityForwardChoice {
	
		@Override
		public ValidationResult<CommodityForward> validate(RosettaPath path, CommodityForward commodityForward) {
			ComparisonResult result = executeDataRule(commodityForward);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityForward", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityForward", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityForward commodityForward) {
			try {
				return choice(MapperS.of(commodityForward), Arrays.asList("fixedLeg", "averagePriceLeg"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityForwardChoice {
	
		@Override
		public ValidationResult<CommodityForward> validate(RosettaPath path, CommodityForward commodityForward) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityForward", path, DEFINITION);
		}
	}
}
