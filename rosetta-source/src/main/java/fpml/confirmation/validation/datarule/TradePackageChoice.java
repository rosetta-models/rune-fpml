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
import fpml.confirmation.TradePackage;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("TradePackageChoice")
@ImplementedBy(TradePackageChoice.Default.class)
public interface TradePackageChoice extends Validator<TradePackage> {
	
	String NAME = "TradePackageChoice";
	String DEFINITION = "required choice trade, tradeReferenceInformationModel , tradeIdentifier";
	
	ValidationResult<TradePackage> validate(RosettaPath path, TradePackage tradePackage);
	
	class Default implements TradePackageChoice {
	
		@Override
		public ValidationResult<TradePackage> validate(RosettaPath path, TradePackage tradePackage) {
			ComparisonResult result = executeDataRule(tradePackage);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradePackage", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "TradePackage", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(TradePackage tradePackage) {
			try {
				return choice(MapperS.of(tradePackage), Arrays.asList("trade", "tradeReferenceInformationModel", "tradeIdentifier"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements TradePackageChoice {
	
		@Override
		public ValidationResult<TradePackage> validate(RosettaPath path, TradePackage tradePackage) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "TradePackage", path, DEFINITION);
		}
	}
}
