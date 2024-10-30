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
import fpml.confirmation.CommodityDigitalExercise;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CommodityDigitalExerciseChoice")
@ImplementedBy(CommodityDigitalExerciseChoice.Default.class)
public interface CommodityDigitalExerciseChoice extends Validator<CommodityDigitalExercise> {
	
	String NAME = "CommodityDigitalExerciseChoice";
	String DEFINITION = "required choice americanExercise, europeanExercise";
	
	ValidationResult<CommodityDigitalExercise> validate(RosettaPath path, CommodityDigitalExercise commodityDigitalExercise);
	
	class Default implements CommodityDigitalExerciseChoice {
	
		@Override
		public ValidationResult<CommodityDigitalExercise> validate(RosettaPath path, CommodityDigitalExercise commodityDigitalExercise) {
			ComparisonResult result = executeDataRule(commodityDigitalExercise);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityDigitalExercise", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityDigitalExercise", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityDigitalExercise commodityDigitalExercise) {
			try {
				return choice(MapperS.of(commodityDigitalExercise), Arrays.asList("americanExercise", "europeanExercise"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityDigitalExerciseChoice {
	
		@Override
		public ValidationResult<CommodityDigitalExercise> validate(RosettaPath path, CommodityDigitalExercise commodityDigitalExercise) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityDigitalExercise", path, DEFINITION);
		}
	}
}
