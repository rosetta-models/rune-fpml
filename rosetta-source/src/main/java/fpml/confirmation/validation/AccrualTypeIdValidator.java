package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AccrualTypeId;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AccrualTypeIdValidator implements Validator<AccrualTypeId> {

	private List<ComparisonResult> getComparisonResults(AccrualTypeId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("accrualTypeIdScheme", (String) o.getAccrualTypeIdScheme() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public ValidationResult<AccrualTypeId> validate(RosettaPath path, AccrualTypeId o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AccrualTypeId", ValidationType.CARDINALITY, "AccrualTypeId", path, "", error);
		}
		return success("AccrualTypeId", ValidationType.CARDINALITY, "AccrualTypeId", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AccrualTypeId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AccrualTypeId", ValidationType.CARDINALITY, "AccrualTypeId", path, "", res.getError());
				}
				return success("AccrualTypeId", ValidationType.CARDINALITY, "AccrualTypeId", path, "");
			})
			.collect(toList());
	}

}
