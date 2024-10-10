package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.Algorithm;
import fpml.confirmation.AlgorithmRole;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AlgorithmValidator implements Validator<Algorithm> {

	private List<ComparisonResult> getComparisonResults(Algorithm o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("name", (String) o.getName() != null ? 1 : 0, 1, 1), 
				checkCardinality("role", (AlgorithmRole) o.getRole() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<Algorithm> validate(RosettaPath path, Algorithm o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("Algorithm", ValidationType.CARDINALITY, "Algorithm", path, "", error);
		}
		return success("Algorithm", ValidationType.CARDINALITY, "Algorithm", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Algorithm o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Algorithm", ValidationType.CARDINALITY, "Algorithm", path, "", res.getError());
				}
				return success("Algorithm", ValidationType.CARDINALITY, "Algorithm", path, "");
			})
			.collect(toList());
	}

}
