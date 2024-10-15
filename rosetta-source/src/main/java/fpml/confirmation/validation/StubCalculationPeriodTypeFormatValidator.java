package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.StubCalculationPeriod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class StubCalculationPeriodTypeFormatValidator implements Validator<StubCalculationPeriod> {

	private List<ComparisonResult> getComparisonResults(StubCalculationPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<StubCalculationPeriod> validate(RosettaPath path, StubCalculationPeriod o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("StubCalculationPeriod", ValidationType.TYPE_FORMAT, "StubCalculationPeriod", path, "", error);
		}
		return success("StubCalculationPeriod", ValidationType.TYPE_FORMAT, "StubCalculationPeriod", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, StubCalculationPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("StubCalculationPeriod", ValidationType.TYPE_FORMAT, "StubCalculationPeriod", path, "", res.getError());
				}
				return success("StubCalculationPeriod", ValidationType.TYPE_FORMAT, "StubCalculationPeriod", path, "");
			})
			.collect(toList());
	}

}
