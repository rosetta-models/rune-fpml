package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FixedRateAccrual;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FixedRateAccrualTypeFormatValidator implements Validator<FixedRateAccrual> {

	private List<ComparisonResult> getComparisonResults(FixedRateAccrual o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FixedRateAccrual> validate(RosettaPath path, FixedRateAccrual o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FixedRateAccrual", ValidationType.TYPE_FORMAT, "FixedRateAccrual", path, "", error);
		}
		return success("FixedRateAccrual", ValidationType.TYPE_FORMAT, "FixedRateAccrual", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FixedRateAccrual o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FixedRateAccrual", ValidationType.TYPE_FORMAT, "FixedRateAccrual", path, "", res.getError());
				}
				return success("FixedRateAccrual", ValidationType.TYPE_FORMAT, "FixedRateAccrual", path, "");
			})
			.collect(toList());
	}

}
