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
import fpml.confirmation.CommodityDigitalOption;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CommodityDigitalOptionChoice")
@ImplementedBy(CommodityDigitalOptionChoice.Default.class)
public interface CommodityDigitalOptionChoice extends Validator<CommodityDigitalOption> {
	
	String NAME = "CommodityDigitalOptionChoice";
	String DEFINITION = "required choice notionalAmount, commodityDigitalOptionSequence";
	
	ValidationResult<CommodityDigitalOption> validate(RosettaPath path, CommodityDigitalOption commodityDigitalOption);
	
	class Default implements CommodityDigitalOptionChoice {
	
		@Override
		public ValidationResult<CommodityDigitalOption> validate(RosettaPath path, CommodityDigitalOption commodityDigitalOption) {
			ComparisonResult result = executeDataRule(commodityDigitalOption);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityDigitalOption", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityDigitalOption", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityDigitalOption commodityDigitalOption) {
			try {
				return choice(MapperS.of(commodityDigitalOption), Arrays.asList("notionalAmount", "commodityDigitalOptionSequence"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityDigitalOptionChoice {
	
		@Override
		public ValidationResult<CommodityDigitalOption> validate(RosettaPath path, CommodityDigitalOption commodityDigitalOption) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityDigitalOption", path, DEFINITION);
		}
	}
}
