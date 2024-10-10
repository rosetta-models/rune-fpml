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
import fpml.confirmation.FxCoreDetailsModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("FxCoreDetailsModelChoice")
@ImplementedBy(FxCoreDetailsModelChoice.Default.class)
public interface FxCoreDetailsModelChoice extends Validator<FxCoreDetailsModel> {
	
	String NAME = "FxCoreDetailsModelChoice";
	String DEFINITION = "required choice valueDate, fxCoreDetailsModelSequence";
	
	ValidationResult<FxCoreDetailsModel> validate(RosettaPath path, FxCoreDetailsModel fxCoreDetailsModel);
	
	class Default implements FxCoreDetailsModelChoice {
	
		@Override
		public ValidationResult<FxCoreDetailsModel> validate(RosettaPath path, FxCoreDetailsModel fxCoreDetailsModel) {
			ComparisonResult result = executeDataRule(fxCoreDetailsModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxCoreDetailsModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxCoreDetailsModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxCoreDetailsModel fxCoreDetailsModel) {
			try {
				return choice(MapperS.of(fxCoreDetailsModel), Arrays.asList("valueDate", "fxCoreDetailsModelSequence"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxCoreDetailsModelChoice {
	
		@Override
		public ValidationResult<FxCoreDetailsModel> validate(RosettaPath path, FxCoreDetailsModel fxCoreDetailsModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxCoreDetailsModel", path, DEFINITION);
		}
	}
}
