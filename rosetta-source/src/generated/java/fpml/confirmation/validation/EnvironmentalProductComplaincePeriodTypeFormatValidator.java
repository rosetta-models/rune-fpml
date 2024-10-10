package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.EnvironmentalProductComplaincePeriod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class EnvironmentalProductComplaincePeriodTypeFormatValidator implements Validator<EnvironmentalProductComplaincePeriod> {

	private List<ComparisonResult> getComparisonResults(EnvironmentalProductComplaincePeriod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("startYear", o.getStartYear(), empty(), of(0), empty(), empty()), 
				checkNumber("endYear", o.getEndYear(), empty(), of(0), empty(), empty())
			);
	}

	@Override
	public ValidationResult<EnvironmentalProductComplaincePeriod> validate(RosettaPath path, EnvironmentalProductComplaincePeriod o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("EnvironmentalProductComplaincePeriod", ValidationType.TYPE_FORMAT, "EnvironmentalProductComplaincePeriod", path, "", error);
		}
		return success("EnvironmentalProductComplaincePeriod", ValidationType.TYPE_FORMAT, "EnvironmentalProductComplaincePeriod", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EnvironmentalProductComplaincePeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EnvironmentalProductComplaincePeriod", ValidationType.TYPE_FORMAT, "EnvironmentalProductComplaincePeriod", path, "", res.getError());
				}
				return success("EnvironmentalProductComplaincePeriod", ValidationType.TYPE_FORMAT, "EnvironmentalProductComplaincePeriod", path, "");
			})
			.collect(toList());
	}

}
