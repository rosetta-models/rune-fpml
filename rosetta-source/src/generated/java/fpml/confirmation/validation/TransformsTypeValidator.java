package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.TransformType;
import fpml.confirmation.TransformsType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class TransformsTypeValidator implements Validator<TransformsType> {

	private List<ComparisonResult> getComparisonResults(TransformsType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("transform", (List<? extends TransformType>) o.getTransform() == null ? 0 : ((List<? extends TransformType>) o.getTransform()).size(), 1, 0)
			);
	}

	@Override
	public ValidationResult<TransformsType> validate(RosettaPath path, TransformsType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("TransformsType", ValidationType.CARDINALITY, "TransformsType", path, "", error);
		}
		return success("TransformsType", ValidationType.CARDINALITY, "TransformsType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TransformsType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TransformsType", ValidationType.CARDINALITY, "TransformsType", path, "", res.getError());
				}
				return success("TransformsType", ValidationType.CARDINALITY, "TransformsType", path, "");
			})
			.collect(toList());
	}

}
