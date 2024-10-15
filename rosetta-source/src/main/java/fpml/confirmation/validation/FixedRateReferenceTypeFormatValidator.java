package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FixedRateReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FixedRateReferenceTypeFormatValidator implements Validator<FixedRateReference> {

	private List<ComparisonResult> getComparisonResults(FixedRateReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<FixedRateReference> validate(RosettaPath path, FixedRateReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FixedRateReference", ValidationType.TYPE_FORMAT, "FixedRateReference", path, "", error);
		}
		return success("FixedRateReference", ValidationType.TYPE_FORMAT, "FixedRateReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FixedRateReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FixedRateReference", ValidationType.TYPE_FORMAT, "FixedRateReference", path, "", res.getError());
				}
				return success("FixedRateReference", ValidationType.TYPE_FORMAT, "FixedRateReference", path, "");
			})
			.collect(toList());
	}

}
