package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.RateIndex;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RateIndexTypeFormatValidator implements Validator<RateIndex> {

	private List<ComparisonResult> getComparisonResults(RateIndex o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("description", o.getDescription(), 0, of(255), empty())
			);
	}

	@Override
	public ValidationResult<RateIndex> validate(RosettaPath path, RateIndex o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RateIndex", ValidationType.TYPE_FORMAT, "RateIndex", path, "", error);
		}
		return success("RateIndex", ValidationType.TYPE_FORMAT, "RateIndex", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RateIndex o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RateIndex", ValidationType.TYPE_FORMAT, "RateIndex", path, "", res.getError());
				}
				return success("RateIndex", ValidationType.TYPE_FORMAT, "RateIndex", path, "");
			})
			.collect(toList());
	}

}
