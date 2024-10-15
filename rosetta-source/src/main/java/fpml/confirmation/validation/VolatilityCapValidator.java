package fpml.confirmation.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import fpml.confirmation.VolatilityCap;
import fpml.confirmation.VolatilityCapSequence;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperators.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class VolatilityCapValidator implements Validator<VolatilityCap> {

	private List<ComparisonResult> getComparisonResults(VolatilityCap o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("applicable", (Boolean) o.getApplicable() != null ? 1 : 0, 1, 1), 
				checkCardinality("totalVolatilityCap", (BigDecimal) o.getTotalVolatilityCap() != null ? 1 : 0, 0, 1), 
				checkCardinality("volatilityCapSequence", (VolatilityCapSequence) o.getVolatilityCapSequence() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public ValidationResult<VolatilityCap> validate(RosettaPath path, VolatilityCap o) {
		String error = getComparisonResults(o)
			.stream()
			.filter(res -> !res.get())
			.map(res -> res.getError())
			.collect(joining("; "));

		if (!isNullOrEmpty(error)) {
			return failure("VolatilityCap", ValidationType.CARDINALITY, "VolatilityCap", path, "", error);
		}
		return success("VolatilityCap", ValidationType.CARDINALITY, "VolatilityCap", path, "");
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, VolatilityCap o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("VolatilityCap", ValidationType.CARDINALITY, "VolatilityCap", path, "", res.getError());
				}
				return success("VolatilityCap", ValidationType.CARDINALITY, "VolatilityCap", path, "");
			})
			.collect(toList());
	}

}
