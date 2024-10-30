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
import fpml.confirmation.FxTenorModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("FxTenorModelChoice")
@ImplementedBy(FxTenorModelChoice.Default.class)
public interface FxTenorModelChoice extends Validator<FxTenorModel> {
	
	String NAME = "FxTenorModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<FxTenorModel> validate(RosettaPath path, FxTenorModel fxTenorModel);
	
	class Default implements FxTenorModelChoice {
	
		@Override
		public ValidationResult<FxTenorModel> validate(RosettaPath path, FxTenorModel fxTenorModel) {
			ComparisonResult result = executeDataRule(fxTenorModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTenorModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxTenorModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxTenorModel fxTenorModel) {
			try {
				return choice(MapperS.of(fxTenorModel), Arrays.asList("tenorName", "tenorPeriod"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxTenorModelChoice {
	
		@Override
		public ValidationResult<FxTenorModel> validate(RosettaPath path, FxTenorModel fxTenorModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxTenorModel", path, DEFINITION);
		}
	}
}
