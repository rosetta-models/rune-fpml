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
import fpml.confirmation.PGPDataType;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("PGPDataTypeChoice")
@ImplementedBy(PGPDataTypeChoice.Default.class)
public interface PGPDataTypeChoice extends Validator<PGPDataType> {
	
	String NAME = "PGPDataTypeChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<PGPDataType> validate(RosettaPath path, PGPDataType pGPDataType);
	
	class Default implements PGPDataTypeChoice {
	
		@Override
		public ValidationResult<PGPDataType> validate(RosettaPath path, PGPDataType pGPDataType) {
			ComparisonResult result = executeDataRule(pGPDataType);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PGPDataType", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "PGPDataType", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(PGPDataType pGPDataType) {
			try {
				return choice(MapperS.of(pGPDataType), Arrays.asList("pgpDataTypeSequence0", "pgpDataTypeSequence1"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PGPDataTypeChoice {
	
		@Override
		public ValidationResult<PGPDataType> validate(RosettaPath path, PGPDataType pGPDataType) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PGPDataType", path, DEFINITION);
		}
	}
}
