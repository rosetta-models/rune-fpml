package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AlgorithmRole;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AlgorithmRoleValidator implements Validator<AlgorithmRole> {

	private List<ComparisonResult> getComparisonResults(AlgorithmRole o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("algorithmRoleScheme", (String) o.getAlgorithmRoleScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<AlgorithmRole> validate(RosettaPath path, AlgorithmRole o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AlgorithmRole", ValidationType.CARDINALITY, "AlgorithmRole", path, "", error);
		}
		return success("AlgorithmRole", ValidationType.CARDINALITY, "AlgorithmRole", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AlgorithmRole o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AlgorithmRole", ValidationType.CARDINALITY, "AlgorithmRole", path, "", res.getError());
				}
				return success("AlgorithmRole", ValidationType.CARDINALITY, "AlgorithmRole", path, "");
			})
			.collect(toList());
	}

}
