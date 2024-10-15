package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.OutstandingsPosition;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class OutstandingsPositionTypeFormatValidator implements Validator<OutstandingsPosition> {

	private List<ComparisonResult> getComparisonResults(OutstandingsPosition o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<OutstandingsPosition> validate(RosettaPath path, OutstandingsPosition o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("OutstandingsPosition", ValidationType.TYPE_FORMAT, "OutstandingsPosition", path, "", error);
		}
		return success("OutstandingsPosition", ValidationType.TYPE_FORMAT, "OutstandingsPosition", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OutstandingsPosition o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OutstandingsPosition", ValidationType.TYPE_FORMAT, "OutstandingsPosition", path, "", res.getError());
				}
				return success("OutstandingsPosition", ValidationType.TYPE_FORMAT, "OutstandingsPosition", path, "");
			})
			.collect(toList());
	}

}
