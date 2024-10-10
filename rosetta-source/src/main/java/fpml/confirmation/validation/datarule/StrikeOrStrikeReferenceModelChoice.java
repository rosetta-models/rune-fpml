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
import fpml.confirmation.StrikeOrStrikeReferenceModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("StrikeOrStrikeReferenceModelChoice")
@ImplementedBy(StrikeOrStrikeReferenceModelChoice.Default.class)
public interface StrikeOrStrikeReferenceModelChoice extends Validator<StrikeOrStrikeReferenceModel> {
	
	String NAME = "StrikeOrStrikeReferenceModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<StrikeOrStrikeReferenceModel> validate(RosettaPath path, StrikeOrStrikeReferenceModel strikeOrStrikeReferenceModel);
	
	class Default implements StrikeOrStrikeReferenceModelChoice {
	
		@Override
		public ValidationResult<StrikeOrStrikeReferenceModel> validate(RosettaPath path, StrikeOrStrikeReferenceModel strikeOrStrikeReferenceModel) {
			ComparisonResult result = executeDataRule(strikeOrStrikeReferenceModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "StrikeOrStrikeReferenceModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "StrikeOrStrikeReferenceModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(StrikeOrStrikeReferenceModel strikeOrStrikeReferenceModel) {
			try {
				return choice(MapperS.of(strikeOrStrikeReferenceModel), Arrays.asList("strike", "strikeReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements StrikeOrStrikeReferenceModelChoice {
	
		@Override
		public ValidationResult<StrikeOrStrikeReferenceModel> validate(RosettaPath path, StrikeOrStrikeReferenceModel strikeOrStrikeReferenceModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "StrikeOrStrikeReferenceModel", path, DEFINITION);
		}
	}
}
