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
import fpml.confirmation.CoalAttributePercentage;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CoalAttributePercentageChoice")
@ImplementedBy(CoalAttributePercentageChoice.Default.class)
public interface CoalAttributePercentageChoice extends Validator<CoalAttributePercentage> {
	
	String NAME = "CoalAttributePercentageChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<CoalAttributePercentage> validate(RosettaPath path, CoalAttributePercentage coalAttributePercentage);
	
	class Default implements CoalAttributePercentageChoice {
	
		@Override
		public ValidationResult<CoalAttributePercentage> validate(RosettaPath path, CoalAttributePercentage coalAttributePercentage) {
			ComparisonResult result = executeDataRule(coalAttributePercentage);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CoalAttributePercentage", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CoalAttributePercentage", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CoalAttributePercentage coalAttributePercentage) {
			try {
				return choice(MapperS.of(coalAttributePercentage), Arrays.asList("coalAttributePercentageSequence0", "coalAttributePercentageSequence1"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CoalAttributePercentageChoice {
	
		@Override
		public ValidationResult<CoalAttributePercentage> validate(RosettaPath path, CoalAttributePercentage coalAttributePercentage) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CoalAttributePercentage", path, DEFINITION);
		}
	}
}
