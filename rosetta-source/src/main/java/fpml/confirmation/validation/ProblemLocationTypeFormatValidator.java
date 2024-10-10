package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ProblemLocation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ProblemLocationTypeFormatValidator implements Validator<ProblemLocation> {

	private List<ComparisonResult> getComparisonResults(ProblemLocation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ProblemLocation> validate(RosettaPath path, ProblemLocation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ProblemLocation", ValidationType.TYPE_FORMAT, "ProblemLocation", path, "", error);
		}
		return success("ProblemLocation", ValidationType.TYPE_FORMAT, "ProblemLocation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ProblemLocation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ProblemLocation", ValidationType.TYPE_FORMAT, "ProblemLocation", path, "", res.getError());
				}
				return success("ProblemLocation", ValidationType.TYPE_FORMAT, "ProblemLocation", path, "");
			})
			.collect(toList());
	}

}
