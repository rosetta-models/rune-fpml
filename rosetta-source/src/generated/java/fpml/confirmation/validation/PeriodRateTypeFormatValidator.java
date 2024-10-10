package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.PeriodRate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class PeriodRateTypeFormatValidator implements Validator<PeriodRate> {

	private List<ComparisonResult> getComparisonResults(PeriodRate o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<PeriodRate> validate(RosettaPath path, PeriodRate o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("PeriodRate", ValidationType.TYPE_FORMAT, "PeriodRate", path, "", error);
		}
		return success("PeriodRate", ValidationType.TYPE_FORMAT, "PeriodRate", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PeriodRate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PeriodRate", ValidationType.TYPE_FORMAT, "PeriodRate", path, "", res.getError());
				}
				return success("PeriodRate", ValidationType.TYPE_FORMAT, "PeriodRate", path, "");
			})
			.collect(toList());
	}

}
