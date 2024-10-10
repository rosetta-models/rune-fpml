package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.WeatherIndex;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class WeatherIndexTypeFormatValidator implements Validator<WeatherIndex> {

	private List<ComparisonResult> getComparisonResults(WeatherIndex o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<WeatherIndex> validate(RosettaPath path, WeatherIndex o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("WeatherIndex", ValidationType.TYPE_FORMAT, "WeatherIndex", path, "", error);
		}
		return success("WeatherIndex", ValidationType.TYPE_FORMAT, "WeatherIndex", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, WeatherIndex o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("WeatherIndex", ValidationType.TYPE_FORMAT, "WeatherIndex", path, "", res.getError());
				}
				return success("WeatherIndex", ValidationType.TYPE_FORMAT, "WeatherIndex", path, "");
			})
			.collect(toList());
	}

}
