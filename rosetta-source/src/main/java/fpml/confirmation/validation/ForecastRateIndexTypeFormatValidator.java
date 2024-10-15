package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ForecastRateIndex;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ForecastRateIndexTypeFormatValidator implements Validator<ForecastRateIndex> {

	private List<ComparisonResult> getComparisonResults(ForecastRateIndex o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ForecastRateIndex> validate(RosettaPath path, ForecastRateIndex o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ForecastRateIndex", ValidationType.TYPE_FORMAT, "ForecastRateIndex", path, "", error);
		}
		return success("ForecastRateIndex", ValidationType.TYPE_FORMAT, "ForecastRateIndex", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ForecastRateIndex o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ForecastRateIndex", ValidationType.TYPE_FORMAT, "ForecastRateIndex", path, "", res.getError());
				}
				return success("ForecastRateIndex", ValidationType.TYPE_FORMAT, "ForecastRateIndex", path, "");
			})
			.collect(toList());
	}

}
