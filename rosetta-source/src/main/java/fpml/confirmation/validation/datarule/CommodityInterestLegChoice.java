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
import fpml.confirmation.CommodityInterestLeg;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CommodityInterestLegChoice")
@ImplementedBy(CommodityInterestLegChoice.Default.class)
public interface CommodityInterestLegChoice extends Validator<CommodityInterestLeg> {
	
	String NAME = "CommodityInterestLegChoice";
	String DEFINITION = "required choice notionalAmount, notionalAmountReference";
	
	ValidationResult<CommodityInterestLeg> validate(RosettaPath path, CommodityInterestLeg commodityInterestLeg);
	
	class Default implements CommodityInterestLegChoice {
	
		@Override
		public ValidationResult<CommodityInterestLeg> validate(RosettaPath path, CommodityInterestLeg commodityInterestLeg) {
			ComparisonResult result = executeDataRule(commodityInterestLeg);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityInterestLeg", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityInterestLeg", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityInterestLeg commodityInterestLeg) {
			try {
				return choice(MapperS.of(commodityInterestLeg), Arrays.asList("notionalAmount", "notionalAmountReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityInterestLegChoice {
	
		@Override
		public ValidationResult<CommodityInterestLeg> validate(RosettaPath path, CommodityInterestLeg commodityInterestLeg) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityInterestLeg", path, DEFINITION);
		}
	}
}
