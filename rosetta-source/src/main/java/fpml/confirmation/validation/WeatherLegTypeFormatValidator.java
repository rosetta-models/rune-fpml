package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.WeatherLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class WeatherLegTypeFormatValidator implements Validator<WeatherLeg> {

	private List<ComparisonResult> getComparisonResults(WeatherLeg o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<WeatherLeg> validate(RosettaPath path, WeatherLeg o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("WeatherLeg", ValidationType.TYPE_FORMAT, "WeatherLeg", path, "", error);
		}
		return success("WeatherLeg", ValidationType.TYPE_FORMAT, "WeatherLeg", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, WeatherLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("WeatherLeg", ValidationType.TYPE_FORMAT, "WeatherLeg", path, "", res.getError());
				}
				return success("WeatherLeg", ValidationType.TYPE_FORMAT, "WeatherLeg", path, "");
			})
			.collect(toList());
	}

}
