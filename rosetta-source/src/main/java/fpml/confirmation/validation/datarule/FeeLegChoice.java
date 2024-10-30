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
import fpml.confirmation.FeeLeg;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("FeeLegChoice")
@ImplementedBy(FeeLegChoice.Default.class)
public interface FeeLegChoice extends Validator<FeeLeg> {
	
	String NAME = "FeeLegChoice";
	String DEFINITION = "required choice feeLegChoice, periodicPayment";
	
	ValidationResult<FeeLeg> validate(RosettaPath path, FeeLeg feeLeg);
	
	class Default implements FeeLegChoice {
	
		@Override
		public ValidationResult<FeeLeg> validate(RosettaPath path, FeeLeg feeLeg) {
			ComparisonResult result = executeDataRule(feeLeg);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FeeLeg", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FeeLeg", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FeeLeg feeLeg) {
			try {
				return choice(MapperS.of(feeLeg), Arrays.asList("feeLegChoice", "periodicPayment"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FeeLegChoice {
	
		@Override
		public ValidationResult<FeeLeg> validate(RosettaPath path, FeeLeg feeLeg) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FeeLeg", path, DEFINITION);
		}
	}
}
