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
import fpml.confirmation.FxSettlementDateOrScheduleModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("FxSettlementDateOrScheduleModelChoice")
@ImplementedBy(FxSettlementDateOrScheduleModelChoice.Default.class)
public interface FxSettlementDateOrScheduleModelChoice extends Validator<FxSettlementDateOrScheduleModel> {
	
	String NAME = "FxSettlementDateOrScheduleModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<FxSettlementDateOrScheduleModel> validate(RosettaPath path, FxSettlementDateOrScheduleModel fxSettlementDateOrScheduleModel);
	
	class Default implements FxSettlementDateOrScheduleModelChoice {
	
		@Override
		public ValidationResult<FxSettlementDateOrScheduleModel> validate(RosettaPath path, FxSettlementDateOrScheduleModel fxSettlementDateOrScheduleModel) {
			ComparisonResult result = executeDataRule(fxSettlementDateOrScheduleModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxSettlementDateOrScheduleModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "FxSettlementDateOrScheduleModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(FxSettlementDateOrScheduleModel fxSettlementDateOrScheduleModel) {
			try {
				return choice(MapperS.of(fxSettlementDateOrScheduleModel), Arrays.asList("settlementDate", "settlementSchedule"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements FxSettlementDateOrScheduleModelChoice {
	
		@Override
		public ValidationResult<FxSettlementDateOrScheduleModel> validate(RosettaPath path, FxSettlementDateOrScheduleModel fxSettlementDateOrScheduleModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "FxSettlementDateOrScheduleModel", path, DEFINITION);
		}
	}
}
