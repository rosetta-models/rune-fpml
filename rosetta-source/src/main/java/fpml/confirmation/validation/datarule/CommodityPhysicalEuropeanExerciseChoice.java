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
import fpml.confirmation.CommodityPhysicalEuropeanExercise;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CommodityPhysicalEuropeanExerciseChoice")
@ImplementedBy(CommodityPhysicalEuropeanExerciseChoice.Default.class)
public interface CommodityPhysicalEuropeanExerciseChoice extends Validator<CommodityPhysicalEuropeanExercise> {
	
	String NAME = "CommodityPhysicalEuropeanExerciseChoice";
	String DEFINITION = "required choice expirationDate, expirationDates , relativeExpirationDates";
	
	ValidationResult<CommodityPhysicalEuropeanExercise> validate(RosettaPath path, CommodityPhysicalEuropeanExercise commodityPhysicalEuropeanExercise);
	
	class Default implements CommodityPhysicalEuropeanExerciseChoice {
	
		@Override
		public ValidationResult<CommodityPhysicalEuropeanExercise> validate(RosettaPath path, CommodityPhysicalEuropeanExercise commodityPhysicalEuropeanExercise) {
			ComparisonResult result = executeDataRule(commodityPhysicalEuropeanExercise);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityPhysicalEuropeanExercise", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CommodityPhysicalEuropeanExercise", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CommodityPhysicalEuropeanExercise commodityPhysicalEuropeanExercise) {
			try {
				return choice(MapperS.of(commodityPhysicalEuropeanExercise), Arrays.asList("expirationDate", "expirationDates", "relativeExpirationDates"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CommodityPhysicalEuropeanExerciseChoice {
	
		@Override
		public ValidationResult<CommodityPhysicalEuropeanExercise> validate(RosettaPath path, CommodityPhysicalEuropeanExercise commodityPhysicalEuropeanExercise) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CommodityPhysicalEuropeanExercise", path, DEFINITION);
		}
	}
}
