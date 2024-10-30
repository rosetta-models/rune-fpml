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
import fpml.confirmation.CommodityPhysicalAmericanExercise;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CommodityPhysicalAmericanExerciseChoice")
@ImplementedBy(CommodityPhysicalAmericanExerciseChoice.Default.class)
public interface CommodityPhysicalAmericanExerciseChoice extends Validator<CommodityPhysicalAmericanExercise> {
	
	String NAME = "CommodityPhysicalAmericanExerciseChoice";
	String DEFINITION = "required choice commodityPhysicalAmericanExerciseSequence0, commodityPhysicalAmericanExerciseSequence1";
	
	ValidationResult<CommodityPhysicalAmericanExercise> validate(RosettaPath path, CommodityPhysicalAmericanExercise commodityPhysicalAmericanExercise);
	
	class Default implements CommodityPhysicalAmericanExerciseChoice {
	
		@Override
		public ValidationResult<CommodityPhysicalAmericanExercise> validate(RosettaPath path, CommodityPhysicalAmericanExercise commodityPhysicalAmericanExercise) {
			ComparisonResult result = executeDataRule(commodityPhysicalAmericanExercise);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityPhysicalAmericanExercise", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityPhysicalAmericanExercise", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityPhysicalAmericanExercise commodityPhysicalAmericanExercise) {
			try {
				return choice(MapperS.of(commodityPhysicalAmericanExercise), Arrays.asList("commodityPhysicalAmericanExerciseSequence0", "commodityPhysicalAmericanExerciseSequence1"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityPhysicalAmericanExerciseChoice {
	
		@Override
		public ValidationResult<CommodityPhysicalAmericanExercise> validate(RosettaPath path, CommodityPhysicalAmericanExercise commodityPhysicalAmericanExercise) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityPhysicalAmericanExercise", path, DEFINITION);
		}
	}
}
