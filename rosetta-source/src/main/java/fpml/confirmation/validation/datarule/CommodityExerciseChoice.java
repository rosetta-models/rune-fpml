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
import fpml.confirmation.CommodityExercise;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CommodityExerciseChoice")
@ImplementedBy(CommodityExerciseChoice.Default.class)
public interface CommodityExerciseChoice extends Validator<CommodityExercise> {
	
	String NAME = "CommodityExerciseChoice";
	String DEFINITION = "required choice americanExercise, europeanExercise";
	
	ValidationResult<CommodityExercise> validate(RosettaPath path, CommodityExercise commodityExercise);
	
	class Default implements CommodityExerciseChoice {
	
		@Override
		public ValidationResult<CommodityExercise> validate(RosettaPath path, CommodityExercise commodityExercise) {
			ComparisonResult result = executeDataRule(commodityExercise);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityExercise", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityExercise", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityExercise commodityExercise) {
			try {
				return choice(MapperS.of(commodityExercise), Arrays.asList("americanExercise", "europeanExercise"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityExerciseChoice {
	
		@Override
		public ValidationResult<CommodityExercise> validate(RosettaPath path, CommodityExercise commodityExercise) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityExercise", path, DEFINITION);
		}
	}
}
