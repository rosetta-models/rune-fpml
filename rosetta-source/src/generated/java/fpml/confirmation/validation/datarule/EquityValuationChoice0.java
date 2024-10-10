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
import fpml.confirmation.EquityValuation;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("EquityValuationChoice0")
@ImplementedBy(EquityValuationChoice0.Default.class)
public interface EquityValuationChoice0 extends Validator<EquityValuation> {
	
	String NAME = "EquityValuationChoice0";
	String DEFINITION = "optional choice valuationDate, valuationDates";
	
	ValidationResult<EquityValuation> validate(RosettaPath path, EquityValuation equityValuation);
	
	class Default implements EquityValuationChoice0 {
	
		@Override
		public ValidationResult<EquityValuation> validate(RosettaPath path, EquityValuation equityValuation) {
			ComparisonResult result = executeDataRule(equityValuation);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityValuation", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "EquityValuation", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(EquityValuation equityValuation) {
			try {
				return choice(MapperS.of(equityValuation), Arrays.asList("valuationDate", "valuationDates"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EquityValuationChoice0 {
	
		@Override
		public ValidationResult<EquityValuation> validate(RosettaPath path, EquityValuation equityValuation) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityValuation", path, DEFINITION);
		}
	}
}
