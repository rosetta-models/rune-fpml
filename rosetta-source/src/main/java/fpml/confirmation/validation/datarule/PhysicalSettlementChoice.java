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
import fpml.confirmation.PhysicalSettlement;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("PhysicalSettlementChoice")
@ImplementedBy(PhysicalSettlementChoice.Default.class)
public interface PhysicalSettlementChoice extends Validator<PhysicalSettlement> {
	
	String NAME = "PhysicalSettlementChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<PhysicalSettlement> validate(RosettaPath path, PhysicalSettlement physicalSettlement);
	
	class Default implements PhysicalSettlementChoice {
	
		@Override
		public ValidationResult<PhysicalSettlement> validate(RosettaPath path, PhysicalSettlement physicalSettlement) {
			ComparisonResult result = executeDataRule(physicalSettlement);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PhysicalSettlement", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "PhysicalSettlement", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(PhysicalSettlement physicalSettlement) {
			try {
				return choice(MapperS.of(physicalSettlement), Arrays.asList("resultingTradeIdentifier", "resultingTrade", "product"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PhysicalSettlementChoice {
	
		@Override
		public ValidationResult<PhysicalSettlement> validate(RosettaPath path, PhysicalSettlement physicalSettlement) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PhysicalSettlement", path, DEFINITION);
		}
	}
}
