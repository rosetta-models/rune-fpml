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
import fpml.confirmation.DividendPaymentDate;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("DividendPaymentDateChoice")
@ImplementedBy(DividendPaymentDateChoice.Default.class)
public interface DividendPaymentDateChoice extends Validator<DividendPaymentDate> {
	
	String NAME = "DividendPaymentDateChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<DividendPaymentDate> validate(RosettaPath path, DividendPaymentDate dividendPaymentDate);
	
	class Default implements DividendPaymentDateChoice {
	
		@Override
		public ValidationResult<DividendPaymentDate> validate(RosettaPath path, DividendPaymentDate dividendPaymentDate) {
			ComparisonResult result = executeDataRule(dividendPaymentDate);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DividendPaymentDate", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "DividendPaymentDate", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(DividendPaymentDate dividendPaymentDate) {
			try {
				return choice(MapperS.of(dividendPaymentDate), Arrays.asList("dividendPaymentDateSequence", "adjustableDate"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements DividendPaymentDateChoice {
	
		@Override
		public ValidationResult<DividendPaymentDate> validate(RosettaPath path, DividendPaymentDate dividendPaymentDate) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DividendPaymentDate", path, DEFINITION);
		}
	}
}
