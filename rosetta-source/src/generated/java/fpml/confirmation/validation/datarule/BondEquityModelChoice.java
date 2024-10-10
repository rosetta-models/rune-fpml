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
import fpml.confirmation.BondEquityModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("BondEquityModelChoice")
@ImplementedBy(BondEquityModelChoice.Default.class)
public interface BondEquityModelChoice extends Validator<BondEquityModel> {
	
	String NAME = "BondEquityModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<BondEquityModel> validate(RosettaPath path, BondEquityModel bondEquityModel);
	
	class Default implements BondEquityModelChoice {
	
		@Override
		public ValidationResult<BondEquityModel> validate(RosettaPath path, BondEquityModel bondEquityModel) {
			ComparisonResult result = executeDataRule(bondEquityModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "BondEquityModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "BondEquityModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(BondEquityModel bondEquityModel) {
			try {
				return choice(MapperS.of(bondEquityModel), Arrays.asList("bondChoiceModel", "equity"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements BondEquityModelChoice {
	
		@Override
		public ValidationResult<BondEquityModel> validate(RosettaPath path, BondEquityModel bondEquityModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "BondEquityModel", path, DEFINITION);
		}
	}
}
