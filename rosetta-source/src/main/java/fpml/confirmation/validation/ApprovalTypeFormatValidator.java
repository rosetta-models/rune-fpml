package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Approval;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ApprovalTypeFormatValidator implements Validator<Approval> {

	private List<ComparisonResult> getComparisonResults(Approval o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<Approval> validate(RosettaPath path, Approval o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Approval", ValidationType.TYPE_FORMAT, "Approval", path, "", error);
		}
		return success("Approval", ValidationType.TYPE_FORMAT, "Approval", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Approval o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Approval", ValidationType.TYPE_FORMAT, "Approval", path, "", res.getError());
				}
				return success("Approval", ValidationType.TYPE_FORMAT, "Approval", path, "");
			})
			.collect(toList());
	}

}
