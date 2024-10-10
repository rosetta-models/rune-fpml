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
import fpml.confirmation.OutstandingsPosition;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("OutstandingsPositionChoice")
@ImplementedBy(OutstandingsPositionChoice.Default.class)
public interface OutstandingsPositionChoice extends Validator<OutstandingsPosition> {
	
	String NAME = "OutstandingsPositionChoice";
	String DEFINITION = "required choice loanContractReference, letterOfCreditReference";
	
	ValidationResult<OutstandingsPosition> validate(RosettaPath path, OutstandingsPosition outstandingsPosition);
	
	class Default implements OutstandingsPositionChoice {
	
		@Override
		public ValidationResult<OutstandingsPosition> validate(RosettaPath path, OutstandingsPosition outstandingsPosition) {
			ComparisonResult result = executeDataRule(outstandingsPosition);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OutstandingsPosition", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "OutstandingsPosition", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(OutstandingsPosition outstandingsPosition) {
			try {
				return choice(MapperS.of(outstandingsPosition), Arrays.asList("loanContractReference", "letterOfCreditReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OutstandingsPositionChoice {
	
		@Override
		public ValidationResult<OutstandingsPosition> validate(RosettaPath path, OutstandingsPosition outstandingsPosition) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OutstandingsPosition", path, DEFINITION);
		}
	}
}
