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
import fpml.confirmation.Documentation;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("DocumentationChoice")
@ImplementedBy(DocumentationChoice.Default.class)
public interface DocumentationChoice extends Validator<Documentation> {
	
	String NAME = "DocumentationChoice";
	String DEFINITION = "optional choice masterConfirmation, brokerConfirmation";
	
	ValidationResult<Documentation> validate(RosettaPath path, Documentation documentation);
	
	class Default implements DocumentationChoice {
	
		@Override
		public ValidationResult<Documentation> validate(RosettaPath path, Documentation documentation) {
			ComparisonResult result = executeDataRule(documentation);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Documentation", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "Documentation", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(Documentation documentation) {
			try {
				return choice(MapperS.of(documentation), Arrays.asList("masterConfirmation", "brokerConfirmation"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements DocumentationChoice {
	
		@Override
		public ValidationResult<Documentation> validate(RosettaPath path, Documentation documentation) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Documentation", path, DEFINITION);
		}
	}
}
