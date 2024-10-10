package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Empty;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EmptyValidator implements Validator<Empty> {

	private List<ComparisonResult> getComparisonResults(Empty o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<Empty> validate(RosettaPath path, Empty o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Empty", ValidationType.CARDINALITY, "Empty", path, "", error);
		}
		return success("Empty", ValidationType.CARDINALITY, "Empty", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Empty o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Empty", ValidationType.CARDINALITY, "Empty", path, "", res.getError());
				}
				return success("Empty", ValidationType.CARDINALITY, "Empty", path, "");
			})
			.collect(toList());
	}

}
