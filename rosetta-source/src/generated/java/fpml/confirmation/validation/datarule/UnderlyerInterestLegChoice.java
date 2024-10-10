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
import fpml.confirmation.UnderlyerInterestLeg;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("UnderlyerInterestLegChoice")
@ImplementedBy(UnderlyerInterestLegChoice.Default.class)
public interface UnderlyerInterestLegChoice extends Validator<UnderlyerInterestLeg> {
	
	String NAME = "UnderlyerInterestLegChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<UnderlyerInterestLeg> validate(RosettaPath path, UnderlyerInterestLeg underlyerInterestLeg);
	
	class Default implements UnderlyerInterestLegChoice {
	
		@Override
		public ValidationResult<UnderlyerInterestLeg> validate(RosettaPath path, UnderlyerInterestLeg underlyerInterestLeg) {
			ComparisonResult result = executeDataRule(underlyerInterestLeg);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "UnderlyerInterestLeg", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "UnderlyerInterestLeg", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(UnderlyerInterestLeg underlyerInterestLeg) {
			try {
				return choice(MapperS.of(underlyerInterestLeg), Arrays.asList("id", "legIdentifier", "payerReceiverModel", "effectiveDate", "terminationDate", "fixedRate", "spreadSchedule"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements UnderlyerInterestLegChoice {
	
		@Override
		public ValidationResult<UnderlyerInterestLeg> validate(RosettaPath path, UnderlyerInterestLeg underlyerInterestLeg) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "UnderlyerInterestLeg", path, DEFINITION);
		}
	}
}
