package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TermPoint;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TermPointTypeFormatValidator implements Validator<TermPoint> {

	private List<ComparisonResult> getComparisonResults(TermPoint o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<TermPoint> validate(RosettaPath path, TermPoint o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TermPoint", ValidationType.TYPE_FORMAT, "TermPoint", path, "", error);
		}
		return success("TermPoint", ValidationType.TYPE_FORMAT, "TermPoint", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TermPoint o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TermPoint", ValidationType.TYPE_FORMAT, "TermPoint", path, "", res.getError());
				}
				return success("TermPoint", ValidationType.TYPE_FORMAT, "TermPoint", path, "");
			})
			.collect(toList());
	}

}
