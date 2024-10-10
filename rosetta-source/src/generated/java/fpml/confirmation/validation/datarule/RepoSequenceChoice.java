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
import fpml.confirmation.RepoSequence;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("RepoSequenceChoice")
@ImplementedBy(RepoSequenceChoice.Default.class)
public interface RepoSequenceChoice extends Validator<RepoSequence> {
	
	String NAME = "RepoSequenceChoice";
	String DEFINITION = "optional choice noticePeriod, partyNoticePeriod";
	
	ValidationResult<RepoSequence> validate(RosettaPath path, RepoSequence repoSequence);
	
	class Default implements RepoSequenceChoice {
	
		@Override
		public ValidationResult<RepoSequence> validate(RosettaPath path, RepoSequence repoSequence) {
			ComparisonResult result = executeDataRule(repoSequence);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RepoSequence", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "RepoSequence", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(RepoSequence repoSequence) {
			try {
				return choice(MapperS.of(repoSequence), Arrays.asList("noticePeriod", "partyNoticePeriod"), ChoiceRuleValidationMethod.OPTIONAL);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RepoSequenceChoice {
	
		@Override
		public ValidationResult<RepoSequence> validate(RosettaPath path, RepoSequence repoSequence) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RepoSequence", path, DEFINITION);
		}
	}
}
