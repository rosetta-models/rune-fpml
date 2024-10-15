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
import fpml.confirmation.IndexReferenceInformation;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("IndexReferenceInformationChoice")
@ImplementedBy(IndexReferenceInformationChoice.Default.class)
public interface IndexReferenceInformationChoice extends Validator<IndexReferenceInformation> {
	
	String NAME = "IndexReferenceInformationChoice";
	String DEFINITION = "required choice indexReferenceInformationSequence0, indexReferenceInformationSequence1";
	
	ValidationResult<IndexReferenceInformation> validate(RosettaPath path, IndexReferenceInformation indexReferenceInformation);
	
	class Default implements IndexReferenceInformationChoice {
	
		@Override
		public ValidationResult<IndexReferenceInformation> validate(RosettaPath path, IndexReferenceInformation indexReferenceInformation) {
			ComparisonResult result = executeDataRule(indexReferenceInformation);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "IndexReferenceInformation", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "IndexReferenceInformation", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(IndexReferenceInformation indexReferenceInformation) {
			try {
				return choice(MapperS.of(indexReferenceInformation), Arrays.asList("indexReferenceInformationSequence0", "indexReferenceInformationSequence1"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements IndexReferenceInformationChoice {
	
		@Override
		public ValidationResult<IndexReferenceInformation> validate(RosettaPath path, IndexReferenceInformation indexReferenceInformation) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "IndexReferenceInformation", path, DEFINITION);
		}
	}
}
