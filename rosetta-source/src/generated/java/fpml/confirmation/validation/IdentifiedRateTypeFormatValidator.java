package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.IdentifiedRate;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class IdentifiedRateTypeFormatValidator implements Validator<IdentifiedRate> {

	private List<ComparisonResult> getComparisonResults(IdentifiedRate o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<IdentifiedRate> validate(RosettaPath path, IdentifiedRate o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("IdentifiedRate", ValidationType.TYPE_FORMAT, "IdentifiedRate", path, "", error);
		}
		return success("IdentifiedRate", ValidationType.TYPE_FORMAT, "IdentifiedRate", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IdentifiedRate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IdentifiedRate", ValidationType.TYPE_FORMAT, "IdentifiedRate", path, "", res.getError());
				}
				return success("IdentifiedRate", ValidationType.TYPE_FORMAT, "IdentifiedRate", path, "");
			})
			.collect(toList());
	}

}
