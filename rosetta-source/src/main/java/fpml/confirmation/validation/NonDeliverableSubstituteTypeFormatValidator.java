package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.NonDeliverableSubstitute;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class NonDeliverableSubstituteTypeFormatValidator implements Validator<NonDeliverableSubstitute> {

	private List<ComparisonResult> getComparisonResults(NonDeliverableSubstitute o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<NonDeliverableSubstitute> validate(RosettaPath path, NonDeliverableSubstitute o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("NonDeliverableSubstitute", ValidationType.TYPE_FORMAT, "NonDeliverableSubstitute", path, "", error);
		}
		return success("NonDeliverableSubstitute", ValidationType.TYPE_FORMAT, "NonDeliverableSubstitute", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NonDeliverableSubstitute o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NonDeliverableSubstitute", ValidationType.TYPE_FORMAT, "NonDeliverableSubstitute", path, "", res.getError());
				}
				return success("NonDeliverableSubstitute", ValidationType.TYPE_FORMAT, "NonDeliverableSubstitute", path, "");
			})
			.collect(toList());
	}

}
