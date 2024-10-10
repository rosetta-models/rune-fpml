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
import fpml.confirmation.ReferencePair;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("ReferencePairChoice")
@ImplementedBy(ReferencePairChoice.Default.class)
public interface ReferencePairChoice extends Validator<ReferencePair> {
	
	String NAME = "ReferencePairChoice";
	String DEFINITION = "required choice referenceObligation, noReferenceObligation";
	
	ValidationResult<ReferencePair> validate(RosettaPath path, ReferencePair referencePair);
	
	class Default implements ReferencePairChoice {
	
		@Override
		public ValidationResult<ReferencePair> validate(RosettaPath path, ReferencePair referencePair) {
			ComparisonResult result = executeDataRule(referencePair);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ReferencePair", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "ReferencePair", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(ReferencePair referencePair) {
			try {
				return choice(MapperS.of(referencePair), Arrays.asList("referenceObligation", "noReferenceObligation"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ReferencePairChoice {
	
		@Override
		public ValidationResult<ReferencePair> validate(RosettaPath path, ReferencePair referencePair) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ReferencePair", path, DEFINITION);
		}
	}
}
