package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ReportingNotionalChangeModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReportingNotionalChangeModelTypeFormatValidator implements Validator<ReportingNotionalChangeModel> {

	private List<ComparisonResult> getComparisonResults(ReportingNotionalChangeModel o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public ValidationResult<ReportingNotionalChangeModel> validate(RosettaPath path, ReportingNotionalChangeModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReportingNotionalChangeModel", ValidationType.TYPE_FORMAT, "ReportingNotionalChangeModel", path, "", error);
		}
		return success("ReportingNotionalChangeModel", ValidationType.TYPE_FORMAT, "ReportingNotionalChangeModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportingNotionalChangeModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReportingNotionalChangeModel", ValidationType.TYPE_FORMAT, "ReportingNotionalChangeModel", path, "", res.getError());
				}
				return success("ReportingNotionalChangeModel", ValidationType.TYPE_FORMAT, "ReportingNotionalChangeModel", path, "");
			})
			.collect(toList());
	}

}
