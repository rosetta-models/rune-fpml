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
import fpml.confirmation.UnderlyingAssetOrReferenceModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("UnderlyingAssetOrReferenceModelChoice")
@ImplementedBy(UnderlyingAssetOrReferenceModelChoice.Default.class)
public interface UnderlyingAssetOrReferenceModelChoice extends Validator<UnderlyingAssetOrReferenceModel> {
	
	String NAME = "UnderlyingAssetOrReferenceModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<UnderlyingAssetOrReferenceModel> validate(RosettaPath path, UnderlyingAssetOrReferenceModel underlyingAssetOrReferenceModel);
	
	class Default implements UnderlyingAssetOrReferenceModelChoice {
	
		@Override
		public ValidationResult<UnderlyingAssetOrReferenceModel> validate(RosettaPath path, UnderlyingAssetOrReferenceModel underlyingAssetOrReferenceModel) {
			ComparisonResult result = executeDataRule(underlyingAssetOrReferenceModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "UnderlyingAssetOrReferenceModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "UnderlyingAssetOrReferenceModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(UnderlyingAssetOrReferenceModel underlyingAssetOrReferenceModel) {
			try {
				return choice(MapperS.of(underlyingAssetOrReferenceModel), Arrays.asList("underlyingAsset", "underlyingAssetReference"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements UnderlyingAssetOrReferenceModelChoice {
	
		@Override
		public ValidationResult<UnderlyingAssetOrReferenceModel> validate(RosettaPath path, UnderlyingAssetOrReferenceModel underlyingAssetOrReferenceModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "UnderlyingAssetOrReferenceModel", path, DEFINITION);
		}
	}
}
