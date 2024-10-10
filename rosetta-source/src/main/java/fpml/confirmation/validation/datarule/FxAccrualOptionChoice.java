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
import fpml.confirmation.FxAccrualOption;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("FxAccrualOptionChoice")
@ImplementedBy(FxAccrualOptionChoice.Default.class)
public interface FxAccrualOptionChoice extends Validator<FxAccrualOption> {
	
	String NAME = "FxAccrualOptionChoice";
	String DEFINITION = "required choice fxAccrualOptionSequence, averageStrike";
	
	ValidationResult<FxAccrualOption> validate(RosettaPath path, FxAccrualOption fxAccrualOption);
	
	class Default implements FxAccrualOptionChoice {
	
		@Override
		public ValidationResult<FxAccrualOption> validate(RosettaPath path, FxAccrualOption fxAccrualOption) {
			ComparisonResult result = executeDataRule(fxAccrualOption);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAccrualOption", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxAccrualOption", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxAccrualOption fxAccrualOption) {
			try {
				return choice(MapperS.of(fxAccrualOption), Arrays.asList("fxAccrualOptionSequence", "averageStrike"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxAccrualOptionChoice {
	
		@Override
		public ValidationResult<FxAccrualOption> validate(RosettaPath path, FxAccrualOption fxAccrualOption) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxAccrualOption", path, DEFINITION);
		}
	}
}
