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
import fpml.confirmation.ReportingRegimeIdentifier;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("ReportingRegimeIdentifierChoice")
@ImplementedBy(ReportingRegimeIdentifierChoice.Default.class)
public interface ReportingRegimeIdentifierChoice extends Validator<ReportingRegimeIdentifier> {
	
	String NAME = "ReportingRegimeIdentifierChoice";
	String DEFINITION = "required choice reportingRegimeIdentifierSequence, supervisorRegistration";
	
	ValidationResult<ReportingRegimeIdentifier> validate(RosettaPath path, ReportingRegimeIdentifier reportingRegimeIdentifier);
	
	class Default implements ReportingRegimeIdentifierChoice {
	
		@Override
		public ValidationResult<ReportingRegimeIdentifier> validate(RosettaPath path, ReportingRegimeIdentifier reportingRegimeIdentifier) {
			ComparisonResult result = executeDataRule(reportingRegimeIdentifier);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ReportingRegimeIdentifier", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "ReportingRegimeIdentifier", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(ReportingRegimeIdentifier reportingRegimeIdentifier) {
			try {
				return choice(MapperS.of(reportingRegimeIdentifier), Arrays.asList("reportingRegimeIdentifierSequence", "supervisorRegistration"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ReportingRegimeIdentifierChoice {
	
		@Override
		public ValidationResult<ReportingRegimeIdentifier> validate(RosettaPath path, ReportingRegimeIdentifier reportingRegimeIdentifier) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ReportingRegimeIdentifier", path, DEFINITION);
		}
	}
}
