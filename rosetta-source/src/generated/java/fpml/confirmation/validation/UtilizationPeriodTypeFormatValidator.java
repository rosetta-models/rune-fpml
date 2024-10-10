package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.UtilizationPeriod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class UtilizationPeriodTypeFormatValidator implements Validator<UtilizationPeriod> {

	private List<ComparisonResult> getComparisonResults(UtilizationPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<UtilizationPeriod> validate(RosettaPath path, UtilizationPeriod o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("UtilizationPeriod", ValidationType.TYPE_FORMAT, "UtilizationPeriod", path, "", error);
		}
		return success("UtilizationPeriod", ValidationType.TYPE_FORMAT, "UtilizationPeriod", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, UtilizationPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("UtilizationPeriod", ValidationType.TYPE_FORMAT, "UtilizationPeriod", path, "", res.getError());
				}
				return success("UtilizationPeriod", ValidationType.TYPE_FORMAT, "UtilizationPeriod", path, "");
			})
			.collect(toList());
	}

}
