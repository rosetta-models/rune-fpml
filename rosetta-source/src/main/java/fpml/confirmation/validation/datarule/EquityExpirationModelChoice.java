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
import fpml.confirmation.EquityExpirationModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("EquityExpirationModelChoice")
@ImplementedBy(EquityExpirationModelChoice.Default.class)
public interface EquityExpirationModelChoice extends Validator<EquityExpirationModel> {
	
	String NAME = "EquityExpirationModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<EquityExpirationModel> validate(RosettaPath path, EquityExpirationModel equityExpirationModel);
	
	class Default implements EquityExpirationModelChoice {
	
		@Override
		public ValidationResult<EquityExpirationModel> validate(RosettaPath path, EquityExpirationModel equityExpirationModel) {
			ComparisonResult result = executeDataRule(equityExpirationModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityExpirationModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "EquityExpirationModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(EquityExpirationModel equityExpirationModel) {
			try {
				return choice(MapperS.of(equityExpirationModel), Arrays.asList("equityExpirationModelSequence", "expirationTimeDetermination"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EquityExpirationModelChoice {
	
		@Override
		public ValidationResult<EquityExpirationModel> validate(RosettaPath path, EquityExpirationModel equityExpirationModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityExpirationModel", path, DEFINITION);
		}
	}
}
