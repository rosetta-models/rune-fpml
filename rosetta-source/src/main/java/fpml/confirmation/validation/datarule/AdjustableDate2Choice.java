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
import fpml.confirmation.AdjustableDate2;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("AdjustableDate2Choice")
@ImplementedBy(AdjustableDate2Choice.Default.class)
public interface AdjustableDate2Choice extends Validator<AdjustableDate2> {
	
	String NAME = "AdjustableDate2Choice";
	String DEFINITION = "optional choice dateAdjustments, dateAdjustmentsReference";
	
	ValidationResult<AdjustableDate2> validate(RosettaPath path, AdjustableDate2 adjustableDate2);
	
	class Default implements AdjustableDate2Choice {
	
		@Override
		public ValidationResult<AdjustableDate2> validate(RosettaPath path, AdjustableDate2 adjustableDate2) {
			ComparisonResult result = executeDataRule(adjustableDate2);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AdjustableDate2", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "AdjustableDate2", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(AdjustableDate2 adjustableDate2) {
			try {
				return choice(MapperS.of(adjustableDate2), Arrays.asList("dateAdjustments", "dateAdjustmentsReference"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AdjustableDate2Choice {
	
		@Override
		public ValidationResult<AdjustableDate2> validate(RosettaPath path, AdjustableDate2 adjustableDate2) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AdjustableDate2", path, DEFINITION);
		}
	}
}
