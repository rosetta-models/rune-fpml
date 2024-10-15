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
import fpml.confirmation.CommodityFxSequence;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CommodityFxSequenceChoice")
@ImplementedBy(CommodityFxSequenceChoice.Default.class)
public interface CommodityFxSequenceChoice extends Validator<CommodityFxSequence> {
	
	String NAME = "CommodityFxSequenceChoice";
	String DEFINITION = "required choice fxObservationDates, commodityFxSequenceSequence";
	
	ValidationResult<CommodityFxSequence> validate(RosettaPath path, CommodityFxSequence commodityFxSequence);
	
	class Default implements CommodityFxSequenceChoice {
	
		@Override
		public ValidationResult<CommodityFxSequence> validate(RosettaPath path, CommodityFxSequence commodityFxSequence) {
			ComparisonResult result = executeDataRule(commodityFxSequence);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityFxSequence", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityFxSequence", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityFxSequence commodityFxSequence) {
			try {
				return choice(MapperS.of(commodityFxSequence), Arrays.asList("fxObservationDates", "commodityFxSequenceSequence"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityFxSequenceChoice {
	
		@Override
		public ValidationResult<CommodityFxSequence> validate(RosettaPath path, CommodityFxSequence commodityFxSequence) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityFxSequence", path, DEFINITION);
		}
	}
}
