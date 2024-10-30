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
import fpml.confirmation.BondPriceAndYieldModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("BondPriceAndYieldModelChoice")
@ImplementedBy(BondPriceAndYieldModelChoice.Default.class)
public interface BondPriceAndYieldModelChoice extends Validator<BondPriceAndYieldModel> {
	
	String NAME = "BondPriceAndYieldModelChoice";
	String DEFINITION = "required choice bondPriceAndYieldModelSequence, dirtyPrice";
	
	ValidationResult<BondPriceAndYieldModel> validate(RosettaPath path, BondPriceAndYieldModel bondPriceAndYieldModel);
	
	class Default implements BondPriceAndYieldModelChoice {
	
		@Override
		public ValidationResult<BondPriceAndYieldModel> validate(RosettaPath path, BondPriceAndYieldModel bondPriceAndYieldModel) {
			ComparisonResult result = executeDataRule(bondPriceAndYieldModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "BondPriceAndYieldModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "BondPriceAndYieldModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(BondPriceAndYieldModel bondPriceAndYieldModel) {
			try {
				return choice(MapperS.of(bondPriceAndYieldModel), Arrays.asList("bondPriceAndYieldModelSequence", "dirtyPrice"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements BondPriceAndYieldModelChoice {
	
		@Override
		public ValidationResult<BondPriceAndYieldModel> validate(RosettaPath path, BondPriceAndYieldModel bondPriceAndYieldModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "BondPriceAndYieldModel", path, DEFINITION);
		}
	}
}
