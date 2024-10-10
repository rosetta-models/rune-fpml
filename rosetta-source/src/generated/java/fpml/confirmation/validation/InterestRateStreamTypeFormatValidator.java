package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.InterestRateStream;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class InterestRateStreamTypeFormatValidator implements Validator<InterestRateStream> {

	private List<ComparisonResult> getComparisonResults(InterestRateStream o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<InterestRateStream> validate(RosettaPath path, InterestRateStream o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("InterestRateStream", ValidationType.TYPE_FORMAT, "InterestRateStream", path, "", error);
		}
		return success("InterestRateStream", ValidationType.TYPE_FORMAT, "InterestRateStream", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestRateStream o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestRateStream", ValidationType.TYPE_FORMAT, "InterestRateStream", path, "", res.getError());
				}
				return success("InterestRateStream", ValidationType.TYPE_FORMAT, "InterestRateStream", path, "");
			})
			.collect(toList());
	}

}
