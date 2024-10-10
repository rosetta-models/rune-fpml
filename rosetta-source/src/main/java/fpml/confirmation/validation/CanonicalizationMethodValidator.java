package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.CanonicalizationMethod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CanonicalizationMethodValidator implements Validator<CanonicalizationMethod> {

	private List<ComparisonResult> getComparisonResults(CanonicalizationMethod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("algorithm", (String) o.getAlgorithm() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<CanonicalizationMethod> validate(RosettaPath path, CanonicalizationMethod o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("CanonicalizationMethod", ValidationType.CARDINALITY, "CanonicalizationMethod", path, "", error);
		}
		return success("CanonicalizationMethod", ValidationType.CARDINALITY, "CanonicalizationMethod", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CanonicalizationMethod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CanonicalizationMethod", ValidationType.CARDINALITY, "CanonicalizationMethod", path, "", res.getError());
				}
				return success("CanonicalizationMethod", ValidationType.CARDINALITY, "CanonicalizationMethod", path, "");
			})
			.collect(toList());
	}

}
