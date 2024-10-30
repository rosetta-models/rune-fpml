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
import fpml.confirmation.OptionBaseExtended;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("OptionBaseExtendedChoice")
@ImplementedBy(OptionBaseExtendedChoice.Default.class)
public interface OptionBaseExtendedChoice extends Validator<OptionBaseExtended> {
	
	String NAME = "OptionBaseExtendedChoice";
	String DEFINITION = "optional choice notionalReference, notionalAmount";
	
	ValidationResult<OptionBaseExtended> validate(RosettaPath path, OptionBaseExtended optionBaseExtended);
	
	class Default implements OptionBaseExtendedChoice {
	
		@Override
		public ValidationResult<OptionBaseExtended> validate(RosettaPath path, OptionBaseExtended optionBaseExtended) {
			ComparisonResult result = executeDataRule(optionBaseExtended);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionBaseExtended", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "OptionBaseExtended", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(OptionBaseExtended optionBaseExtended) {
			try {
				return choice(MapperS.of(optionBaseExtended), Arrays.asList("notionalReference", "notionalAmount"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OptionBaseExtendedChoice {
	
		@Override
		public ValidationResult<OptionBaseExtended> validate(RosettaPath path, OptionBaseExtended optionBaseExtended) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OptionBaseExtended", path, DEFINITION);
		}
	}
}
