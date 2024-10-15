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
import fpml.confirmation.InstrumentSetSequence;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("InstrumentSetSequenceChoice")
@ImplementedBy(InstrumentSetSequenceChoice.Default.class)
public interface InstrumentSetSequenceChoice extends Validator<InstrumentSetSequence> {
	
	String NAME = "InstrumentSetSequenceChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<InstrumentSetSequence> validate(RosettaPath path, InstrumentSetSequence instrumentSetSequence);
	
	class Default implements InstrumentSetSequenceChoice {
	
		@Override
		public ValidationResult<InstrumentSetSequence> validate(RosettaPath path, InstrumentSetSequence instrumentSetSequence) {
			ComparisonResult result = executeDataRule(instrumentSetSequence);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "InstrumentSetSequence", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "InstrumentSetSequence", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(InstrumentSetSequence instrumentSetSequence) {
			try {
				return choice(MapperS.of(instrumentSetSequence), Arrays.asList("underlyingAsset", "curveInstrument"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements InstrumentSetSequenceChoice {
	
		@Override
		public ValidationResult<InstrumentSetSequence> validate(RosettaPath path, InstrumentSetSequence instrumentSetSequence) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "InstrumentSetSequence", path, DEFINITION);
		}
	}
}
