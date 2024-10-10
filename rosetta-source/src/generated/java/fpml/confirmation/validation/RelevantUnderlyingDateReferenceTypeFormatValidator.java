package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.RelevantUnderlyingDateReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class RelevantUnderlyingDateReferenceTypeFormatValidator implements Validator<RelevantUnderlyingDateReference> {

	private List<ComparisonResult> getComparisonResults(RelevantUnderlyingDateReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<RelevantUnderlyingDateReference> validate(RosettaPath path, RelevantUnderlyingDateReference o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("RelevantUnderlyingDateReference", ValidationType.TYPE_FORMAT, "RelevantUnderlyingDateReference", path, "", error);
		}
		return success("RelevantUnderlyingDateReference", ValidationType.TYPE_FORMAT, "RelevantUnderlyingDateReference", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, RelevantUnderlyingDateReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("RelevantUnderlyingDateReference", ValidationType.TYPE_FORMAT, "RelevantUnderlyingDateReference", path, "", res.getError());
				}
				return success("RelevantUnderlyingDateReference", ValidationType.TYPE_FORMAT, "RelevantUnderlyingDateReference", path, "");
			})
			.collect(toList());
	}

}
