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
import fpml.confirmation.OptionExpiry;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("OptionExpiryChoice")
@ImplementedBy(OptionExpiryChoice.Default.class)
public interface OptionExpiryChoice extends Validator<OptionExpiry> {
	
	String NAME = "OptionExpiryChoice";
	String DEFINITION = "required choice originalTrade, tradeIdentifier";
	
	ValidationResult<OptionExpiry> validate(RosettaPath path, OptionExpiry optionExpiry);
	
	class Default implements OptionExpiryChoice {
	
		@Override
		public ValidationResult<OptionExpiry> validate(RosettaPath path, OptionExpiry optionExpiry) {
			ComparisonResult result = executeDataRule(optionExpiry);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionExpiry", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "OptionExpiry", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(OptionExpiry optionExpiry) {
			try {
				return choice(MapperS.of(optionExpiry), Arrays.asList("originalTrade", "tradeIdentifier"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OptionExpiryChoice {
	
		@Override
		public ValidationResult<OptionExpiry> validate(RosettaPath path, OptionExpiry optionExpiry) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionExpiry", path, DEFINITION);
		}
	}
}
