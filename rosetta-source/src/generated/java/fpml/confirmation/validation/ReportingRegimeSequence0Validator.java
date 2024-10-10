package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ReportingRegimeName;
import fpml.confirmation.ReportingRegimeSequence0;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReportingRegimeSequence0Validator implements Validator<ReportingRegimeSequence0> {

	private List<ComparisonResult> getComparisonResults(ReportingRegimeSequence0 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("name", (ReportingRegimeName) o.getName() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<ReportingRegimeSequence0> validate(RosettaPath path, ReportingRegimeSequence0 o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReportingRegimeSequence0", ValidationType.CARDINALITY, "ReportingRegimeSequence0", path, "", error);
		}
		return success("ReportingRegimeSequence0", ValidationType.CARDINALITY, "ReportingRegimeSequence0", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportingRegimeSequence0 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReportingRegimeSequence0", ValidationType.CARDINALITY, "ReportingRegimeSequence0", path, "", res.getError());
				}
				return success("ReportingRegimeSequence0", ValidationType.CARDINALITY, "ReportingRegimeSequence0", path, "");
			})
			.collect(toList());
	}

}
