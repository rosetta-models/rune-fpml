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
import fpml.confirmation.CoalAttributeDecimal;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CoalAttributeDecimalChoice")
@ImplementedBy(CoalAttributeDecimalChoice.Default.class)
public interface CoalAttributeDecimalChoice extends Validator<CoalAttributeDecimal> {
	
	String NAME = "CoalAttributeDecimalChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<CoalAttributeDecimal> validate(RosettaPath path, CoalAttributeDecimal coalAttributeDecimal);
	
	class Default implements CoalAttributeDecimalChoice {
	
		@Override
		public ValidationResult<CoalAttributeDecimal> validate(RosettaPath path, CoalAttributeDecimal coalAttributeDecimal) {
			ComparisonResult result = executeDataRule(coalAttributeDecimal);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CoalAttributeDecimal", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CoalAttributeDecimal", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CoalAttributeDecimal coalAttributeDecimal) {
			try {
				return choice(MapperS.of(coalAttributeDecimal), Arrays.asList("coalAttributeDecimalSequence0", "coalAttributeDecimalSequence1"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CoalAttributeDecimalChoice {
	
		@Override
		public ValidationResult<CoalAttributeDecimal> validate(RosettaPath path, CoalAttributeDecimal coalAttributeDecimal) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CoalAttributeDecimal", path, DEFINITION);
		}
	}
}
