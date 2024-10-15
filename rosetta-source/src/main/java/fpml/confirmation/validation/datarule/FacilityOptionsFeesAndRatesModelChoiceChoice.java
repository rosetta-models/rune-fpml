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
import fpml.confirmation.FacilityOptionsFeesAndRatesModelChoice;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("FacilityOptionsFeesAndRatesModelChoiceChoice")
@ImplementedBy(FacilityOptionsFeesAndRatesModelChoiceChoice.Default.class)
public interface FacilityOptionsFeesAndRatesModelChoiceChoice extends Validator<FacilityOptionsFeesAndRatesModelChoice> {
	
	String NAME = "FacilityOptionsFeesAndRatesModelChoiceChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<FacilityOptionsFeesAndRatesModelChoice> validate(RosettaPath path, FacilityOptionsFeesAndRatesModelChoice facilityOptionsFeesAndRatesModelChoice);
	
	class Default implements FacilityOptionsFeesAndRatesModelChoiceChoice {
	
		@Override
		public ValidationResult<FacilityOptionsFeesAndRatesModelChoice> validate(RosettaPath path, FacilityOptionsFeesAndRatesModelChoice facilityOptionsFeesAndRatesModelChoice) {
			ComparisonResult result = executeDataRule(facilityOptionsFeesAndRatesModelChoice);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FacilityOptionsFeesAndRatesModelChoice", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FacilityOptionsFeesAndRatesModelChoice", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FacilityOptionsFeesAndRatesModelChoice facilityOptionsFeesAndRatesModelChoice) {
			try {
				return choice(MapperS.of(facilityOptionsFeesAndRatesModelChoice), Arrays.asList("fixedRateOption", "floatingRateOption", "lcOption"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FacilityOptionsFeesAndRatesModelChoiceChoice {
	
		@Override
		public ValidationResult<FacilityOptionsFeesAndRatesModelChoice> validate(RosettaPath path, FacilityOptionsFeesAndRatesModelChoice facilityOptionsFeesAndRatesModelChoice) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FacilityOptionsFeesAndRatesModelChoice", path, DEFINITION);
		}
	}
}
