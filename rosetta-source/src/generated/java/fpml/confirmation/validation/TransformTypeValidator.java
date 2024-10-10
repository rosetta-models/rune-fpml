package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TransformType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TransformTypeValidator implements Validator<TransformType> {

	private List<ComparisonResult> getComparisonResults(TransformType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("algorithm", (String) o.getAlgorithm() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<TransformType> validate(RosettaPath path, TransformType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TransformType", ValidationType.CARDINALITY, "TransformType", path, "", error);
		}
		return success("TransformType", ValidationType.CARDINALITY, "TransformType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TransformType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TransformType", ValidationType.CARDINALITY, "TransformType", path, "", res.getError());
				}
				return success("TransformType", ValidationType.CARDINALITY, "TransformType", path, "");
			})
			.collect(toList());
	}

}
