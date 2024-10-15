package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.DeclearReason;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class DeclearReasonValidator implements Validator<DeclearReason> {

	private List<ComparisonResult> getComparisonResults(DeclearReason o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("declearReasonScheme", (String) o.getDeclearReasonScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<DeclearReason> validate(RosettaPath path, DeclearReason o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("DeclearReason", ValidationType.CARDINALITY, "DeclearReason", path, "", error);
		}
		return success("DeclearReason", ValidationType.CARDINALITY, "DeclearReason", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DeclearReason o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DeclearReason", ValidationType.CARDINALITY, "DeclearReason", path, "", res.getError());
				}
				return success("DeclearReason", ValidationType.CARDINALITY, "DeclearReason", path, "");
			})
			.collect(toList());
	}

}
