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
import fpml.confirmation.ReferenceObligation;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("ReferenceObligationChoice0")
@ImplementedBy(ReferenceObligationChoice0.Default.class)
public interface ReferenceObligationChoice0 extends Validator<ReferenceObligation> {
	
	String NAME = "ReferenceObligationChoice0";
	String DEFINITION = "required choice bond, convertibleBond , mortgage , loan";
	
	ValidationResult<ReferenceObligation> validate(RosettaPath path, ReferenceObligation referenceObligation);
	
	class Default implements ReferenceObligationChoice0 {
	
		@Override
		public ValidationResult<ReferenceObligation> validate(RosettaPath path, ReferenceObligation referenceObligation) {
			ComparisonResult result = executeDataRule(referenceObligation);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ReferenceObligation", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "ReferenceObligation", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(ReferenceObligation referenceObligation) {
			try {
				return choice(MapperS.of(referenceObligation), Arrays.asList("bond", "convertibleBond", "mortgage", "loan"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ReferenceObligationChoice0 {
	
		@Override
		public ValidationResult<ReferenceObligation> validate(RosettaPath path, ReferenceObligation referenceObligation) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ReferenceObligation", path, DEFINITION);
		}
	}
}
