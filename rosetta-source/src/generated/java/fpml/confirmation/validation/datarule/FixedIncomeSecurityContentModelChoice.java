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
import fpml.confirmation.FixedIncomeSecurityContentModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("FixedIncomeSecurityContentModelChoice")
@ImplementedBy(FixedIncomeSecurityContentModelChoice.Default.class)
public interface FixedIncomeSecurityContentModelChoice extends Validator<FixedIncomeSecurityContentModel> {
	
	String NAME = "FixedIncomeSecurityContentModelChoice";
	String DEFINITION = "optional choice issuerName, issuerPartyReference";
	
	ValidationResult<FixedIncomeSecurityContentModel> validate(RosettaPath path, FixedIncomeSecurityContentModel fixedIncomeSecurityContentModel);
	
	class Default implements FixedIncomeSecurityContentModelChoice {
	
		@Override
		public ValidationResult<FixedIncomeSecurityContentModel> validate(RosettaPath path, FixedIncomeSecurityContentModel fixedIncomeSecurityContentModel) {
			ComparisonResult result = executeDataRule(fixedIncomeSecurityContentModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FixedIncomeSecurityContentModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FixedIncomeSecurityContentModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FixedIncomeSecurityContentModel fixedIncomeSecurityContentModel) {
			try {
				return choice(MapperS.of(fixedIncomeSecurityContentModel), Arrays.asList("issuerName", "issuerPartyReference"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FixedIncomeSecurityContentModelChoice {
	
		@Override
		public ValidationResult<FixedIncomeSecurityContentModel> validate(RosettaPath path, FixedIncomeSecurityContentModel fixedIncomeSecurityContentModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FixedIncomeSecurityContentModel", path, DEFINITION);
		}
	}
}
