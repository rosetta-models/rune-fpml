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
import fpml.confirmation.ReportingRegime;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("ReportingRegimeChoice0")
@ImplementedBy(ReportingRegimeChoice0.Default.class)
public interface ReportingRegimeChoice0 extends Validator<ReportingRegime> {
	
	String NAME = "ReportingRegimeChoice0";
	String DEFINITION = "required choice reportingRegimeSequence0, supervisorRegistration";
	
	ValidationResult<ReportingRegime> validate(RosettaPath path, ReportingRegime reportingRegime);
	
	class Default implements ReportingRegimeChoice0 {
	
		@Override
		public ValidationResult<ReportingRegime> validate(RosettaPath path, ReportingRegime reportingRegime) {
			ComparisonResult result = executeDataRule(reportingRegime);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ReportingRegime", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "ReportingRegime", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(ReportingRegime reportingRegime) {
			try {
				return choice(MapperS.of(reportingRegime), Arrays.asList("reportingRegimeSequence0", "supervisorRegistration"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ReportingRegimeChoice0 {
	
		@Override
		public ValidationResult<ReportingRegime> validate(RosettaPath path, ReportingRegime reportingRegime) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ReportingRegime", path, DEFINITION);
		}
	}
}
