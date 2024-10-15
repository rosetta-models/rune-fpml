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
import fpml.confirmation.NovationAmountsOldModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("NovationAmountsOldModelChoice")
@ImplementedBy(NovationAmountsOldModelChoice.Default.class)
public interface NovationAmountsOldModelChoice extends Validator<NovationAmountsOldModel> {
	
	String NAME = "NovationAmountsOldModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<NovationAmountsOldModel> validate(RosettaPath path, NovationAmountsOldModel novationAmountsOldModel);
	
	class Default implements NovationAmountsOldModelChoice {
	
		@Override
		public ValidationResult<NovationAmountsOldModel> validate(RosettaPath path, NovationAmountsOldModel novationAmountsOldModel) {
			ComparisonResult result = executeDataRule(novationAmountsOldModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "NovationAmountsOldModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "NovationAmountsOldModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(NovationAmountsOldModel novationAmountsOldModel) {
			try {
				return choice(MapperS.of(novationAmountsOldModel), Arrays.asList("novationAmountsOldModelSequence0", "novationAmountsOldModelSequence1", "novationAmountsOldModelSequence2"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements NovationAmountsOldModelChoice {
	
		@Override
		public ValidationResult<NovationAmountsOldModel> validate(RosettaPath path, NovationAmountsOldModel novationAmountsOldModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "NovationAmountsOldModel", path, DEFINITION);
		}
	}
}
