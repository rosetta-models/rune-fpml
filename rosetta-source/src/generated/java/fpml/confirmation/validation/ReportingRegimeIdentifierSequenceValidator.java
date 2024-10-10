package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ReportingRegimeIdentifierSequence;
import fpml.confirmation.ReportingRegimeName;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReportingRegimeIdentifierSequenceValidator implements Validator<ReportingRegimeIdentifierSequence> {

	private List<ComparisonResult> getComparisonResults(ReportingRegimeIdentifierSequence o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("name", (ReportingRegimeName) o.getName() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<ReportingRegimeIdentifierSequence> validate(RosettaPath path, ReportingRegimeIdentifierSequence o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReportingRegimeIdentifierSequence", ValidationType.CARDINALITY, "ReportingRegimeIdentifierSequence", path, "", error);
		}
		return success("ReportingRegimeIdentifierSequence", ValidationType.CARDINALITY, "ReportingRegimeIdentifierSequence", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReportingRegimeIdentifierSequence o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReportingRegimeIdentifierSequence", ValidationType.CARDINALITY, "ReportingRegimeIdentifierSequence", path, "", res.getError());
				}
				return success("ReportingRegimeIdentifierSequence", ValidationType.CARDINALITY, "ReportingRegimeIdentifierSequence", path, "");
			})
			.collect(toList());
	}

}
