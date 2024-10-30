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
import fpml.confirmation.PaymentDetail;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("PaymentDetailChoice")
@ImplementedBy(PaymentDetailChoice.Default.class)
public interface PaymentDetailChoice extends Validator<PaymentDetail> {
	
	String NAME = "PaymentDetailChoice";
	String DEFINITION = "required choice paymentAmount, paymentDetailSequence";
	
	ValidationResult<PaymentDetail> validate(RosettaPath path, PaymentDetail paymentDetail);
	
	class Default implements PaymentDetailChoice {
	
		@Override
		public ValidationResult<PaymentDetail> validate(RosettaPath path, PaymentDetail paymentDetail) {
			ComparisonResult result = executeDataRule(paymentDetail);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PaymentDetail", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "PaymentDetail", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(PaymentDetail paymentDetail) {
			try {
				return choice(MapperS.of(paymentDetail), Arrays.asList("paymentAmount", "paymentDetailSequence"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PaymentDetailChoice {
	
		@Override
		public ValidationResult<PaymentDetail> validate(RosettaPath path, PaymentDetail paymentDetail) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PaymentDetail", path, DEFINITION);
		}
	}
}
