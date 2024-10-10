package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.ReasonCode;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ReasonCodeValidator implements Validator<ReasonCode> {

	private List<ComparisonResult> getComparisonResults(ReasonCode o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("reasonCodeScheme", (String) o.getReasonCodeScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<ReasonCode> validate(RosettaPath path, ReasonCode o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("ReasonCode", ValidationType.CARDINALITY, "ReasonCode", path, "", error);
		}
		return success("ReasonCode", ValidationType.CARDINALITY, "ReasonCode", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReasonCode o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReasonCode", ValidationType.CARDINALITY, "ReasonCode", path, "", res.getError());
				}
				return success("ReasonCode", ValidationType.CARDINALITY, "ReasonCode", path, "");
			})
			.collect(toList());
	}

}
