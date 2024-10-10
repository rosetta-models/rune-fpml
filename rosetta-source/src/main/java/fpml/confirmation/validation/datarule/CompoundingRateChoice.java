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
import fpml.confirmation.CompoundingRate;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("CompoundingRateChoice")
@ImplementedBy(CompoundingRateChoice.Default.class)
public interface CompoundingRateChoice extends Validator<CompoundingRate> {
	
	String NAME = "CompoundingRateChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<CompoundingRate> validate(RosettaPath path, CompoundingRate compoundingRate);
	
	class Default implements CompoundingRateChoice {
	
		@Override
		public ValidationResult<CompoundingRate> validate(RosettaPath path, CompoundingRate compoundingRate) {
			ComparisonResult result = executeDataRule(compoundingRate);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CompoundingRate", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CompoundingRate", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CompoundingRate compoundingRate) {
			try {
				return choice(MapperS.of(compoundingRate), Arrays.asList("interestLegRate", "specificRate"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CompoundingRateChoice {
	
		@Override
		public ValidationResult<CompoundingRate> validate(RosettaPath path, CompoundingRate compoundingRate) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CompoundingRate", path, DEFINITION);
		}
	}
}
