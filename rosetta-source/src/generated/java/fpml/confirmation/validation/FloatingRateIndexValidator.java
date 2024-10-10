package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.FloatingRateIndex;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class FloatingRateIndexValidator implements Validator<FloatingRateIndex> {

	private List<ComparisonResult> getComparisonResults(FloatingRateIndex o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("floatingRateIndexScheme", (String) o.getFloatingRateIndexScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<FloatingRateIndex> validate(RosettaPath path, FloatingRateIndex o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("FloatingRateIndex", ValidationType.CARDINALITY, "FloatingRateIndex", path, "", error);
		}
		return success("FloatingRateIndex", ValidationType.CARDINALITY, "FloatingRateIndex", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRateIndex o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingRateIndex", ValidationType.CARDINALITY, "FloatingRateIndex", path, "", res.getError());
				}
				return success("FloatingRateIndex", ValidationType.CARDINALITY, "FloatingRateIndex", path, "");
			})
			.collect(toList());
	}

}
