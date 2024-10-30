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
import fpml.confirmation.ApplicableAssets;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("ApplicableAssetsChoice")
@ImplementedBy(ApplicableAssetsChoice.Default.class)
public interface ApplicableAssetsChoice extends Validator<ApplicableAssets> {
	
	String NAME = "ApplicableAssetsChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<ApplicableAssets> validate(RosettaPath path, ApplicableAssets applicableAssets);
	
	class Default implements ApplicableAssetsChoice {
	
		@Override
		public ValidationResult<ApplicableAssets> validate(RosettaPath path, ApplicableAssets applicableAssets) {
			ComparisonResult result = executeDataRule(applicableAssets);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ApplicableAssets", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "ApplicableAssets", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(ApplicableAssets applicableAssets) {
			try {
				return choice(MapperS.of(applicableAssets), Arrays.asList("dealIdentifier", "facilityIdentifier", "facilityType"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ApplicableAssetsChoice {
	
		@Override
		public ValidationResult<ApplicableAssets> validate(RosettaPath path, ApplicableAssets applicableAssets) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ApplicableAssets", path, DEFINITION);
		}
	}
}
