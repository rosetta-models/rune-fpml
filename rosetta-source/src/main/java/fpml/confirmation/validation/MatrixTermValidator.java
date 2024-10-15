package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.MatrixTerm;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class MatrixTermValidator implements Validator<MatrixTerm> {

	private List<ComparisonResult> getComparisonResults(MatrixTerm o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("matrixTermScheme", (String) o.getMatrixTermScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<MatrixTerm> validate(RosettaPath path, MatrixTerm o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("MatrixTerm", ValidationType.CARDINALITY, "MatrixTerm", path, "", error);
		}
		return success("MatrixTerm", ValidationType.CARDINALITY, "MatrixTerm", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MatrixTerm o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MatrixTerm", ValidationType.CARDINALITY, "MatrixTerm", path, "", res.getError());
				}
				return success("MatrixTerm", ValidationType.CARDINALITY, "MatrixTerm", path, "");
			})
			.collect(toList());
	}

}
