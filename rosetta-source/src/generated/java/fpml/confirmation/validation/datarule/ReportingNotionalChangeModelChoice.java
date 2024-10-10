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
import fpml.confirmation.ReportingNotionalChangeModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("ReportingNotionalChangeModelChoice")
@ImplementedBy(ReportingNotionalChangeModelChoice.Default.class)
public interface ReportingNotionalChangeModelChoice extends Validator<ReportingNotionalChangeModel> {
	
	String NAME = "ReportingNotionalChangeModelChoice";
	String DEFINITION = "required choice changeInNotional, changeInNumberOfOptions , changeInQuantity";
	
	ValidationResult<ReportingNotionalChangeModel> validate(RosettaPath path, ReportingNotionalChangeModel reportingNotionalChangeModel);
	
	class Default implements ReportingNotionalChangeModelChoice {
	
		@Override
		public ValidationResult<ReportingNotionalChangeModel> validate(RosettaPath path, ReportingNotionalChangeModel reportingNotionalChangeModel) {
			ComparisonResult result = executeDataRule(reportingNotionalChangeModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ReportingNotionalChangeModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "ReportingNotionalChangeModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(ReportingNotionalChangeModel reportingNotionalChangeModel) {
			try {
				return choice(MapperS.of(reportingNotionalChangeModel), Arrays.asList("changeInNotional", "changeInNumberOfOptions", "changeInQuantity"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ReportingNotionalChangeModelChoice {
	
		@Override
		public ValidationResult<ReportingNotionalChangeModel> validate(RosettaPath path, ReportingNotionalChangeModel reportingNotionalChangeModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ReportingNotionalChangeModel", path, DEFINITION);
		}
	}
}
