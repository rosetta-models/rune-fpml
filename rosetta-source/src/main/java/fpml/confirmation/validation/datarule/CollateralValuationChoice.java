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
import fpml.confirmation.CollateralValuation;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("CollateralValuationChoice")
@ImplementedBy(CollateralValuationChoice.Default.class)
public interface CollateralValuationChoice extends Validator<CollateralValuation> {
	
	String NAME = "CollateralValuationChoice";
	String DEFINITION = "required choice bondCollateralModel, unitContractModel";
	
	ValidationResult<CollateralValuation> validate(RosettaPath path, CollateralValuation collateralValuation);
	
	class Default implements CollateralValuationChoice {
	
		@Override
		public ValidationResult<CollateralValuation> validate(RosettaPath path, CollateralValuation collateralValuation) {
			ComparisonResult result = executeDataRule(collateralValuation);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralValuation", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "CollateralValuation", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(CollateralValuation collateralValuation) {
			try {
				return choice(MapperS.of(collateralValuation), Arrays.asList("bondCollateralModel", "unitContractModel"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements CollateralValuationChoice {
	
		@Override
		public ValidationResult<CollateralValuation> validate(RosettaPath path, CollateralValuation collateralValuation) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "CollateralValuation", path, DEFINITION);
		}
	}
}
