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
import fpml.confirmation.RoutingIdentificationModel;
import java.util.Arrays;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("RoutingIdentificationModelChoice")
@ImplementedBy(RoutingIdentificationModelChoice.Default.class)
public interface RoutingIdentificationModelChoice extends Validator<RoutingIdentificationModel> {
	
	String NAME = "RoutingIdentificationModelChoice";
	String DEFINITION = "one-of";
	
	ValidationResult<RoutingIdentificationModel> validate(RosettaPath path, RoutingIdentificationModel routingIdentificationModel);
	
	class Default implements RoutingIdentificationModelChoice {
	
		@Override
		public ValidationResult<RoutingIdentificationModel> validate(RosettaPath path, RoutingIdentificationModel routingIdentificationModel) {
			ComparisonResult result = executeDataRule(routingIdentificationModel);
			if (result.get()) {
				return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RoutingIdentificationModel", path, DEFINITION);
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return ValidationResult.failure(NAME, ValidationType.DATA_RULE, "RoutingIdentificationModel", path, DEFINITION, failureMessage);
		}
		
		private ComparisonResult executeDataRule(RoutingIdentificationModel routingIdentificationModel) {
			try {
				return choice(MapperS.of(routingIdentificationModel), Arrays.asList("routingIds", "routingExplicitDetails", "routingIdsAndExplicitDetails"), ChoiceRuleValidationMethod.REQUIRED);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RoutingIdentificationModelChoice {
	
		@Override
		public ValidationResult<RoutingIdentificationModel> validate(RosettaPath path, RoutingIdentificationModel routingIdentificationModel) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RoutingIdentificationModel", path, DEFINITION);
		}
	}
}
