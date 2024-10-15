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
import fpml.confirmation.DeliverableObligations;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("DeliverableObligationsChoice")
@ImplementedBy(DeliverableObligationsChoice.Default.class)
public interface DeliverableObligationsChoice extends Validator<DeliverableObligations> {
	
	String NAME = "DeliverableObligationsChoice";
	String DEFINITION = "optional choice fullFaithAndCreditObLiability, generalFundObligationLiability , revenueObligationLiability";
	
	ValidationResult<DeliverableObligations> validate(RosettaPath path, DeliverableObligations deliverableObligations);
	
	class Default implements DeliverableObligationsChoice {
	
		@Override
		public ValidationResult<DeliverableObligations> validate(RosettaPath path, DeliverableObligations deliverableObligations) {
			ComparisonResult result = executeDataRule(deliverableObligations);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DeliverableObligations", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "DeliverableObligations", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(DeliverableObligations deliverableObligations) {
			try {
				return choice(MapperS.of(deliverableObligations), Arrays.asList("fullFaithAndCreditObLiability", "generalFundObligationLiability", "revenueObligationLiability"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements DeliverableObligationsChoice {
	
		@Override
		public ValidationResult<DeliverableObligations> validate(RosettaPath path, DeliverableObligations deliverableObligations) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DeliverableObligations", path, DEFINITION);
		}
	}
}
