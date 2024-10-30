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
import fpml.confirmation.NetAndOrGrossModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("NetAndOrGrossModelChoice")
@ImplementedBy(NetAndOrGrossModelChoice.Default.class)
public interface NetAndOrGrossModelChoice extends Validator<NetAndOrGrossModel> {
	
	String NAME = "NetAndOrGrossModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<NetAndOrGrossModel> validate(RosettaPath path, NetAndOrGrossModel netAndOrGrossModel);
	
	class Default implements NetAndOrGrossModelChoice {
	
		@Override
		public ValidationResult<NetAndOrGrossModel> validate(RosettaPath path, NetAndOrGrossModel netAndOrGrossModel) {
			ComparisonResult result = executeDataRule(netAndOrGrossModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "NetAndOrGrossModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "NetAndOrGrossModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(NetAndOrGrossModel netAndOrGrossModel) {
			try {
				return choice(MapperS.of(netAndOrGrossModel), Arrays.asList("net", "netAndOrGrossModelSequence"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements NetAndOrGrossModelChoice {
	
		@Override
		public ValidationResult<NetAndOrGrossModel> validate(RosettaPath path, NetAndOrGrossModel netAndOrGrossModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "NetAndOrGrossModel", path, DEFINITION);
		}
	}
}
