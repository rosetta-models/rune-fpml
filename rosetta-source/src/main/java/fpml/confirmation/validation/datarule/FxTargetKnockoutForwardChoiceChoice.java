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
import fpml.confirmation.FxTargetKnockoutForwardChoice;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("FxTargetKnockoutForwardChoiceChoice")
@ImplementedBy(FxTargetKnockoutForwardChoiceChoice.Default.class)
public interface FxTargetKnockoutForwardChoiceChoice extends Validator<FxTargetKnockoutForwardChoice> {
	
	String NAME = "FxTargetKnockoutForwardChoiceChoice";
	String DEFINITION = "optional choice constantPayoffRegion, linearPayoffRegion";
	
	ValidationResult<FxTargetKnockoutForwardChoice> validate(RosettaPath path, FxTargetKnockoutForwardChoice fxTargetKnockoutForwardChoice);
	
	class Default implements FxTargetKnockoutForwardChoiceChoice {
	
		@Override
		public ValidationResult<FxTargetKnockoutForwardChoice> validate(RosettaPath path, FxTargetKnockoutForwardChoice fxTargetKnockoutForwardChoice) {
			ComparisonResult result = executeDataRule(fxTargetKnockoutForwardChoice);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTargetKnockoutForwardChoice", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxTargetKnockoutForwardChoice", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxTargetKnockoutForwardChoice fxTargetKnockoutForwardChoice) {
			try {
				return choice(MapperS.of(fxTargetKnockoutForwardChoice), Arrays.asList("constantPayoffRegion", "linearPayoffRegion"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxTargetKnockoutForwardChoiceChoice {
	
		@Override
		public ValidationResult<FxTargetKnockoutForwardChoice> validate(RosettaPath path, FxTargetKnockoutForwardChoice fxTargetKnockoutForwardChoice) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTargetKnockoutForwardChoice", path, DEFINITION);
		}
	}
}
