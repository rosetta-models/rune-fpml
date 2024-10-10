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
import fpml.confirmation.SettlementInformation;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("SettlementInformationChoice")
@ImplementedBy(SettlementInformationChoice.Default.class)
public interface SettlementInformationChoice extends Validator<SettlementInformation> {
	
	String NAME = "SettlementInformationChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<SettlementInformation> validate(RosettaPath path, SettlementInformation settlementInformation);
	
	class Default implements SettlementInformationChoice {
	
		@Override
		public ValidationResult<SettlementInformation> validate(RosettaPath path, SettlementInformation settlementInformation) {
			ComparisonResult result = executeDataRule(settlementInformation);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementInformation", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "SettlementInformation", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(SettlementInformation settlementInformation) {
			try {
				return choice(MapperS.of(settlementInformation), Arrays.asList("standardSettlementStyle", "settlementInstruction"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SettlementInformationChoice {
	
		@Override
		public ValidationResult<SettlementInformation> validate(RosettaPath path, SettlementInformation settlementInformation) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementInformation", path, DEFINITION);
		}
	}
}
