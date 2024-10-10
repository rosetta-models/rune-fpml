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
import fpml.confirmation.TimeDimension;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("TimeDimensionChoice")
@ImplementedBy(TimeDimensionChoice.Default.class)
public interface TimeDimensionChoice extends Validator<TimeDimension> {
	
	String NAME = "TimeDimensionChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<TimeDimension> validate(RosettaPath path, TimeDimension timeDimension);
	
	class Default implements TimeDimensionChoice {
	
		@Override
		public ValidationResult<TimeDimension> validate(RosettaPath path, TimeDimension timeDimension) {
			ComparisonResult result = executeDataRule(timeDimension);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TimeDimension", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "TimeDimension", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(TimeDimension timeDimension) {
			try {
				return choice(MapperS.of(timeDimension), Arrays.asList("tenor", "timeDimensionSequence"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TimeDimensionChoice {
	
		@Override
		public ValidationResult<TimeDimension> validate(RosettaPath path, TimeDimension timeDimension) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TimeDimension", path, DEFINITION);
		}
	}
}
