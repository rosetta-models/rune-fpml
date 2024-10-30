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
import fpml.confirmation.Resource;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("ResourceChoice")
@ImplementedBy(ResourceChoice.Default.class)
public interface ResourceChoice extends Validator<Resource> {
	
	String NAME = "ResourceChoice";
	String DEFINITION = "optional choice string, hexadecimalBinary , base64Binary , url";
	
	ValidationResult<Resource> validate(RosettaPath path, Resource resource);
	
	class Default implements ResourceChoice {
	
		@Override
		public ValidationResult<Resource> validate(RosettaPath path, Resource resource) {
			ComparisonResult result = executeDataRule(resource);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Resource", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "Resource", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(Resource resource) {
			try {
				return choice(MapperS.of(resource), Arrays.asList("string", "hexadecimalBinary", "base64Binary", "url"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ResourceChoice {
	
		@Override
		public ValidationResult<Resource> validate(RosettaPath path, Resource resource) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Resource", path, DEFINITION);
		}
	}
}
