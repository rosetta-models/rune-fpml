package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FloatingRateAccrual;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FloatingRateAccrualTypeFormatValidator implements Validator<FloatingRateAccrual> {

	private List<ComparisonResult> getComparisonResults(FloatingRateAccrual o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FloatingRateAccrual> validate(RosettaPath path, FloatingRateAccrual o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FloatingRateAccrual", ValidationType.TYPE_FORMAT, "FloatingRateAccrual", path, "", error);
		}
		return success("FloatingRateAccrual", ValidationType.TYPE_FORMAT, "FloatingRateAccrual", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRateAccrual o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingRateAccrual", ValidationType.TYPE_FORMAT, "FloatingRateAccrual", path, "", res.getError());
				}
				return success("FloatingRateAccrual", ValidationType.TYPE_FORMAT, "FloatingRateAccrual", path, "");
			})
			.collect(toList());
	}

}
