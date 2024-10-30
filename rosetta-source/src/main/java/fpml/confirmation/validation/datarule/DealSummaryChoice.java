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
import fpml.confirmation.DealSummary;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("DealSummaryChoice")
@ImplementedBy(DealSummaryChoice.Default.class)
public interface DealSummaryChoice extends Validator<DealSummary> {
	
	String NAME = "DealSummaryChoice";
	String DEFINITION = "optional choice currency, dealSummarySequence";
	
	ValidationResult<DealSummary> validate(RosettaPath path, DealSummary dealSummary);
	
	class Default implements DealSummaryChoice {
	
		@Override
		public ValidationResult<DealSummary> validate(RosettaPath path, DealSummary dealSummary) {
			ComparisonResult result = executeDataRule(dealSummary);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DealSummary", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "DealSummary", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(DealSummary dealSummary) {
			try {
				return choice(MapperS.of(dealSummary), Arrays.asList("currency", "dealSummarySequence"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements DealSummaryChoice {
	
		@Override
		public ValidationResult<DealSummary> validate(RosettaPath path, DealSummary dealSummary) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "DealSummary", path, DEFINITION);
		}
	}
}
