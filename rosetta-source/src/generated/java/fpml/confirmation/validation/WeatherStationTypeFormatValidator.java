package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.WeatherStation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class WeatherStationTypeFormatValidator implements Validator<WeatherStation> {

	private List<ComparisonResult> getComparisonResults(WeatherStation o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<WeatherStation> validate(RosettaPath path, WeatherStation o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("WeatherStation", ValidationType.TYPE_FORMAT, "WeatherStation", path, "", error);
		}
		return success("WeatherStation", ValidationType.TYPE_FORMAT, "WeatherStation", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, WeatherStation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("WeatherStation", ValidationType.TYPE_FORMAT, "WeatherStation", path, "", res.getError());
				}
				return success("WeatherStation", ValidationType.TYPE_FORMAT, "WeatherStation", path, "");
			})
			.collect(toList());
	}

}
