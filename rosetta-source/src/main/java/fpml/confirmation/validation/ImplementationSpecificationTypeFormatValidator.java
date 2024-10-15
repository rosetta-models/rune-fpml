package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ImplementationSpecification;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ImplementationSpecificationTypeFormatValidator implements Validator<ImplementationSpecification> {

	private List<ComparisonResult> getComparisonResults(ImplementationSpecification o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ImplementationSpecification> validate(RosettaPath path, ImplementationSpecification o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ImplementationSpecification", ValidationType.TYPE_FORMAT, "ImplementationSpecification", path, "", error);
		}
		return success("ImplementationSpecification", ValidationType.TYPE_FORMAT, "ImplementationSpecification", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ImplementationSpecification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ImplementationSpecification", ValidationType.TYPE_FORMAT, "ImplementationSpecification", path, "", res.getError());
				}
				return success("ImplementationSpecification", ValidationType.TYPE_FORMAT, "ImplementationSpecification", path, "");
			})
			.collect(toList());
	}

}
