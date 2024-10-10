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
import fpml.confirmation.ClearingResultsModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("ClearingResultsModelChoice")
@ImplementedBy(ClearingResultsModelChoice.Default.class)
public interface ClearingResultsModelChoice extends Validator<ClearingResultsModel> {
	
	String NAME = "ClearingResultsModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<ClearingResultsModel> validate(RosettaPath path, ClearingResultsModel clearingResultsModel);
	
	class Default implements ClearingResultsModelChoice {
	
		@Override
		public ValidationResult<ClearingResultsModel> validate(RosettaPath path, ClearingResultsModel clearingResultsModel) {
			ComparisonResult result = executeDataRule(clearingResultsModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ClearingResultsModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "ClearingResultsModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(ClearingResultsModel clearingResultsModel) {
			try {
				return choice(MapperS.of(clearingResultsModel), Arrays.asList("tradingEventsModel", "clearingResultsModelSequence", "deClear", "clearing"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ClearingResultsModelChoice {
	
		@Override
		public ValidationResult<ClearingResultsModel> validate(RosettaPath path, ClearingResultsModel clearingResultsModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ClearingResultsModel", path, DEFINITION);
		}
	}
}
