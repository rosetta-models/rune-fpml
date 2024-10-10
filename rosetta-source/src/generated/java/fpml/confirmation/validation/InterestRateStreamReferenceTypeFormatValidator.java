package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.InterestRateStreamReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class InterestRateStreamReferenceTypeFormatValidator implements Validator<InterestRateStreamReference> {

	private List<ComparisonResult> getComparisonResults(InterestRateStreamReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<InterestRateStreamReference> validate(RosettaPath path, InterestRateStreamReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("InterestRateStreamReference", ValidationType.TYPE_FORMAT, "InterestRateStreamReference", path, "", error);
		}
		return success("InterestRateStreamReference", ValidationType.TYPE_FORMAT, "InterestRateStreamReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestRateStreamReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestRateStreamReference", ValidationType.TYPE_FORMAT, "InterestRateStreamReference", path, "", res.getError());
				}
				return success("InterestRateStreamReference", ValidationType.TYPE_FORMAT, "InterestRateStreamReference", path, "");
			})
			.collect(toList());
	}

}
