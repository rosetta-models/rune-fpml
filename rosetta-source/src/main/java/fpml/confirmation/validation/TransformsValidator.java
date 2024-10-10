package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TransformType;
import fpml.confirmation.Transforms;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TransformsValidator implements Validator<Transforms> {

	private List<ComparisonResult> getComparisonResults(Transforms o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("transform", (List<? extends TransformType>) o.getTransform() == null ? 0 : ((List<? extends TransformType>) o.getTransform()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<Transforms> validate(RosettaPath path, Transforms o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Transforms", ValidationType.CARDINALITY, "Transforms", path, "", error);
		}
		return success("Transforms", ValidationType.CARDINALITY, "Transforms", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Transforms o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Transforms", ValidationType.CARDINALITY, "Transforms", path, "", res.getError());
				}
				return success("Transforms", ValidationType.CARDINALITY, "Transforms", path, "");
			})
			.collect(toList());
	}

}
