package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ServiceProcessingStep;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ServiceProcessingStepValidator implements Validator<ServiceProcessingStep> {

	private List<ComparisonResult> getComparisonResults(ServiceProcessingStep o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("serviceProcessingStep", (String) o.getServiceProcessingStep() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ServiceProcessingStep> validate(RosettaPath path, ServiceProcessingStep o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ServiceProcessingStep", ValidationType.CARDINALITY, "ServiceProcessingStep", path, "", error);
		}
		return success("ServiceProcessingStep", ValidationType.CARDINALITY, "ServiceProcessingStep", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ServiceProcessingStep o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ServiceProcessingStep", ValidationType.CARDINALITY, "ServiceProcessingStep", path, "", res.getError());
				}
				return success("ServiceProcessingStep", ValidationType.CARDINALITY, "ServiceProcessingStep", path, "");
			})
			.collect(toList());
	}

}
