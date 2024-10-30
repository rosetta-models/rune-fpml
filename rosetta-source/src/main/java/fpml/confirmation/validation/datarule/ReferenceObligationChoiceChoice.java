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
import fpml.confirmation.ReferenceObligationChoice;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("ReferenceObligationChoiceChoice")
@ImplementedBy(ReferenceObligationChoiceChoice.Default.class)
public interface ReferenceObligationChoiceChoice extends Validator<ReferenceObligationChoice> {
	
	String NAME = "ReferenceObligationChoiceChoice";
	String DEFINITION = "optional choice guarantor, guarantorReference";
	
	ValidationResult<ReferenceObligationChoice> validate(RosettaPath path, ReferenceObligationChoice referenceObligationChoice);
	
	class Default implements ReferenceObligationChoiceChoice {
	
		@Override
		public ValidationResult<ReferenceObligationChoice> validate(RosettaPath path, ReferenceObligationChoice referenceObligationChoice) {
			ComparisonResult result = executeDataRule(referenceObligationChoice);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ReferenceObligationChoice", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "ReferenceObligationChoice", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(ReferenceObligationChoice referenceObligationChoice) {
			try {
				return choice(MapperS.of(referenceObligationChoice), Arrays.asList("guarantor", "guarantorReference"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ReferenceObligationChoiceChoice {
	
		@Override
		public ValidationResult<ReferenceObligationChoice> validate(RosettaPath path, ReferenceObligationChoice referenceObligationChoice) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ReferenceObligationChoice", path, DEFINITION);
		}
	}
}
