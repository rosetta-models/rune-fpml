package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AdjustableDateOrRelativeDateSequence;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AdjustableDateOrRelativeDateSequenceTypeFormatValidator implements Validator<AdjustableDateOrRelativeDateSequence> {

	private List<ComparisonResult> getComparisonResults(AdjustableDateOrRelativeDateSequence o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<AdjustableDateOrRelativeDateSequence> validate(RosettaPath path, AdjustableDateOrRelativeDateSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AdjustableDateOrRelativeDateSequence", ValidationType.TYPE_FORMAT, "AdjustableDateOrRelativeDateSequence", path, "", error);
		}
		return success("AdjustableDateOrRelativeDateSequence", ValidationType.TYPE_FORMAT, "AdjustableDateOrRelativeDateSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdjustableDateOrRelativeDateSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AdjustableDateOrRelativeDateSequence", ValidationType.TYPE_FORMAT, "AdjustableDateOrRelativeDateSequence", path, "", res.getError());
				}
				return success("AdjustableDateOrRelativeDateSequence", ValidationType.TYPE_FORMAT, "AdjustableDateOrRelativeDateSequence", path, "");
			})
			.collect(toList());
	}

}
