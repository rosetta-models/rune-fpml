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
import fpml.confirmation.Repo;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("RepoChoice")
@ImplementedBy(RepoChoice.Default.class)
public interface RepoChoice extends Validator<Repo> {
	
	String NAME = "RepoChoice";
	String DEFINITION = "required choice bondEquityModel, triParty";
	
	ValidationResult<Repo> validate(RosettaPath path, Repo repo);
	
	class Default implements RepoChoice {
	
		@Override
		public ValidationResult<Repo> validate(RosettaPath path, Repo repo) {
			ComparisonResult result = executeDataRule(repo);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Repo", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "Repo", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(Repo repo) {
			try {
				return choice(MapperS.of(repo), Arrays.asList("bondEquityModel", "triParty"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RepoChoice {
	
		@Override
		public ValidationResult<Repo> validate(RosettaPath path, Repo repo) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "Repo", path, DEFINITION);
		}
	}
}
