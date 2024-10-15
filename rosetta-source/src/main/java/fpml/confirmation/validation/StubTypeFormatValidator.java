package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Stub;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class StubTypeFormatValidator implements Validator<Stub> {

	private List<ComparisonResult> getComparisonResults(Stub o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<Stub> validate(RosettaPath path, Stub o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Stub", ValidationType.TYPE_FORMAT, "Stub", path, "", error);
		}
		return success("Stub", ValidationType.TYPE_FORMAT, "Stub", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Stub o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Stub", ValidationType.TYPE_FORMAT, "Stub", path, "", res.getError());
				}
				return success("Stub", ValidationType.TYPE_FORMAT, "Stub", path, "");
			})
			.collect(toList());
	}

}
