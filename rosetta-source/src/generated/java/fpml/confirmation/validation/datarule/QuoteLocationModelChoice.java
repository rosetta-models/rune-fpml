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
import fpml.confirmation.QuoteLocationModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("QuoteLocationModelChoice")
@ImplementedBy(QuoteLocationModelChoice.Default.class)
public interface QuoteLocationModelChoice extends Validator<QuoteLocationModel> {
	
	String NAME = "QuoteLocationModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<QuoteLocationModel> validate(RosettaPath path, QuoteLocationModel quoteLocationModel);
	
	class Default implements QuoteLocationModelChoice {
	
		@Override
		public ValidationResult<QuoteLocationModel> validate(RosettaPath path, QuoteLocationModel quoteLocationModel) {
			ComparisonResult result = executeDataRule(quoteLocationModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "QuoteLocationModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "QuoteLocationModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(QuoteLocationModel quoteLocationModel) {
			try {
				return choice(MapperS.of(quoteLocationModel), Arrays.asList("businessCenter", "exchangeId"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements QuoteLocationModelChoice {
	
		@Override
		public ValidationResult<QuoteLocationModel> validate(RosettaPath path, QuoteLocationModel quoteLocationModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "QuoteLocationModel", path, DEFINITION);
		}
	}
}
