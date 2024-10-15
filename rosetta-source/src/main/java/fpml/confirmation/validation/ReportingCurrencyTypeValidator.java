package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ReportingCurrencyType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReportingCurrencyTypeValidator implements Validator<ReportingCurrencyType> {

	private List<ComparisonResult> getComparisonResults(ReportingCurrencyType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("reportingCurrencyTypeScheme", (String) o.getReportingCurrencyTypeScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ReportingCurrencyType> validate(RosettaPath path, ReportingCurrencyType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReportingCurrencyType", ValidationType.CARDINALITY, "ReportingCurrencyType", path, "", error);
		}
		return success("ReportingCurrencyType", ValidationType.CARDINALITY, "ReportingCurrencyType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportingCurrencyType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReportingCurrencyType", ValidationType.CARDINALITY, "ReportingCurrencyType", path, "", res.getError());
				}
				return success("ReportingCurrencyType", ValidationType.CARDINALITY, "ReportingCurrencyType", path, "");
			})
			.collect(toList());
	}

}
