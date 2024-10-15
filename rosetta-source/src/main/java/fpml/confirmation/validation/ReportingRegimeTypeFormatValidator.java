package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ReportingRegime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReportingRegimeTypeFormatValidator implements Validator<ReportingRegime> {

	private List<ComparisonResult> getComparisonResults(ReportingRegime o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ReportingRegime> validate(RosettaPath path, ReportingRegime o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReportingRegime", ValidationType.TYPE_FORMAT, "ReportingRegime", path, "", error);
		}
		return success("ReportingRegime", ValidationType.TYPE_FORMAT, "ReportingRegime", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportingRegime o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReportingRegime", ValidationType.TYPE_FORMAT, "ReportingRegime", path, "", res.getError());
				}
				return success("ReportingRegime", ValidationType.TYPE_FORMAT, "ReportingRegime", path, "");
			})
			.collect(toList());
	}

}
