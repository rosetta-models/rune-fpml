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
import fpml.confirmation.CompressionActivity;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CompressionActivityChoice")
@ImplementedBy(CompressionActivityChoice.Default.class)
public interface CompressionActivityChoice extends Validator<CompressionActivity> {
	
	String NAME = "CompressionActivityChoice";
	String DEFINITION = "required choice compressionActivitySequence0, compressionActivitySequence1";
	
	ValidationResult<CompressionActivity> validate(RosettaPath path, CompressionActivity compressionActivity);
	
	class Default implements CompressionActivityChoice {
	
		@Override
		public ValidationResult<CompressionActivity> validate(RosettaPath path, CompressionActivity compressionActivity) {
			ComparisonResult result = executeDataRule(compressionActivity);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CompressionActivity", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CompressionActivity", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CompressionActivity compressionActivity) {
			try {
				return choice(MapperS.of(compressionActivity), Arrays.asList("compressionActivitySequence0", "compressionActivitySequence1"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CompressionActivityChoice {
	
		@Override
		public ValidationResult<CompressionActivity> validate(RosettaPath path, CompressionActivity compressionActivity) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CompressionActivity", path, DEFINITION);
		}
	}
}
