package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ReportingRegimeName;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReportingRegimeNameValidator implements Validator<ReportingRegimeName> {

	private List<ComparisonResult> getComparisonResults(ReportingRegimeName o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("reportingRegimeNameScheme", (String) o.getReportingRegimeNameScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ReportingRegimeName> validate(RosettaPath path, ReportingRegimeName o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReportingRegimeName", ValidationType.CARDINALITY, "ReportingRegimeName", path, "", error);
		}
		return success("ReportingRegimeName", ValidationType.CARDINALITY, "ReportingRegimeName", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportingRegimeName o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReportingRegimeName", ValidationType.CARDINALITY, "ReportingRegimeName", path, "", res.getError());
				}
				return success("ReportingRegimeName", ValidationType.CARDINALITY, "ReportingRegimeName", path, "");
			})
			.collect(toList());
	}

}
