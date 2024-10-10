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
import fpml.confirmation.CommodityExerciseBasket;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CommodityExerciseBasketChoice")
@ImplementedBy(CommodityExerciseBasketChoice.Default.class)
public interface CommodityExerciseBasketChoice extends Validator<CommodityExerciseBasket> {
	
	String NAME = "CommodityExerciseBasketChoice";
	String DEFINITION = "required choice americanExercise, europeanExercise";
	
	ValidationResult<CommodityExerciseBasket> validate(RosettaPath path, CommodityExerciseBasket commodityExerciseBasket);
	
	class Default implements CommodityExerciseBasketChoice {
	
		@Override
		public ValidationResult<CommodityExerciseBasket> validate(RosettaPath path, CommodityExerciseBasket commodityExerciseBasket) {
			ComparisonResult result = executeDataRule(commodityExerciseBasket);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityExerciseBasket", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityExerciseBasket", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityExerciseBasket commodityExerciseBasket) {
			try {
				return choice(MapperS.of(commodityExerciseBasket), Arrays.asList("americanExercise", "europeanExercise"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityExerciseBasketChoice {
	
		@Override
		public ValidationResult<CommodityExerciseBasket> validate(RosettaPath path, CommodityExerciseBasket commodityExerciseBasket) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityExerciseBasket", path, DEFINITION);
		}
	}
}
