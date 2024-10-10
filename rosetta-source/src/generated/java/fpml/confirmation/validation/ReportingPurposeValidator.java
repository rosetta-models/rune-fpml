package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ReportingPurpose;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReportingPurposeValidator implements Validator<ReportingPurpose> {

	private List<ComparisonResult> getComparisonResults(ReportingPurpose o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("reportingPurposeScheme", (String) o.getReportingPurposeScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ReportingPurpose> validate(RosettaPath path, ReportingPurpose o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReportingPurpose", ValidationType.CARDINALITY, "ReportingPurpose", path, "", error);
		}
		return success("ReportingPurpose", ValidationType.CARDINALITY, "ReportingPurpose", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportingPurpose o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReportingPurpose", ValidationType.CARDINALITY, "ReportingPurpose", path, "", res.getError());
				}
				return success("ReportingPurpose", ValidationType.CARDINALITY, "ReportingPurpose", path, "");
			})
			.collect(toList());
	}

}
