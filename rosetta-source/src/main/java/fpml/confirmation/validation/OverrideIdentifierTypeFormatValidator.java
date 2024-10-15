package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.OverrideIdentifier;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OverrideIdentifierTypeFormatValidator implements Validator<OverrideIdentifier> {

	private List<ComparisonResult> getComparisonResults(OverrideIdentifier o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<OverrideIdentifier> validate(RosettaPath path, OverrideIdentifier o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OverrideIdentifier", ValidationType.TYPE_FORMAT, "OverrideIdentifier", path, "", error);
		}
		return success("OverrideIdentifier", ValidationType.TYPE_FORMAT, "OverrideIdentifier", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OverrideIdentifier o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OverrideIdentifier", ValidationType.TYPE_FORMAT, "OverrideIdentifier", path, "", res.getError());
				}
				return success("OverrideIdentifier", ValidationType.TYPE_FORMAT, "OverrideIdentifier", path, "");
			})
			.collect(toList());
	}

}
