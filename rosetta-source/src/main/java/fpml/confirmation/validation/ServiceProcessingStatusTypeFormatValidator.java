package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ServiceProcessingStatus;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ServiceProcessingStatusTypeFormatValidator implements Validator<ServiceProcessingStatus> {

	private List<ComparisonResult> getComparisonResults(ServiceProcessingStatus o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ServiceProcessingStatus> validate(RosettaPath path, ServiceProcessingStatus o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ServiceProcessingStatus", ValidationType.TYPE_FORMAT, "ServiceProcessingStatus", path, "", error);
		}
		return success("ServiceProcessingStatus", ValidationType.TYPE_FORMAT, "ServiceProcessingStatus", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ServiceProcessingStatus o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ServiceProcessingStatus", ValidationType.TYPE_FORMAT, "ServiceProcessingStatus", path, "", res.getError());
				}
				return success("ServiceProcessingStatus", ValidationType.TYPE_FORMAT, "ServiceProcessingStatus", path, "");
			})
			.collect(toList());
	}

}
