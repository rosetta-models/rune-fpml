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
import fpml.confirmation.CommodityAmericanExercise;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CommodityAmericanExerciseChoice")
@ImplementedBy(CommodityAmericanExerciseChoice.Default.class)
public interface CommodityAmericanExerciseChoice extends Validator<CommodityAmericanExercise> {
	
	String NAME = "CommodityAmericanExerciseChoice";
	String DEFINITION = "optional choice latestExerciseTime, latestExerciseTimeDetermination";
	
	ValidationResult<CommodityAmericanExercise> validate(RosettaPath path, CommodityAmericanExercise commodityAmericanExercise);
	
	class Default implements CommodityAmericanExerciseChoice {
	
		@Override
		public ValidationResult<CommodityAmericanExercise> validate(RosettaPath path, CommodityAmericanExercise commodityAmericanExercise) {
			ComparisonResult result = executeDataRule(commodityAmericanExercise);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityAmericanExercise", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityAmericanExercise", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityAmericanExercise commodityAmericanExercise) {
			try {
				return choice(MapperS.of(commodityAmericanExercise), Arrays.asList("latestExerciseTime", "latestExerciseTimeDetermination"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityAmericanExerciseChoice {
	
		@Override
		public ValidationResult<CommodityAmericanExercise> validate(RosettaPath path, CommodityAmericanExercise commodityAmericanExercise) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityAmericanExercise", path, DEFINITION);
		}
	}
}
