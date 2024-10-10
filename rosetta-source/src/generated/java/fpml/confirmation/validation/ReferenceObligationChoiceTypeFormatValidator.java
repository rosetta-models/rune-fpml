package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ReferenceObligationChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReferenceObligationChoiceTypeFormatValidator implements Validator<ReferenceObligationChoice> {

	private List<ComparisonResult> getComparisonResults(ReferenceObligationChoice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ReferenceObligationChoice> validate(RosettaPath path, ReferenceObligationChoice o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReferenceObligationChoice", ValidationType.TYPE_FORMAT, "ReferenceObligationChoice", path, "", error);
		}
		return success("ReferenceObligationChoice", ValidationType.TYPE_FORMAT, "ReferenceObligationChoice", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferenceObligationChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReferenceObligationChoice", ValidationType.TYPE_FORMAT, "ReferenceObligationChoice", path, "", res.getError());
				}
				return success("ReferenceObligationChoice", ValidationType.TYPE_FORMAT, "ReferenceObligationChoice", path, "");
			})
			.collect(toList());
	}

}
