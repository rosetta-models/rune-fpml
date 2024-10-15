package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.AccruingFeeType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class AccruingFeeTypeValidator implements Validator<AccruingFeeType> {

	private List<ComparisonResult> getComparisonResults(AccruingFeeType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (String) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("accruingFeeTypeScheme", (String) o.getAccruingFeeTypeScheme() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<AccruingFeeType> validate(RosettaPath path, AccruingFeeType o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("AccruingFeeType", ValidationType.CARDINALITY, "AccruingFeeType", path, "", error);
		}
		return success("AccruingFeeType", ValidationType.CARDINALITY, "AccruingFeeType", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AccruingFeeType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AccruingFeeType", ValidationType.CARDINALITY, "AccruingFeeType", path, "", res.getError());
				}
				return success("AccruingFeeType", ValidationType.CARDINALITY, "AccruingFeeType", path, "");
			})
			.collect(toList());
	}

}
