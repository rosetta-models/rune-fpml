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
import fpml.confirmation.BasketReferenceInformation;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("BasketReferenceInformationChoice")
@ImplementedBy(BasketReferenceInformationChoice.Default.class)
public interface BasketReferenceInformationChoice extends Validator<BasketReferenceInformation> {
	
	String NAME = "BasketReferenceInformationChoice";
	String DEFINITION = "optional choice basketReferenceInformationSequence, tranche";
	
	ValidationResult<BasketReferenceInformation> validate(RosettaPath path, BasketReferenceInformation basketReferenceInformation);
	
	class Default implements BasketReferenceInformationChoice {
	
		@Override
		public ValidationResult<BasketReferenceInformation> validate(RosettaPath path, BasketReferenceInformation basketReferenceInformation) {
			ComparisonResult result = executeDataRule(basketReferenceInformation);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "BasketReferenceInformation", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "BasketReferenceInformation", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(BasketReferenceInformation basketReferenceInformation) {
			try {
				return choice(MapperS.of(basketReferenceInformation), Arrays.asList("basketReferenceInformationSequence", "tranche"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements BasketReferenceInformationChoice {
	
		@Override
		public ValidationResult<BasketReferenceInformation> validate(RosettaPath path, BasketReferenceInformation basketReferenceInformation) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "BasketReferenceInformation", path, DEFINITION);
		}
	}
}
