package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CorrelationId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CorrelationIdValidator implements Validator<CorrelationId> {

	private List<ComparisonResult> getComparisonResults(CorrelationId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("correlationIdScheme", (String) o.getCorrelationIdScheme() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CorrelationId> validate(RosettaPath path, CorrelationId o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CorrelationId", ValidationType.CARDINALITY, "CorrelationId", path, "", error);
		}
		return success("CorrelationId", ValidationType.CARDINALITY, "CorrelationId", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CorrelationId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CorrelationId", ValidationType.CARDINALITY, "CorrelationId", path, "", res.getError());
				}
				return success("CorrelationId", ValidationType.CARDINALITY, "CorrelationId", path, "");
			})
			.collect(toList());
	}

}
