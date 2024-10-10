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
import fpml.confirmation.BondOptionStrike;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("BondOptionStrikeChoice")
@ImplementedBy(BondOptionStrikeChoice.Default.class)
public interface BondOptionStrikeChoice extends Validator<BondOptionStrike> {
	
	String NAME = "BondOptionStrikeChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<BondOptionStrike> validate(RosettaPath path, BondOptionStrike bondOptionStrike);
	
	class Default implements BondOptionStrikeChoice {
	
		@Override
		public ValidationResult<BondOptionStrike> validate(RosettaPath path, BondOptionStrike bondOptionStrike) {
			ComparisonResult result = executeDataRule(bondOptionStrike);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "BondOptionStrike", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "BondOptionStrike", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(BondOptionStrike bondOptionStrike) {
			try {
				return choice(MapperS.of(bondOptionStrike), Arrays.asList("referenceSwapCurve", "price"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements BondOptionStrikeChoice {
	
		@Override
		public ValidationResult<BondOptionStrike> validate(RosettaPath path, BondOptionStrike bondOptionStrike) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "BondOptionStrike", path, DEFINITION);
		}
	}
}
