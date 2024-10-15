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
import fpml.confirmation.NonDeliverableSettlement;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("NonDeliverableSettlementChoice")
@ImplementedBy(NonDeliverableSettlementChoice.Default.class)
public interface NonDeliverableSettlementChoice extends Validator<NonDeliverableSettlement> {
	
	String NAME = "NonDeliverableSettlementChoice";
	String DEFINITION = "required choice fxFixingDate, fxFixingSchedule";
	
	ValidationResult<NonDeliverableSettlement> validate(RosettaPath path, NonDeliverableSettlement nonDeliverableSettlement);
	
	class Default implements NonDeliverableSettlementChoice {
	
		@Override
		public ValidationResult<NonDeliverableSettlement> validate(RosettaPath path, NonDeliverableSettlement nonDeliverableSettlement) {
			ComparisonResult result = executeDataRule(nonDeliverableSettlement);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "NonDeliverableSettlement", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "NonDeliverableSettlement", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(NonDeliverableSettlement nonDeliverableSettlement) {
			try {
				return choice(MapperS.of(nonDeliverableSettlement), Arrays.asList("fxFixingDate", "fxFixingSchedule"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements NonDeliverableSettlementChoice {
	
		@Override
		public ValidationResult<NonDeliverableSettlement> validate(RosettaPath path, NonDeliverableSettlement nonDeliverableSettlement) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "NonDeliverableSettlement", path, DEFINITION);
		}
	}
}
