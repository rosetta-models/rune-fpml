package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FixedRateOptionBase;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FixedRateOptionBaseTypeFormatValidator implements Validator<FixedRateOptionBase> {

	private List<ComparisonResult> getComparisonResults(FixedRateOptionBase o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FixedRateOptionBase> validate(RosettaPath path, FixedRateOptionBase o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FixedRateOptionBase", ValidationType.TYPE_FORMAT, "FixedRateOptionBase", path, "", error);
		}
		return success("FixedRateOptionBase", ValidationType.TYPE_FORMAT, "FixedRateOptionBase", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FixedRateOptionBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FixedRateOptionBase", ValidationType.TYPE_FORMAT, "FixedRateOptionBase", path, "", res.getError());
				}
				return success("FixedRateOptionBase", ValidationType.TYPE_FORMAT, "FixedRateOptionBase", path, "");
			})
			.collect(toList());
	}

}
