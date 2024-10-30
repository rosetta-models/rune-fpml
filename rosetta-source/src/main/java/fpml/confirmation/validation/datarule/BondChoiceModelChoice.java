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
import fpml.confirmation.BondChoiceModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("BondChoiceModelChoice")
@ImplementedBy(BondChoiceModelChoice.Default.class)
public interface BondChoiceModelChoice extends Validator<BondChoiceModel> {
	
	String NAME = "BondChoiceModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<BondChoiceModel> validate(RosettaPath path, BondChoiceModel bondChoiceModel);
	
	class Default implements BondChoiceModelChoice {
	
		@Override
		public ValidationResult<BondChoiceModel> validate(RosettaPath path, BondChoiceModel bondChoiceModel) {
			ComparisonResult result = executeDataRule(bondChoiceModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "BondChoiceModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "BondChoiceModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(BondChoiceModel bondChoiceModel) {
			try {
				return choice(MapperS.of(bondChoiceModel), Arrays.asList("bond", "convertibleBond"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements BondChoiceModelChoice {
	
		@Override
		public ValidationResult<BondChoiceModel> validate(RosettaPath path, BondChoiceModel bondChoiceModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "BondChoiceModel", path, DEFINITION);
		}
	}
}
