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
import fpml.confirmation.LagOrReferenceModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("LagOrReferenceModelChoice")
@ImplementedBy(LagOrReferenceModelChoice.Default.class)
public interface LagOrReferenceModelChoice extends Validator<LagOrReferenceModel> {
	
	String NAME = "LagOrReferenceModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<LagOrReferenceModel> validate(RosettaPath path, LagOrReferenceModel lagOrReferenceModel);
	
	class Default implements LagOrReferenceModelChoice {
	
		@Override
		public ValidationResult<LagOrReferenceModel> validate(RosettaPath path, LagOrReferenceModel lagOrReferenceModel) {
			ComparisonResult result = executeDataRule(lagOrReferenceModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LagOrReferenceModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "LagOrReferenceModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(LagOrReferenceModel lagOrReferenceModel) {
			try {
				return choice(MapperS.of(lagOrReferenceModel), Arrays.asList("lag", "lagReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LagOrReferenceModelChoice {
	
		@Override
		public ValidationResult<LagOrReferenceModel> validate(RosettaPath path, LagOrReferenceModel lagOrReferenceModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LagOrReferenceModel", path, DEFINITION);
		}
	}
}
