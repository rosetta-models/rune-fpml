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
import fpml.confirmation.EquityOptionTransactionSupplement;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("EquityOptionTransactionSupplementChoice")
@ImplementedBy(EquityOptionTransactionSupplementChoice.Default.class)
public interface EquityOptionTransactionSupplementChoice extends Validator<EquityOptionTransactionSupplement> {
	
	String NAME = "EquityOptionTransactionSupplementChoice";
	String DEFINITION = "optional choice optionEntitlement, multiplier";
	
	ValidationResult<EquityOptionTransactionSupplement> validate(RosettaPath path, EquityOptionTransactionSupplement equityOptionTransactionSupplement);
	
	class Default implements EquityOptionTransactionSupplementChoice {
	
		@Override
		public ValidationResult<EquityOptionTransactionSupplement> validate(RosettaPath path, EquityOptionTransactionSupplement equityOptionTransactionSupplement) {
			ComparisonResult result = executeDataRule(equityOptionTransactionSupplement);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityOptionTransactionSupplement", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "EquityOptionTransactionSupplement", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(EquityOptionTransactionSupplement equityOptionTransactionSupplement) {
			try {
				return choice(MapperS.of(equityOptionTransactionSupplement), Arrays.asList("optionEntitlement", "multiplier"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EquityOptionTransactionSupplementChoice {
	
		@Override
		public ValidationResult<EquityOptionTransactionSupplement> validate(RosettaPath path, EquityOptionTransactionSupplement equityOptionTransactionSupplement) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityOptionTransactionSupplement", path, DEFINITION);
		}
	}
}
