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
import fpml.confirmation.EquityExerciseValuationSettlement;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("EquityExerciseValuationSettlementChoice0")
@ImplementedBy(EquityExerciseValuationSettlementChoice0.Default.class)
public interface EquityExerciseValuationSettlementChoice0 extends Validator<EquityExerciseValuationSettlement> {
	
	String NAME = "EquityExerciseValuationSettlementChoice0";
	String DEFINITION = "required choice equityEuropeanExercise, equityAmericanExercise , equityBermudaExercise";
	
	ValidationResult<EquityExerciseValuationSettlement> validate(RosettaPath path, EquityExerciseValuationSettlement equityExerciseValuationSettlement);
	
	class Default implements EquityExerciseValuationSettlementChoice0 {
	
		@Override
		public ValidationResult<EquityExerciseValuationSettlement> validate(RosettaPath path, EquityExerciseValuationSettlement equityExerciseValuationSettlement) {
			ComparisonResult result = executeDataRule(equityExerciseValuationSettlement);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityExerciseValuationSettlement", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "EquityExerciseValuationSettlement", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(EquityExerciseValuationSettlement equityExerciseValuationSettlement) {
			try {
				return choice(MapperS.of(equityExerciseValuationSettlement), Arrays.asList("equityEuropeanExercise", "equityAmericanExercise", "equityBermudaExercise"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EquityExerciseValuationSettlementChoice0 {
	
		@Override
		public ValidationResult<EquityExerciseValuationSettlement> validate(RosettaPath path, EquityExerciseValuationSettlement equityExerciseValuationSettlement) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityExerciseValuationSettlement", path, DEFINITION);
		}
	}
}
