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
import fpml.confirmation.SettlementRateSource;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("SettlementRateSourceChoice")
@ImplementedBy(SettlementRateSourceChoice.Default.class)
public interface SettlementRateSourceChoice extends Validator<SettlementRateSource> {
	
	String NAME = "SettlementRateSourceChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<SettlementRateSource> validate(RosettaPath path, SettlementRateSource settlementRateSource);
	
	class Default implements SettlementRateSourceChoice {
	
		@Override
		public ValidationResult<SettlementRateSource> validate(RosettaPath path, SettlementRateSource settlementRateSource) {
			ComparisonResult result = executeDataRule(settlementRateSource);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementRateSource", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "SettlementRateSource", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(SettlementRateSource settlementRateSource) {
			try {
				return choice(MapperS.of(settlementRateSource), Arrays.asList("informationSource", "cashSettlementReferenceBanks"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements SettlementRateSourceChoice {
	
		@Override
		public ValidationResult<SettlementRateSource> validate(RosettaPath path, SettlementRateSource settlementRateSource) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "SettlementRateSource", path, DEFINITION);
		}
	}
}
