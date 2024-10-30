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
import fpml.confirmation.CommodityReturnLeg;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CommodityReturnLegChoice")
@ImplementedBy(CommodityReturnLegChoice.Default.class)
public interface CommodityReturnLegChoice extends Validator<CommodityReturnLeg> {
	
	String NAME = "CommodityReturnLegChoice";
	String DEFINITION = "required choice notionalAmount, notionalAmountReference";
	
	ValidationResult<CommodityReturnLeg> validate(RosettaPath path, CommodityReturnLeg commodityReturnLeg);
	
	class Default implements CommodityReturnLegChoice {
	
		@Override
		public ValidationResult<CommodityReturnLeg> validate(RosettaPath path, CommodityReturnLeg commodityReturnLeg) {
			ComparisonResult result = executeDataRule(commodityReturnLeg);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityReturnLeg", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityReturnLeg", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityReturnLeg commodityReturnLeg) {
			try {
				return choice(MapperS.of(commodityReturnLeg), Arrays.asList("notionalAmount", "notionalAmountReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityReturnLegChoice {
	
		@Override
		public ValidationResult<CommodityReturnLeg> validate(RosettaPath path, CommodityReturnLeg commodityReturnLeg) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityReturnLeg", path, DEFINITION);
		}
	}
}
