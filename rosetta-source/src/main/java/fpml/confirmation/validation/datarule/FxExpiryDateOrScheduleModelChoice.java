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
import fpml.confirmation.FxExpiryDateOrScheduleModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataRule("FxExpiryDateOrScheduleModelChoice")
@ImplementedBy(FxExpiryDateOrScheduleModelChoice.Default.class)
public interface FxExpiryDateOrScheduleModelChoice extends Validator<FxExpiryDateOrScheduleModel> {
	
	String NAME = "FxExpiryDateOrScheduleModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<FxExpiryDateOrScheduleModel> validate(RosettaPath path, FxExpiryDateOrScheduleModel fxExpiryDateOrScheduleModel);
	
	class Default implements FxExpiryDateOrScheduleModelChoice {
	
		@Override
		public ValidationResult<FxExpiryDateOrScheduleModel> validate(RosettaPath path, FxExpiryDateOrScheduleModel fxExpiryDateOrScheduleModel) {
			ComparisonResult result = executeDataRule(fxExpiryDateOrScheduleModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxExpiryDateOrScheduleModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxExpiryDateOrScheduleModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxExpiryDateOrScheduleModel fxExpiryDateOrScheduleModel) {
			try {
				return choice(MapperS.of(fxExpiryDateOrScheduleModel), Arrays.asList("expiryDate", "expirySchedule"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxExpiryDateOrScheduleModelChoice {
	
		@Override
		public ValidationResult<FxExpiryDateOrScheduleModel> validate(RosettaPath path, FxExpiryDateOrScheduleModel fxExpiryDateOrScheduleModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxExpiryDateOrScheduleModel", path, DEFINITION);
		}
	}
}
