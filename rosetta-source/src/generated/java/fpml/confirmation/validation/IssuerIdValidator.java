package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.IssuerId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class IssuerIdValidator implements Validator<IssuerId> {

	private List<ComparisonResult> getComparisonResults(IssuerId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("issuerIdScheme", (String) o.getIssuerIdScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<IssuerId> validate(RosettaPath path, IssuerId o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("IssuerId", ValidationType.CARDINALITY, "IssuerId", path, "", error);
		}
		return success("IssuerId", ValidationType.CARDINALITY, "IssuerId", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, IssuerId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("IssuerId", ValidationType.CARDINALITY, "IssuerId", path, "", res.getError());
				}
				return success("IssuerId", ValidationType.CARDINALITY, "IssuerId", path, "");
			})
			.collect(toList());
	}

}
