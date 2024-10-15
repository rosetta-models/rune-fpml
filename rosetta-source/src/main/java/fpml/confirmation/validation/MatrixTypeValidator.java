package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.MatrixType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MatrixTypeValidator implements Validator<MatrixType> {

	private List<ComparisonResult> getComparisonResults(MatrixType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("matrixTypeScheme", (String) o.getMatrixTypeScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<MatrixType> validate(RosettaPath path, MatrixType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("MatrixType", ValidationType.CARDINALITY, "MatrixType", path, "", error);
		}
		return success("MatrixType", ValidationType.CARDINALITY, "MatrixType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MatrixType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MatrixType", ValidationType.CARDINALITY, "MatrixType", path, "", res.getError());
				}
				return success("MatrixType", ValidationType.CARDINALITY, "MatrixType", path, "");
			})
			.collect(toList());
	}

}
