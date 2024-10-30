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
import fpml.confirmation.PortfolioReferenceOrReportIdentificationModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("PortfolioReferenceOrReportIdentificationModelChoice")
@ImplementedBy(PortfolioReferenceOrReportIdentificationModelChoice.Default.class)
public interface PortfolioReferenceOrReportIdentificationModelChoice extends Validator<PortfolioReferenceOrReportIdentificationModel> {
	
	String NAME = "PortfolioReferenceOrReportIdentificationModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<PortfolioReferenceOrReportIdentificationModel> validate(RosettaPath path, PortfolioReferenceOrReportIdentificationModel portfolioReferenceOrReportIdentificationModel);
	
	class Default implements PortfolioReferenceOrReportIdentificationModelChoice {
	
		@Override
		public ValidationResult<PortfolioReferenceOrReportIdentificationModel> validate(RosettaPath path, PortfolioReferenceOrReportIdentificationModel portfolioReferenceOrReportIdentificationModel) {
			ComparisonResult result = executeDataRule(portfolioReferenceOrReportIdentificationModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PortfolioReferenceOrReportIdentificationModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "PortfolioReferenceOrReportIdentificationModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(PortfolioReferenceOrReportIdentificationModel portfolioReferenceOrReportIdentificationModel) {
			try {
				return choice(MapperS.of(portfolioReferenceOrReportIdentificationModel), Arrays.asList("portfolioConstituentReferenceModel", "reportSectionIdentificationModel"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PortfolioReferenceOrReportIdentificationModelChoice {
	
		@Override
		public ValidationResult<PortfolioReferenceOrReportIdentificationModel> validate(RosettaPath path, PortfolioReferenceOrReportIdentificationModel portfolioReferenceOrReportIdentificationModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PortfolioReferenceOrReportIdentificationModel", path, DEFINITION);
		}
	}
}
