package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ServiceProcessingCycle;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ServiceProcessingCycleValidator implements Validator<ServiceProcessingCycle> {

	private List<ComparisonResult> getComparisonResults(ServiceProcessingCycle o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("serviceProcessingCycleScheme", (String) o.getServiceProcessingCycleScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ServiceProcessingCycle> validate(RosettaPath path, ServiceProcessingCycle o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ServiceProcessingCycle", ValidationType.CARDINALITY, "ServiceProcessingCycle", path, "", error);
		}
		return success("ServiceProcessingCycle", ValidationType.CARDINALITY, "ServiceProcessingCycle", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ServiceProcessingCycle o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ServiceProcessingCycle", ValidationType.CARDINALITY, "ServiceProcessingCycle", path, "", res.getError());
				}
				return success("ServiceProcessingCycle", ValidationType.CARDINALITY, "ServiceProcessingCycle", path, "");
			})
			.collect(toList());
	}

}
