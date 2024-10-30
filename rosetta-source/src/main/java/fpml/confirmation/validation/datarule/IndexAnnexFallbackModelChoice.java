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
import fpml.confirmation.IndexAnnexFallbackModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("IndexAnnexFallbackModelChoice")
@ImplementedBy(IndexAnnexFallbackModelChoice.Default.class)
public interface IndexAnnexFallbackModelChoice extends Validator<IndexAnnexFallbackModel> {
	
	String NAME = "IndexAnnexFallbackModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<IndexAnnexFallbackModel> validate(RosettaPath path, IndexAnnexFallbackModel indexAnnexFallbackModel);
	
	class Default implements IndexAnnexFallbackModelChoice {
	
		@Override
		public ValidationResult<IndexAnnexFallbackModel> validate(RosettaPath path, IndexAnnexFallbackModel indexAnnexFallbackModel) {
			ComparisonResult result = executeDataRule(indexAnnexFallbackModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "IndexAnnexFallbackModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "IndexAnnexFallbackModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(IndexAnnexFallbackModel indexAnnexFallbackModel) {
			try {
				return choice(MapperS.of(indexAnnexFallbackModel), Arrays.asList("multipleExchangeIndexAnnexFallback", "componentSecurityIndexAnnexFallback"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements IndexAnnexFallbackModelChoice {
	
		@Override
		public ValidationResult<IndexAnnexFallbackModel> validate(RosettaPath path, IndexAnnexFallbackModel indexAnnexFallbackModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "IndexAnnexFallbackModel", path, DEFINITION);
		}
	}
}
