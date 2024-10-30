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
import fpml.confirmation.CommodityPhysicalExercise;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CommodityPhysicalExerciseChoice")
@ImplementedBy(CommodityPhysicalExerciseChoice.Default.class)
public interface CommodityPhysicalExerciseChoice extends Validator<CommodityPhysicalExercise> {
	
	String NAME = "CommodityPhysicalExerciseChoice";
	String DEFINITION = "required choice americanExercise, europeanExercise";
	
	ValidationResult<CommodityPhysicalExercise> validate(RosettaPath path, CommodityPhysicalExercise commodityPhysicalExercise);
	
	class Default implements CommodityPhysicalExerciseChoice {
	
		@Override
		public ValidationResult<CommodityPhysicalExercise> validate(RosettaPath path, CommodityPhysicalExercise commodityPhysicalExercise) {
			ComparisonResult result = executeDataRule(commodityPhysicalExercise);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityPhysicalExercise", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityPhysicalExercise", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityPhysicalExercise commodityPhysicalExercise) {
			try {
				return choice(MapperS.of(commodityPhysicalExercise), Arrays.asList("americanExercise", "europeanExercise"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityPhysicalExerciseChoice {
	
		@Override
		public ValidationResult<CommodityPhysicalExercise> validate(RosettaPath path, CommodityPhysicalExercise commodityPhysicalExercise) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityPhysicalExercise", path, DEFINITION);
		}
	}
}
