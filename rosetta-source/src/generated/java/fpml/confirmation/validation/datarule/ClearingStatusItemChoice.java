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
import fpml.confirmation.ClearingStatusItem;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("ClearingStatusItemChoice")
@ImplementedBy(ClearingStatusItemChoice.Default.class)
public interface ClearingStatusItemChoice extends Validator<ClearingStatusItem> {
	
	String NAME = "ClearingStatusItemChoice";
	String DEFINITION = "required choice tradeIdentifier, tradeReferenceInformationModel , trade , tradePackage";
	
	ValidationResult<ClearingStatusItem> validate(RosettaPath path, ClearingStatusItem clearingStatusItem);
	
	class Default implements ClearingStatusItemChoice {
	
		@Override
		public ValidationResult<ClearingStatusItem> validate(RosettaPath path, ClearingStatusItem clearingStatusItem) {
			ComparisonResult result = executeDataRule(clearingStatusItem);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ClearingStatusItem", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "ClearingStatusItem", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(ClearingStatusItem clearingStatusItem) {
			try {
				return choice(MapperS.of(clearingStatusItem), Arrays.asList("tradeIdentifier", "tradeReferenceInformationModel", "trade", "tradePackage"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ClearingStatusItemChoice {
	
		@Override
		public ValidationResult<ClearingStatusItem> validate(RosettaPath path, ClearingStatusItem clearingStatusItem) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ClearingStatusItem", path, DEFINITION);
		}
	}
}
