package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CorrelationId;
import fpml.confirmation.CorrelationIdModel;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CorrelationIdModelValidator implements Validator<CorrelationIdModel> {

	private List<ComparisonResult> getComparisonResults(CorrelationIdModel o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("correlationId", (CorrelationId) o.getCorrelationId() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CorrelationIdModel> validate(RosettaPath path, CorrelationIdModel o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CorrelationIdModel", ValidationType.CARDINALITY, "CorrelationIdModel", path, "", error);
		}
		return success("CorrelationIdModel", ValidationType.CARDINALITY, "CorrelationIdModel", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CorrelationIdModel o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CorrelationIdModel", ValidationType.CARDINALITY, "CorrelationIdModel", path, "", res.getError());
				}
				return success("CorrelationIdModel", ValidationType.CARDINALITY, "CorrelationIdModel", path, "");
			})
			.collect(toList());
	}

}
