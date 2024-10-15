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
import fpml.confirmation.FxSettlementRateSource;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("FxSettlementRateSourceChoice")
@ImplementedBy(FxSettlementRateSourceChoice.Default.class)
public interface FxSettlementRateSourceChoice extends Validator<FxSettlementRateSource> {
	
	String NAME = "FxSettlementRateSourceChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<FxSettlementRateSource> validate(RosettaPath path, FxSettlementRateSource fxSettlementRateSource);
	
	class Default implements FxSettlementRateSourceChoice {
	
		@Override
		public ValidationResult<FxSettlementRateSource> validate(RosettaPath path, FxSettlementRateSource fxSettlementRateSource) {
			ComparisonResult result = executeDataRule(fxSettlementRateSource);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxSettlementRateSource", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxSettlementRateSource", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxSettlementRateSource fxSettlementRateSource) {
			try {
				return choice(MapperS.of(fxSettlementRateSource), Arrays.asList("settlementRateOption", "nonstandardSettlementRate"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxSettlementRateSourceChoice {
	
		@Override
		public ValidationResult<FxSettlementRateSource> validate(RosettaPath path, FxSettlementRateSource fxSettlementRateSource) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxSettlementRateSource", path, DEFINITION);
		}
	}
}
