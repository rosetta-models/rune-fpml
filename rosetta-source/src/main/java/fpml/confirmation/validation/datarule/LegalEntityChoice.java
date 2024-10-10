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
import fpml.confirmation.LegalEntity;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("LegalEntityChoice")
@ImplementedBy(LegalEntityChoice.Default.class)
public interface LegalEntityChoice extends Validator<LegalEntity> {
	
	String NAME = "LegalEntityChoice";
	String DEFINITION = "required choice legalEntitySequence, entityId";
	
	ValidationResult<LegalEntity> validate(RosettaPath path, LegalEntity legalEntity);
	
	class Default implements LegalEntityChoice {
	
		@Override
		public ValidationResult<LegalEntity> validate(RosettaPath path, LegalEntity legalEntity) {
			ComparisonResult result = executeDataRule(legalEntity);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LegalEntity", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "LegalEntity", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(LegalEntity legalEntity) {
			try {
				return choice(MapperS.of(legalEntity), Arrays.asList("legalEntitySequence", "entityId"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LegalEntityChoice {
	
		@Override
		public ValidationResult<LegalEntity> validate(RosettaPath path, LegalEntity legalEntity) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LegalEntity", path, DEFINITION);
		}
	}
}
