package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AccrualPeriod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AccrualPeriodTypeFormatValidator implements Validator<AccrualPeriod> {

	private List<ComparisonResult> getComparisonResults(AccrualPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<AccrualPeriod> validate(RosettaPath path, AccrualPeriod o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AccrualPeriod", ValidationType.TYPE_FORMAT, "AccrualPeriod", path, "", error);
		}
		return success("AccrualPeriod", ValidationType.TYPE_FORMAT, "AccrualPeriod", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AccrualPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AccrualPeriod", ValidationType.TYPE_FORMAT, "AccrualPeriod", path, "", res.getError());
				}
				return success("AccrualPeriod", ValidationType.TYPE_FORMAT, "AccrualPeriod", path, "");
			})
			.collect(toList());
	}

}
