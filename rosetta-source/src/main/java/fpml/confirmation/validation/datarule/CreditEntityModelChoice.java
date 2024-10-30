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
import fpml.confirmation.CreditEntityModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CreditEntityModelChoice")
@ImplementedBy(CreditEntityModelChoice.Default.class)
public interface CreditEntityModelChoice extends Validator<CreditEntityModel> {
	
	String NAME = "CreditEntityModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<CreditEntityModel> validate(RosettaPath path, CreditEntityModel creditEntityModel);
	
	class Default implements CreditEntityModelChoice {
	
		@Override
		public ValidationResult<CreditEntityModel> validate(RosettaPath path, CreditEntityModel creditEntityModel) {
			ComparisonResult result = executeDataRule(creditEntityModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditEntityModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CreditEntityModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CreditEntityModel creditEntityModel) {
			try {
				return choice(MapperS.of(creditEntityModel), Arrays.asList("referenceEntity", "creditEntityReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CreditEntityModelChoice {
	
		@Override
		public ValidationResult<CreditEntityModel> validate(RosettaPath path, CreditEntityModel creditEntityModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CreditEntityModel", path, DEFINITION);
		}
	}
}
