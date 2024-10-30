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
import fpml.confirmation.LetterOfCreditDetailsModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("LetterOfCreditDetailsModelChoice")
@ImplementedBy(LetterOfCreditDetailsModelChoice.Default.class)
public interface LetterOfCreditDetailsModelChoice extends Validator<LetterOfCreditDetailsModel> {
	
	String NAME = "LetterOfCreditDetailsModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<LetterOfCreditDetailsModel> validate(RosettaPath path, LetterOfCreditDetailsModel letterOfCreditDetailsModel);
	
	class Default implements LetterOfCreditDetailsModelChoice {
	
		@Override
		public ValidationResult<LetterOfCreditDetailsModel> validate(RosettaPath path, LetterOfCreditDetailsModel letterOfCreditDetailsModel) {
			ComparisonResult result = executeDataRule(letterOfCreditDetailsModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LetterOfCreditDetailsModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "LetterOfCreditDetailsModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(LetterOfCreditDetailsModel letterOfCreditDetailsModel) {
			try {
				return choice(MapperS.of(letterOfCreditDetailsModel), Arrays.asList("letterOfCreditIdentifier", "letterOfCreditSummary", "letterOfCredit"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LetterOfCreditDetailsModelChoice {
	
		@Override
		public ValidationResult<LetterOfCreditDetailsModel> validate(RosettaPath path, LetterOfCreditDetailsModel letterOfCreditDetailsModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LetterOfCreditDetailsModel", path, DEFINITION);
		}
	}
}
